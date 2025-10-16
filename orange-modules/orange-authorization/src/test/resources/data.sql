-- oauth_registered_client 表测试数据
INSERT INTO oauth_registered_client (
    id, client_id, client_id_issued_at, client_secret,
    client_secret_expires_at, client_name, client_authentication_methods,
    authorization_grant_types, redirect_uris, post_logout_redirect_uris,
    scopes, require_proof_key, require_authorization_consent, jwk_set_url,
    token_endpoint_authentication_signing_algorithm, x509_certificate_subject_dn,
    authorization_code_time_to_live, access_token_time_to_live,
    access_token_format, device_code_time_to_live, reuse_refresh_tokens,
    refresh_token_time_to_live, id_token_signature_algorithm,
    x509_certificate_bound_access_tokens
) VALUES
      ('1', 'client', '2025-08-13 00:11:22', '{noop}client', '5202-08-13 00:11:22', '测试客户端的客户端',
       'client_secret_basic,client_secret_post,client_secret_jwt', 'refresh_token,client_credentials,password', NULL,
       'http://localhost:8080', 'openid,profile', FALSE, FALSE, NULL, 'RS256', NULL, '2h', '2h', 'self-contained', '1h',
       TRUE, '30d', 'RS256', FALSE),
      ('2', 'test', '2025-08-13 00:11:22', '{noop}test', '5202-08-13 00:11:22', '测试REFERENCE模式的客户端',
       'client_secret_basic,client_secret_post,client_secret_jwt', 'refresh_token,client_credentials,password', NULL,
       'http://localhost:8080', 'openid,profile', FALSE, FALSE, NULL, 'RS256', NULL, '2h', '2h', 'reference', '1h', TRUE,
       '30d', 'RS256', FALSE);

-- organization 表测试数据
INSERT INTO organization (id, parent_id, name, short_name, enabled, remark, sort_order) VALUES
                                                                                            (1, NULL, '集团总部', '总部', TRUE, '顶级组织', 1),
                                                                                            (2, 1, '技术中心', '技术', TRUE, '技术部门', 2),
                                                                                            (3, 1, '市场部', '市场', TRUE, '市场部门', 3),
                                                                                            (4, 2, '研发组', '研发', TRUE, '技术中心下属研发组', 1),
                                                                                            (5, 2, '运维组', '运维', FALSE, '技术中心下属运维组，暂未启用', 2),
                                                                                            (6, 3, '销售组', '销售', TRUE, NULL, 1),
                                                                                            (7, NULL, '分公司A', '分A', TRUE, '分公司A，独立组织', 4),
                                                                                            (8, 7, '分公司A-人事部', '人事', TRUE, NULL, 1),
                                                                                            (9, 7, '分公司A-财务部', '财务', TRUE, NULL, 2),
                                                                                            (10, NULL, '分公司B', '分B', FALSE, '分公司B，已禁用', 5);


-- role 表测试数据
INSERT INTO role (id, code, name, enabled) VALUES
  (1, 'ADMIN', '超级管理员', TRUE),
  (2, 'USER', '普通用户', TRUE),
  (3, 'GUEST', '访客', FALSE),
  (4, 'DEV', '开发者', TRUE),
  (5, 'OPS', '运维', TRUE),
  (6, 'TEST', '测试', FALSE);


