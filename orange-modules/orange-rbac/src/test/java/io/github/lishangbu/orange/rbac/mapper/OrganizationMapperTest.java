package io.github.lishangbu.orange.rbac.mapper;

import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import io.github.lishangbu.orange.mybatisplus.autoconfiguration.MybatisPlusAutoConfiguration;
import io.github.lishangbu.orange.rbac.entity.Organization;
import jakarta.annotation.Resource;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.test.context.ContextConfiguration;

/**
 * OrganizationMapper 单元测试，覆盖增删改查
 *
 * @author lishangbu
 * @since 2025/10/16
 */
@ContextConfiguration(classes = MybatisPlusAutoConfiguration.class)
@MybatisPlusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrganizationMapperTest {
  @Resource private OrganizationMapper mapper;

  @Test
  @Order(1)
  void testInsertOrganization() {
    Organization org = new Organization();
    org.setName("测试组织");
    org.setEnabled(true);
    org.setSortOrder(99);
    int result = mapper.insert(org);
    Assertions.assertThat(result).isEqualTo(1);
    Assertions.assertThat(org.getId()).isNotNull();
  }

  @Test
  @Order(2)
  void testSelectOrganizationById() {
    Organization org = new Organization();
    org.setName("查询组织");
    org.setEnabled(true);
    org.setSortOrder(1);
    mapper.insert(org);
    Organization found = mapper.selectById(org.getId());
    Assertions.assertThat(found).isNotNull();
    Assertions.assertThat(found.getName()).isEqualTo("查询组织");
  }

  @Test
  @Order(3)
  void testUpdateOrganization() {
    Organization org = new Organization();
    org.setName("待更新组织");
    org.setEnabled(true);
    org.setSortOrder(2);
    mapper.insert(org);
    org.setName("已更新组织");
    int result = mapper.updateById(org);
    Assertions.assertThat(result).isEqualTo(1);
    Organization updated = mapper.selectById(org.getId());
    Assertions.assertThat(updated.getName()).isEqualTo("已更新组织");
  }

  @Test
  @Order(4)
  void testDeleteOrganization() {
    Organization org = new Organization();
    org.setName("待删除组织");
    org.setEnabled(true);
    org.setSortOrder(3);
    mapper.insert(org);
    Long id = org.getId();
    int result = mapper.deleteById(id);
    Assertions.assertThat(result).isEqualTo(1);
    Assertions.assertThat(mapper.selectById(id)).isNull();
  }
}
