package io.github.lishangbu.orange.rbac.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.lishangbu.orange.rbac.entity.Organization;
import io.github.lishangbu.orange.rbac.mapper.OrganizationMapper;
import io.github.lishangbu.orange.rbac.model.OrganizationTreeNode;
import io.github.lishangbu.orange.rbac.service.OrganizationService;
import io.github.lishangbu.orange.web.util.TreeUtils;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

/**
 * 组织信息服务实现类
 *
 * <p>实现组织的分页、条件查询、增删改查等核心业务逻辑
 *
 * @author lishangbu
 * @since 2025/10/16
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
  private static final long TOP_LEVEL_PARENT_ID = 0L;
  private final OrganizationMapper organizationMapper;

  /**
   * 新增组织信息，自动维护顶级组织ID
   *
   * <p>根据 parentId 判断组织的 rootId：
   *
   * <ul>
   *   <li>顶级组织（parentId=0）：插入后 rootId=自身 id
   *   <li>非顶级组织：rootId=父组织.rootId
   * </ul>
   *
   * @param organization 组织实体
   * @return 新增后的组织实体
   */
  @Override
  @Transactional(rollbackFor = Exception.class)
  public Organization saveOrganization(Organization organization) {
    if (organization.getParentId() == TOP_LEVEL_PARENT_ID) {
      // 顶级组织，rootId待插入后更新
      organization.setRootId(TOP_LEVEL_PARENT_ID);
      organizationMapper.insert(organization);
      // 插入后 rootId 设为自身 id
      organization.setRootId(organization.getId());
      organizationMapper.updateById(organization);
    } else {
      // 非顶级组织，需查询父组织以继承 rootId
      Organization parent = organizationMapper.selectById(organization.getParentId());
      Assert.notNull(parent, "父组织不存在，无法新增");
      organization.setRootId(parent.getRootId());
      organizationMapper.insert(organization);
    }
    return organization;
  }

  /**
   * 根据ID更新组织信息
   *
   * @param organization 组织实体
   */
  @Override
  @Transactional(rollbackFor = Exception.class)
  public void updateOrganization(Organization organization) {
    organizationMapper.updateById(organization);
  }

  /**
   * 根据ID删除组织,包括其所有下级组织
   *
   * @param id 组织ID
   */
  @Override
  @Transactional(rollbackFor = Exception.class)
  public void removeOrganizationByAncestorId(Long id) {
    List<Organization> organizations = organizationMapper.selectOrganizationWithDescendantsById(id);
    if (CollectionUtils.isEmpty(organizations)) {
      return;
    }
    organizationMapper.deleteByIds(organizations.stream().map(Organization::getId).toList());
  }

  /**
   * 根据祖先ID列表删除组织
   *
   * @param ids 祖先组织ID列表
   */
  @Override
  @Transactional(rollbackFor = Exception.class)
  public void removeOrganizationByAncestorIds(List<Long> ids) {
    if (CollectionUtils.isEmpty(ids)) {
      return;
    }
    ids.forEach(this::removeOrganizationByAncestorId);
  }

  /**
   * 根据ID查询组织详情
   *
   * @param id 组织ID
   * @return 组织实体
   */
  @Override
  public Organization getOrganizationById(Long id) {
    return organizationMapper.selectById(id);
  }

  /**
   * 查询指定组织及其所有下级组织（含自身），并构建树结构
   *
   * <p>业务逻辑：
   *
   * <ol>
   *   <li>根据组织ID查询组织实体，若不存在则返回空列表
   *   <li>递归查询该组织及所有子孙节点，按 sortOrder、id 升序排列
   *   <li>将所有结果转换为树节点，使用 {@link TreeUtils} 构建组织树，根父ID为当前组织的 parentId
   * </ol>
   *
   * @param id 组织ID，不能为空
   * @return 组织树结构（含自身及所有下级），永不为 null
   */
  @Override
  @NonNull
  public List<OrganizationTreeNode> getOrganizationWithDescendants(@NonNull Long id) {
    Organization organization = organizationMapper.selectById(id);
    if (organization == null) {
      return Collections.emptyList();
    }
    List<Organization> organizations = organizationMapper.selectOrganizationWithDescendantsById(id);
    log.debug("根据组织ID获取到 [{}] 条组织记录", organizations == null ? 0 : organizations.size());
    return buildTreeFromOrganizations(organizations, organization.getParentId());
  }

  /**
   * 递归查询所有子节点（不包含当前节点）
   *
   * <p>根据指定父组织ID，返回其所有下级组织（多级），不包含父节点本身 结果按 sortOrder、id 升序排列
   *
   * @param parentId 父组织ID，不能为空
   * @return 所有子孙节点的组织列表
   */
  @Override
  @NonNull
  public List<OrganizationTreeNode> listAllChildrenByParentId(@NonNull Long parentId) {
    List<Organization> organizations = organizationMapper.selectAllChildrenByParentId(parentId);
    log.debug("根据父组织ID获取到 [{}] 条组织记录", organizations == null ? 0 : organizations.size());
    return buildTreeFromOrganizations(organizations, parentId);
  }

  /**
   * 将组织分页查询并转换为树节点形式的分页结果
   *
   * <p>根据传入的分页参数和动态查询条件进行组织数据的分页查询，支持按 id、name、code、enabled、parentId 等字段进行过滤 查询结果会被映射为 {@link
   * OrganizationTreeNode}，便于前端直接构建组织树或展示层级信息
   *
   * <ol>
   *   <li>若 {@code condition} 为 null，则视为无过滤条件，查询所有组织
   *   <li>分页参数 {@code page} 用于指定页码和每页数量，不能为空
   *   <li>返回结果按 {@code sort_order}、{@code id} 升序排列，分页信息保留在返回的 {@link IPage}
   * </ol>
   *
   * @param page 分页参数，包含当前页码和每页大小，不能为空
   * @param condition 动态查询条件，允许为 null，常用字段：id、name、code、enabled、parentId
   * @return 包含 {@link OrganizationTreeNode} 的分页数据，永远不返回 null
   */
  @Override
  public IPage<OrganizationTreeNode> getPageByOrganization(
      IPage<Organization> page, Organization condition) {
    List<Organization> organizations = organizationMapper.selectListByOrganization(condition);
    if (CollectionUtils.isEmpty(organizations)) {
      return new Page<>(page.getCurrent(), page.getSize(), 0L);
    }
    // 获取当前页所有顶级组织 id
    List<Long> organizationIds = organizations.stream().map(Organization::getId).toList();
    IPage<Long> rootIdPage = organizationMapper.selectRootIdByIds(page, organizationIds);

    // 查询所有顶级组织及其子孙节点
    organizations =
        organizationMapper.selectOrganizationsWithDescendantsByIds(rootIdPage.getRecords());
    IPage<OrganizationTreeNode> result =
        new Page<>(rootIdPage.getCurrent(), rootIdPage.getSize(), rootIdPage.getTotal());
    if (!CollectionUtils.isEmpty(organizations)) {
      result.setRecords(buildTreeFromOrganizations(organizations, 0L));
    }
    return result;
  }

  /**
   * 将组织实体列表转换为树节点并构建组织树结构
   *
   * <ol>
   *   <li>处理空集合，返回不可变空列表
   *   <li>将 Organization 映射为 OrganizationTreeNode
   *   <li>使用通用的 {@link TreeUtils} 构建树，根父ID为0
   * </ol>
   *
   * @param organizations 组织实体列表，允许为 null
   * @param parentId 根父ID，通常为0
   * @return 树结构的 OrganizationTreeNode 列表，永远不返回 null
   * @see io.github.lishangbu.orange.web.util.TreeUtils#buildTree(List, java.util.function.Function,
   *     java.util.function.Function, java.util.function.Function, java.util.function.BiConsumer,
   *     Object)
   */
  private List<OrganizationTreeNode> buildTreeFromOrganizations(
      List<Organization> organizations, Long parentId) {
    if (organizations == null || organizations.isEmpty()) {
      return java.util.Collections.emptyList();
    }
    List<OrganizationTreeNode> treeNodes =
        organizations.stream()
            .map(OrganizationTreeNode::new)
            .collect(java.util.stream.Collectors.toList());
    return io.github.lishangbu.orange.web.util.TreeUtils.buildTree(
        treeNodes,
        OrganizationTreeNode::getId,
        OrganizationTreeNode::getParentId,
        OrganizationTreeNode::getChildren,
        OrganizationTreeNode::setChildren,
        parentId);
  }
}
