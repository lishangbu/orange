-- Oauth2注册客户端表
CREATE TABLE oauth_registered_client (
                                         id VARCHAR(100) NOT NULL PRIMARY KEY, -- 唯一标识符
                                         client_id VARCHAR(100) NOT NULL, -- 客户端 ID
                                         client_id_issued_at TIMESTAMP NOT NULL, -- 客户端 ID 签发时间
                                         client_secret VARCHAR(200), -- 客户端密钥
                                         client_secret_expires_at TIMESTAMP, -- 客户端密钥过期时间
                                         client_name VARCHAR(200) NOT NULL, -- 客户端名称
                                         client_authentication_methods VARCHAR(1000) NOT NULL, -- 客户端认证方式
                                         authorization_grant_types VARCHAR(1000) NOT NULL, -- 授权方式
                                         redirect_uris VARCHAR(1000), -- 重定向 URI
                                         post_logout_redirect_uris VARCHAR(1000), -- 登出后的重定向 URI
                                         scopes VARCHAR(1000) NOT NULL, -- 客户端授权的范围
                                         require_proof_key BOOLEAN DEFAULT FALSE NOT NULL, -- PKCE流程，默认为false
                                         require_authorization_consent BOOLEAN DEFAULT FALSE NOT NULL, -- 授权确认页面，默认为false
                                         jwk_set_url VARCHAR(1000), -- jwks的url
                                         token_endpoint_authentication_signing_algorithm VARCHAR(20), -- token端点签名算法
                                         x509_certificate_subject_dn VARCHAR(20), -- X509证书DN
                                         authorization_code_time_to_live VARCHAR(20) DEFAULT '5m' NOT NULL, -- 授权码有效时长
                                         access_token_time_to_live VARCHAR(20) DEFAULT '5m' NOT NULL, -- access_token有效时长
                                         access_token_format VARCHAR(20) DEFAULT 'self-contained' NOT NULL, -- access_token格式
                                         device_code_time_to_live VARCHAR(20) DEFAULT '5m' NOT NULL, -- 设备码有效时长
                                         reuse_refresh_tokens BOOLEAN DEFAULT TRUE NOT NULL, -- 是否重用refresh token
                                         refresh_token_time_to_live VARCHAR(20) DEFAULT '1h' NOT NULL, -- refresh_token有效时长
                                         id_token_signature_algorithm VARCHAR(20) DEFAULT 'RS256' NOT NULL, -- ID Token签名算法
                                         x509_certificate_bound_access_tokens BOOLEAN DEFAULT FALSE NOT NULL -- access token是否绑定X509证书
);
-- 组织信息表
CREATE TABLE organization (
                              id BIGINT NOT NULL PRIMARY KEY, -- 主键
                              parent_id BIGINT, -- 父组织ID
                              name VARCHAR(100) NOT NULL, -- 名称
                              short_name VARCHAR(50), -- 简称
                              enabled BOOLEAN DEFAULT TRUE NOT NULL, -- 组织是否启用
                              remark VARCHAR(200), -- 备注
                              sort_order INTEGER DEFAULT 0 NOT NULL -- 排序顺序
);
-- 角色信息表
CREATE TABLE role (
    id BIGINT NOT NULL PRIMARY KEY, -- 主键
    code VARCHAR(50) DEFAULT '' NOT NULL UNIQUE, -- 角色代码
    name VARCHAR(50) DEFAULT '' NOT NULL, -- 角色名称
    enabled BOOLEAN DEFAULT TRUE NOT NULL -- 角色是否启用
);

