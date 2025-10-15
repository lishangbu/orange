package io.github.lishangbu.orange.authorization.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.lishangbu.orange.authorization.entity.Role;

/**
 * 角色服务
 *
 * @author lishangbu
 * @since 2025/8/30
 */
public interface RoleService {

  /**
   * 分页查询角色列表
   *
   * <p>支持按角色代码、名称、启用状态等条件进行模糊查询，结果按创建时间倒序排列
   *
   * @param page 分页参数，包含页码和每页大小
   * @param roleCondition 查询条件，包含角色代码、名称、启用状态等字段
   * @return 角色分页数据，包含角色列表和分页信息
   */
  IPage<Role> getPageByRole(IPage<Role> page, Role roleCondition);

  /**
   * 新增角色
   *
   * <p>创建一个新的角色信息
   *
   * @param role 角色实体，包含代码、名称、启用状态等信息
   * @return 新增后的角色实体
   */
  Role saveRole(Role role);

  /**
   * 根据ID更新角色信息
   *
   * <p>支持更新角色代码、名称、启用状态等字段
   *
   * @param role 角色实体，包含需更新的字段，ID不能为空
   */
  void updateRole(Role role);

  /**
   * 根据ID删除角色
   *
   * <p>物理删除角色信息
   *
   * @param id 角色ID
   */
  void deleteRole(Long id);

  /**
   * 根据ID查询角色详情
   *
   * <p>返回指定ID的角色信息
   *
   * @param id 角色ID
   * @return 角色实体，未找到时返回null
   */
  Role getRoleById(Long id);
}
