package io.github.lishangbu.orange.authorization.mapper;

import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import io.github.lishangbu.orange.authorization.entity.OauthRegisteredClient;
import io.github.lishangbu.orange.mybatisplus.autoconfiguration.MybatisPlusAutoConfiguration;
import jakarta.annotation.Resource;
import java.time.Instant;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

/**
 * OauthRegisteredClientMapper 单元测试，覆盖增删改查
 *
 * @author lishangbu
 * @since 2025/10/16
 */
@ContextConfiguration(classes = MybatisPlusAutoConfiguration.class)
@MybatisPlusTest
class OauthRegisteredClientMapperTest {
  @Resource private OauthRegisteredClientMapper mapper;

  @Test
  void testSelectByClientId() {
    Optional<OauthRegisteredClient> clientOpt = mapper.selectByClientId("client");
    Assertions.assertThat(clientOpt).isPresent();
    Assertions.assertThat(clientOpt.get().getClientId()).isEqualTo("client");
  }

  @Test
  void testInsertClient() {
    OauthRegisteredClient client = new OauthRegisteredClient();
    client.setClientId("insert_test");
    client.setClientIdIssuedAt(Instant.now());
    client.setClientName("插入测试客户端");
    client.setClientAuthenticationMethods("client_secret_basic");
    client.setAuthorizationGrantTypes("client_credentials");
    client.setScopes("openid");
    client.setRequireProofKey(false);
    client.setRequireAuthorizationConsent(false);
    int result = mapper.insert(client);
    Assertions.assertThat(result).isEqualTo(1);
    Assertions.assertThat(client.getId()).isNotNull();
  }

  @Test
  void testUpdateClient() {
    Optional<OauthRegisteredClient> clientOpt = mapper.selectByClientId("client");
    Assertions.assertThat(clientOpt).isPresent();
    OauthRegisteredClient client = clientOpt.get();
    client.setClientName("已更新客户端");
    int result = mapper.updateById(client);
    Assertions.assertThat(result).isEqualTo(1);
    OauthRegisteredClient updated = mapper.selectById(client.getId());
    Assertions.assertThat(updated.getClientName()).isEqualTo("已更新客户端");
  }

  @Test
  void testDeleteClient() {
    OauthRegisteredClient client = new OauthRegisteredClient();
    client.setClientId("delete_test");
    client.setClientIdIssuedAt(Instant.now());
    client.setClientName("待删除客户端");
    client.setClientAuthenticationMethods("client_secret_basic");
    client.setAuthorizationGrantTypes("client_credentials");
    client.setScopes("openid");
    client.setRequireProofKey(false);
    client.setRequireAuthorizationConsent(false);
    mapper.insert(client);
    String id = client.getId();
    int result = mapper.deleteById(id);
    Assertions.assertThat(result).isEqualTo(1);
    Assertions.assertThat(mapper.selectById(id)).isNull();
  }
}
