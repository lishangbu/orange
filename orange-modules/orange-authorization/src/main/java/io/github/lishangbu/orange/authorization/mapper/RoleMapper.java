package io.github.lishangbu.orange.authorization.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.lishangbu.orange.authorization.entity.Role;

/**
 * 角色信息(role)表数据库访问层
 *
 * <p>提供角色的基础CRUD操作及分页模糊查询功能 支持按角色代码、名称、启用状态等条件分页查询
 *
 * @author lishangbu
 * @since 2025/08/20
 */
public interface RoleMapper extends BaseMapper<Role> {
  /**
   * 分页模糊查询角色列表
   *
   * <p>支持按角色代码、名称、启用状态等条件进行模糊查询，结果按ID倒序排列
   *
   * @param page 分页参数，包含页码和每页大小
   * @param role 查询条件，包含角色代码、名称、启用状态等字段
   * @return 角色分页数据，包含角色列表和分页信息
   */
  IPage<Role> selectPageByRole(IPage<Role> page, Role role);
}
