package io.github.lishangbu.orange.rbac.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.lishangbu.orange.rbac.entity.Organization;
import io.github.lishangbu.orange.rbac.model.OrganizationTreeNode;
import io.github.lishangbu.orange.rbac.service.OrganizationService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 组织控制器
 *
 * <p>提供组织的分页、条件查询、增删改查等 RESTFUL API 支持多级组织架构的管理与查询
 *
 * @author lishangbu
 * @since 2025/10/16
 */
@RestController
@RequestMapping("/organization")
@RequiredArgsConstructor
public class OrganizationController {

  private final OrganizationService organizationService;

  /**
   * 分页查询角色列表
   *
   * <p>
   *
   * @param page 分页参数，包含页码和每页大小
   * @param condition 查询条件，包含角色代码、名称、启用状态等字段
   * @return 角色分页数据，包含列表和分页信息
   */
  @GetMapping("/page")
  public IPage<OrganizationTreeNode> page(Page<Organization> page, Organization condition) {
    return organizationService.getPageByOrganization(page, condition);
  }

  /**
   * 新增组织
   *
   * @param organization 组织实体，包含名称、启用状态等信息
   * @return 新增后的组织实体
   */
  @PostMapping
  public Organization create(@RequestBody @Valid Organization organization) {
    return organizationService.saveOrganization(organization);
  }

  /**
   * 根据ID更新组织信息
   *
   * @param organization 组织实体，包含需更新的字段，ID不能为空
   */
  @PutMapping
  public void update(@RequestBody @Valid Organization organization) {
    organizationService.updateOrganization(organization);
  }

  /**
   * 根据ID删除组织
   *
   * @param id 组织ID
   */
  @DeleteMapping("/ancestor/{id:\\d+}")
  public void removeOrganizationByAncestorId(@PathVariable Long id) {
    organizationService.removeOrganizationByAncestorId(id);
  }

  /**
   * 批量删除组织
   *
   * <p>支持使用逗号分隔的路径参数传递多个 ID，例如 /1,2,3
   *
   * @param ids 组织ID列表，不能为空且元素为正整数
   */
  @DeleteMapping("/ancestors/{ids:\\d+(?:,\\d+)*}")
  public void removeOrganizationByAncestorIds(@PathVariable List<Long> ids) {
    organizationService.removeOrganizationByAncestorIds(ids);
  }

  /**
   * 根据ID查询组织详情
   *
   * @param id 组织ID
   * @return 组织实体，未找到时返回null
   */
  @GetMapping("/{id:\\d+}")
  public Organization getById(@PathVariable Long id) {
    return organizationService.getOrganizationById(id);
  }

  /**
   * 查询指定组织及其所有下级组织（含自身）
   *
   * <p>根据组织ID，递归返回该节点及其所有子孙节点，结果按 sortOrder、id 升序排列
   *
   * @param id 组织ID
   * @return 组织及其所有下级组织列表
   */
  @GetMapping("/tree/descendants/{id:\\d+}")
  public List<OrganizationTreeNode> getOrganizationWithDescendants(@PathVariable Long id) {
    return organizationService.getOrganizationWithDescendants(id);
  }

  /**
   * 递归查询所有子节点（不包含当前节点）
   *
   * <p>根据指定父组织ID，返回其所有下级组织（多级），不包含父节点本身 结果按 sortOrder、id 升序排列
   *
   * @param parentId 父组织ID
   * @return 所有子孙节点的组织列表
   */
  @GetMapping("/tree/children/{parentId:\\d+}")
  public List<OrganizationTreeNode> listAllChildrenByParentId(@PathVariable Long parentId) {
    return organizationService.listAllChildrenByParentId(parentId);
  }
}
