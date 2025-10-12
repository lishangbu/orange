package io.github.lishangbu.orange.authorization.model;

import lombok.Data;

/**
 * 用户(包含角色代码信息)
 *
 * @author lishangbu
 * @since 2025/9/19
 */
@Data
public class UserWithRoleCodes {
  private Long id;
  private String username;
  private String password;
  private String roleCodes;
}
