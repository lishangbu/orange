package io.github.lishangbu.orange.rbac.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.lishangbu.orange.rbac.entity.Organization;
import io.github.lishangbu.orange.rbac.service.OrganizationService;
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
   * 分页查询组织列表
   *
   * @param page 分页参数，包含页码和每页大小
   * @param condition 查询条件，包含名称、启用状态等字段
   * @return 组织分页数据，包含组织列表和分页信息
   */
  @GetMapping("/page")
  public IPage<Organization> page(Page<Organization> page, Organization condition) {
    return organizationService.getPageByOrganization(page, condition);
  }

  /**
   * 新增组织
   *
   * @param organization 组织实体，包含名称、启用状态等信息
   * @return 新增后的组织实体
   */
  @PostMapping
  public Organization create(@RequestBody Organization organization) {
    return organizationService.saveOrganization(organization);
  }

  /**
   * 根据ID更新组织信息
   *
   * @param organization 组织实体，包含需更新的字段，ID不能为空
   */
  @PutMapping
  public void update(@RequestBody Organization organization) {
    organizationService.updateOrganization(organization);
  }

  /**
   * 根据ID删除组织
   *
   * @param id 组织ID
   */
  @DeleteMapping("/{id:\\d+}")
  public void delete(@PathVariable Long id) {
    organizationService.deleteOrganization(id);
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
}
