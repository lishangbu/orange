package io.github.lishangbu.orange.rbac.service.impl;

import io.github.lishangbu.orange.rbac.entity.Organization;
import io.github.lishangbu.orange.rbac.mapper.OrganizationMapper;
import io.github.lishangbu.orange.rbac.model.OrganizationTreeNode;
import io.github.lishangbu.orange.rbac.service.OrganizationService;
import io.github.lishangbu.orange.web.util.TreeUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

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
  private final OrganizationMapper organizationMapper;

  /**
   * 新增组织信息
   *
   * @param organization 组织实体
   * @return 新增后的组织实体
   */
  @Override
  public Organization saveOrganization(Organization organization) {
    organizationMapper.insert(organization);
    return organization;
  }

  /**
   * 根据ID更新组织信息
   *
   * @param organization 组织实体
   */
  @Override
  public void updateOrganization(Organization organization) {
    organizationMapper.updateById(organization);
  }

  /**
   * 根据ID删除组织
   *
   * @param id 组织ID
   */
  @Override
  public void deleteOrganization(Long id) {
    organizationMapper.deleteById(id);
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
   * <p>
   * 业务逻辑：
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
   * <p>
   * 根据指定父组织ID，返回其所有下级组织（多级），不包含父节点本身
   * 结果按 sortOrder、id 升序排列
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
   * 将组织实体列表转换为树节点并构建组织树结构
   *
   * <ol>
   *   <li>处理空集合，返回不可变空列表
   *   <li>将 Organization 映射为 OrganizationTreeNode
   *   <li>使用通用的 {@link TreeUtils} 构建树，根父ID为0
   * </ol>
   *
   * @param organizations 组织实体列表，允许为 null
   * @param parentId      根父ID，通常为0
   * @return 树结构的 OrganizationTreeNode 列表，永远不返回 null
   * @see io.github.lishangbu.orange.web.util.TreeUtils#buildTree(List, java.util.function.Function, java.util.function.Function, java.util.function.Function, java.util.function.BiConsumer, Object)
   */
  private List<OrganizationTreeNode> buildTreeFromOrganizations(List<Organization> organizations, Long parentId) {
    if (organizations == null || organizations.isEmpty()) {
      return java.util.Collections.emptyList();
    }
    List<OrganizationTreeNode> treeNodes = organizations.stream()
      .map(OrganizationTreeNode::new)
      .collect(java.util.stream.Collectors.toList());
    return io.github.lishangbu.orange.web.util.TreeUtils.buildTree(
      treeNodes,
      OrganizationTreeNode::getId,
      OrganizationTreeNode::getParentId,
      OrganizationTreeNode::getChildren,
      OrganizationTreeNode::setChildren,
      parentId
    );
  }
}
