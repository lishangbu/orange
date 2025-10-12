package io.github.lishangbu.orange.authorization.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.lishangbu.orange.authorization.entity.OauthAuthorization;
import java.util.Optional;
import org.apache.ibatis.annotations.Param;

/**
 * 用户认证信息表(oauth_authorization)表数据库访问层
 *
 * <p>提供对认证信息的多字段查询操作
 *
 * @author lishangbu
 * @since 2025/9/14
 */
public interface OauthAuthorizationMapper extends BaseMapper<OauthAuthorization> {
  /**
   * 根据 state 查询认证信息
   *
   * <p>通过 state 字段精确查询认证信息
   *
   * @param state 状态码
   * @return 匹配的认证信息
   */
  Optional<OauthAuthorization> selectByState(@Param("state") String state);

  /**
   * 根据授权码查询认证信息
   *
   * <p>通过授权码字段精确查询认证信息
   *
   * @param authorizationCode 授权码
   * @return 匹配的认证信息
   */
  Optional<OauthAuthorization> selectByAuthorizationCodeValue(
      @Param("authorizationCode") String authorizationCode);

  /**
   * 根据访问令牌查询认证信息
   *
   * <p>通过访问令牌字段精确查询认证信息
   *
   * @param accessToken 访问令牌
   * @return 匹配的认证信息
   */
  Optional<OauthAuthorization> selectByAccessTokenValue(@Param("accessToken") String accessToken);

  /**
   * 根据刷新令牌查询认证信息
   *
   * <p>通过刷新令牌字段精确查询认证信息
   *
   * @param refreshToken 刷新令牌
   * @return 匹配的认证信息
   */
  Optional<OauthAuthorization> selectByRefreshTokenValue(
      @Param("refreshToken") String refreshToken);

  /**
   * 根据 OIDC ID Token 查询认证信息
   *
   * <p>通过 OIDC ID Token 字段精确查询认证信息
   *
   * @param idToken OIDC ID Token
   * @return 匹配的认证信息
   */
  Optional<OauthAuthorization> selectByOidcIdTokenValue(@Param("idToken") String idToken);

  /**
   * 根据用户码查询认证信息
   *
   * <p>通过用户码字段精确查询认证信息
   *
   * @param userCode 用户码
   * @return 匹配的认证信息
   */
  Optional<OauthAuthorization> selectByUserCodeValue(@Param("userCode") String userCode);

  /**
   * 根据设备码查询认证信息
   *
   * <p>通过设备码字段精确查询认证信息
   *
   * @param deviceCode 设备码
   * @return 匹配的认证信息
   */
  Optional<OauthAuthorization> selectByDeviceCodeValue(@Param("deviceCode") String deviceCode);

  /**
   * 根据多种 token 字段联合查询认证信息，支持
   * state、authorizationCode、accessToken、refreshToken、idToken、userCode、deviceCode 任意一种 token。
   * 查询语句为多行文本块，便于维护和阅读。
   *
   * @param token token 值，可为上述任意一种 token
   * @return 匹配的认证信息
   */
  Optional<OauthAuthorization> selectByTokenValue(@Param("token") String token);
}
