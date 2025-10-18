package io.github.lishangbu.orange.rbac.service;

import io.github.lishangbu.orange.rbac.entity.Organization;
import io.github.lishangbu.orange.rbac.model.OrganizationTreeNode;
import org.jspecify.annotations.NonNull;

import java.util.List;

/**
 * 组织信息服务接口
 *
 * <p>定义组织相关的核心业务操作，支持分页、条件查询、增删改查等功能
 *
 * @author lishangbu
 * @since 2025/10/16
 */
public interface OrganizationService {

  /**
   * 新增组织信息
   *
   * <p>创建一个新的组织信息
   *
   * @param organization 组织实体，包含名称、启用状态等信息
   * @return 新增后的组织实体
   */
  Organization saveOrganization(Organization organization);

  /**
   * 根据ID更新组织信息
   *
   * <p>支持更新名称、启用状态等字段
   *
   * @param organization 组织实体，包含需更新的字段，ID不能为空
   */
  void updateOrganization(Organization organization);

  /**
   * 根据ID删除组织
   *
   * <p>物理删除组织信息
   *
   * @param id 组织ID
   */
  void deleteOrganization(Long id);

  /**
   * 根据ID查询组织详情
   *
   * <p>返回指定ID的组织信息
   *
   * @param id 组织ID
   * @return 组织实体，未找到时返回null
   */
  Organization getOrganizationById(Long id);

  /**
   * 查询指定组织及其所有下级组织（含自身）
   * <p>
   * 根据组织ID，递归返回该节点及其所有子孙节点，结果按 sortOrder、id 升序排列
   *
   * @param id 组织ID，不能为空
   * @return 组织及其所有下级组织列表
   */
  @NonNull
  List<OrganizationTreeNode> getOrganizationWithDescendants(@NonNull Long id);

  /**
   * 递归查询所有子节点（不包含当前节点）
   * <p>
   * 根据指定父组织ID，返回其所有下级组织（多级），不包含父节点本身
   * 结果按 sortOrder、id 升序排列
   *
   * @param parentId 父组织ID，不能为空
   * @return 所有子孙节点的组织列表
   */
  @NonNull
  List<OrganizationTreeNode> listAllChildrenByParentId(@NonNull Long parentId);
}
