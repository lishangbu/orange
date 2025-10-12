package io.github.lishangbu.orange.authorization.entity;

import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户授权确认表(OauthAuthorizationConsent)实体类
 *
 * @author lishangbu
 * @since 2025/08/20
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class OauthAuthorizationConsent implements Serializable {
  @Serial private static final long serialVersionUID = 1L;

  /** 当前授权确认的客户端id */
  private Long id;

  private String registeredClientId;

  /** 当前授权确认用户的 username */
  private String principalName;

  /** 授权确认的scope */
  private String authorities;
}
