package io.github.lishangbu.orange.authorization.service;

import io.github.lishangbu.orange.authorization.model.UserWithRoles;
import java.util.Optional;

/**
 * 用户服务
 *
 * @author lishangbu
 * @since 2025/8/30
 */
public interface UserService {

  /**
   * 根据用户名查询用户详情，包含基本信息、角色信息及个人资料
   *
   * @param username 用户名
   * @return 查询到的用户详情，未找到时返回Optional.empty()
   */
  Optional<UserWithRoles> getUserByUsername(String username);
}
