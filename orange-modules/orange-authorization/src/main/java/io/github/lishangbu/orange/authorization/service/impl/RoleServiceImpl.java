package io.github.lishangbu.orange.authorization.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.lishangbu.orange.authorization.entity.Role;
import io.github.lishangbu.orange.authorization.mapper.RoleMapper;
import io.github.lishangbu.orange.authorization.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 角色信息服务实现类
 *
 * @author lishangbu
 * @since 2025/8/30
 */
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
  private final RoleMapper roleMapper;

  @Override
  public IPage<Role> getPageByRole(IPage<Role> page, Role roleCondition) {
    return roleMapper.selectPageByRole(page, roleCondition);
  }

  /**
   * 新增角色
   *
   * <p>创建一个新的角色信息
   *
   * @param role 角色实体，包含代码、名称、启用状态等信息
   * @return 新增后的角色实体
   */
  @Override
  @Transactional
  public Role saveRole(Role role) {
    roleMapper.insert(role);
    return role;
  }

  /**
   * 根据ID更新角色信息
   *
   * <p>支持更新角色代码、名称、启用状态等字段
   *
   * @param role 角色实体，包含需更新的字段，ID不能为空
   */
  @Override
  @Transactional(rollbackFor = Exception.class)
  public void updateRole(Role role) {
    roleMapper.updateById(role);
  }

  /**
   * 根据ID删除角色
   *
   * <p>物理删除角色信息
   *
   * @param id 角色ID
   * @return 删除成功返回true，否则返回false
   */
  @Override
  @Transactional(rollbackFor = Exception.class)
  public void deleteRole(Long id) {
    roleMapper.deleteById(id);
  }

  /**
   * 根据ID查询角色详情
   *
   * <p>返回指定ID的角色信息
   *
   * @param id 角色ID
   * @return 角色实体，未找到时返回null
   */
  @Override
  public Role getRoleById(Long id) {
    return roleMapper.selectById(id);
  }
}
