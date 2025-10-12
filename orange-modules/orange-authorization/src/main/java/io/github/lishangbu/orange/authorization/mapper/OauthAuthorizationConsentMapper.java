package io.github.lishangbu.orange.authorization.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.lishangbu.orange.authorization.entity.OauthAuthorizationConsent;
import java.util.Optional;

/**
 * 用户授权确认表(oauth_authorization_consent)数据库访问层
 *
 * @author lishangbu
 * @since 2025/9/14
 */
public interface OauthAuthorizationConsentMapper extends BaseMapper<OauthAuthorizationConsent> {
  Optional<OauthAuthorizationConsent> selectByRegisteredClientIdAndPrincipalName(
      String registeredClientId, String principalName);

  void deleteByRegisteredClientIdAndPrincipalName(String registeredClientId, String principalName);
}
