package io.github.lishangbu.orange.authorization.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.lishangbu.orange.authorization.entity.OauthRegisteredClient;
import java.util.Optional;

/**
 * Oauth2注册客户端(oauth_registered_client)表数据库访问层
 *
 * @author lishangbu
 * @since 2025/9/14
 */
public interface OauthRegisteredClientMapper extends BaseMapper<OauthRegisteredClient> {

  /**
   * 根据 clientId 查询注册客户端信息
   *
   * @param clientId 客户端ID
   * @return 匹配的注册客户端信息
   */
  Optional<OauthRegisteredClient> selectByClientId(String clientId);
}
