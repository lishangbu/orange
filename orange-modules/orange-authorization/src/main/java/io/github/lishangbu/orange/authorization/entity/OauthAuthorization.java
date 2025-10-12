package io.github.lishangbu.orange.authorization.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.github.lishangbu.orange.mybatisplus.extension.handlers.Jackson3TypeHandler;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Map;
import lombok.Data;
import org.apache.ibatis.type.BlobTypeHandler;
import org.apache.ibatis.type.JdbcType;

/**
 * 用户认证信息表(OauthAuthorization)实体类
 *
 * @author lishangbu
 * @since 2025/08/20
 */
@Data
@TableName(autoResultMap = true)
public class OauthAuthorization implements Serializable {
  @Serial private static final long serialVersionUID = 1L;

  /** 唯一标识符 */
  private String id;

  /**
   * 序列化的完整 OAuth2Authorization 对象，采用 JSON 格式存储
   *
   * <p>使用 Jackson3TypeHandler 自动序列化和反序列化 存储为 CLOB 类型，便于跨语言解析和调试 业务场景：用于持久化 OAuth2 授权信息，支持令牌续签、撤销等操作
   *
   * @see org.springframework.security.oauth2.server.authorization.OAuth2Authorization
   */
  @TableField(typeHandler = BlobTypeHandler.class, jdbcType = JdbcType.BLOB)
  private byte[] authorizationObject;

  /** 已注册的客户端 ID */
  private String registeredClientId;

  /** 主体名称 */
  private String principalName;

  /** 授权方式 */
  private String authorizationGrantType;

  /** 授权范围 */
  private String authorizedScopes;

  /** 属性 */
  @TableField(typeHandler = Jackson3TypeHandler.class)
  private Map<String, Object> attributes;

  /** 状态 */
  private String state;

  /** 授权码值 */
  private String authorizationCodeValue;

  /** 授权码签发时间 */
  private Instant authorizationCodeIssuedAt;

  /** 授权码过期时间 */
  private Instant authorizationCodeExpiresAt;

  /** 授权码元数据 */
  @TableField(typeHandler = Jackson3TypeHandler.class)
  private Map<String, Object> authorizationCodeMetadata;

  /** 访问令牌值 */
  private String accessTokenValue;

  /** 访问令牌签发时间 */
  private Instant accessTokenIssuedAt;

  /** 访问令牌过期时间 */
  private Instant accessTokenExpiresAt;

  /** 访问令牌元数据 */
  @TableField(typeHandler = Jackson3TypeHandler.class)
  private Map<String, Object> accessTokenMetadata;

  /** 访问令牌范围 */
  private String accessTokenScopes;

  /** OIDC ID 令牌值 */
  private String oidcIdTokenValue;

  /** OIDC ID 令牌签发时间 */
  private Instant oidcIdTokenIssuedAt;

  /** OIDC ID 令牌过期时间 */
  private Instant oidcIdTokenExpiresAt;

  /** OIDC ID 令牌元数据 */
  @TableField(typeHandler = Jackson3TypeHandler.class)
  private Map<String, Object> oidcIdTokenMetadata;

  /** OIDC ID 令牌声明 */
  @TableField(typeHandler = Jackson3TypeHandler.class)
  private Map<String, Object> oidcIdTokenClaims;

  /** 刷新令牌值 */
  private String refreshTokenValue;

  /** 刷新令牌签发时间 */
  private Instant refreshTokenIssuedAt;

  /** 刷新令牌过期时间 */
  private Instant refreshTokenExpiresAt;

  /** 刷新令牌元数据 */
  @TableField(typeHandler = Jackson3TypeHandler.class)
  private Map<String, Object> refreshTokenMetadata;

  /** 用户代码值 */
  private String userCodeValue;

  /** 用户代码签发时间 */
  private Instant userCodeIssuedAt;

  /** 用户代码过期时间 */
  private Instant userCodeExpiresAt;

  /** 用户代码元数据 */
  @TableField(typeHandler = Jackson3TypeHandler.class)
  private Map<String, Object> userCodeMetadata;

  /** 设备代码值 */
  private String deviceCodeValue;

  /** 设备代码签发时间 */
  private Instant deviceCodeIssuedAt;

  /** 设备代码过期时间 */
  private Instant deviceCodeExpiresAt;

  /** 设备代码元数据 */
  @TableField(typeHandler = Jackson3TypeHandler.class)
  private Map<String, Object> deviceCodeMetadata;
}
