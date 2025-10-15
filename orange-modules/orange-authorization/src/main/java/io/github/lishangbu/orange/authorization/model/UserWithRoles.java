package io.github.lishangbu.orange.authorization.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.lishangbu.orange.authorization.entity.Role;
import java.util.List;
import lombok.Data;

/**
 * 用户(包含角色信息)用于前端展示
 *
 * @author lishangbu
 * @since 2025/9/19
 */
@Data
public class UserWithRoles {
  private Long id;
  private String username;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String password;

  private List<Role> roles;
}
