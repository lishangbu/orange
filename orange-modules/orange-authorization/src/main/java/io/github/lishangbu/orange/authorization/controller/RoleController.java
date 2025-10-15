package io.github.lishangbu.orange.authorization.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.lishangbu.orange.authorization.entity.Role;
import io.github.lishangbu.orange.authorization.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 角色控制器
 *
 * @author lishangbu
 * @since 2025/8/30
 */
@RequestMapping("/role")
@RestController
@RequiredArgsConstructor
public class RoleController {

  private final RoleService roleService;

  /**
   * 分页查询角色列表
   *
   * <p>
   *
   * @param page 分页参数，包含页码和每页大小
   * @param condition 查询条件，包含角色代码、名称、启用状态等字段
   * @return 角色分页数据，包含角色列表和分页信息
   */
  @GetMapping("/page")
  public IPage<Role> page(Page<Role> page, Role condition) {
    return roleService.getPageByRole(page, condition);
  }

  /**
   * 新增角色
   *
   * <p>创建一个新的角色信息
   *
   * @param role 角色实体，包含代码、名称、启用状态等信息
   * @return 新增后的角色实体
   */
  @PostMapping
  public Role create(@RequestBody Role role) {
    return roleService.saveRole(role);
  }

  /**
   * 根据ID更新角色信息
   *
   * <p>支持更新角色代码、名称、启用状态等字段
   *
   * @param role 角色实体，包含需更新的字段
   * @return 更新后的角色实体
   */
  @PutMapping
  public void update(@RequestBody Role role) {
    roleService.updateRole(role);
  }

  /**
   * 根据ID删除角色
   *
   * <p>物理删除角色信息
   *
   * @param id 角色ID
   * @return 删除成功返回true，否则返回false
   */
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    roleService.deleteRole(id);
  }

  /**
   * 根据ID查询角色详情
   *
   * <p>返回指定ID的角色信息
   *
   * @param id 角色ID
   * @return 角色实体，未找到时返回null
   */
  @GetMapping("/{id}")
  public Role getById(@PathVariable Long id) {
    return roleService.getRoleById(id);
  }
}
