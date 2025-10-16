package io.github.lishangbu.orange.authorization.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import io.github.lishangbu.orange.authorization.entity.Role;
import io.github.lishangbu.orange.mybatisplus.autoconfiguration.MybatisPlusAutoConfiguration;
import jakarta.annotation.Resource;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author lishangbu
 * @since 2025/10/16
 */
@ContextConfiguration(classes = MybatisPlusAutoConfiguration.class)
@MybatisPlusTest
class RoleMapperTest {
  @Resource private RoleMapper mapper;

  @Test
  void testSelectPageByRole() {
    Page<Role> page = new Page<>(1, 2);
    IPage<Role> result = mapper.selectPageByRole(page, new Role());
    // 断言总数和分页数据
    Assertions.assertThat(result.getTotal()).isGreaterThanOrEqualTo(6);
    Assertions.assertThat(result.getRecords()).isNotEmpty();
    // 断言数据内容
    Assertions.assertThat(result.getRecords().getFirst().getCode()).isNotBlank();
  }

  @Test
  void testInsertRole() {
    Role role = new Role();
    role.setCode("TEST_INSERT");
    role.setName("测试插入");
    role.setEnabled(true);
    int result = mapper.insert(role);
    Assertions.assertThat(result).isEqualTo(1);
    Assertions.assertThat(role.getId()).isNotNull();
  }

  @Test
  void testSelectRoleById() {
    Role role = mapper.selectById(1L);
    Assertions.assertThat(role).isNotNull();
    Assertions.assertThat(role.getCode()).isEqualTo("ADMIN");
  }

  @Test
  void testUpdateRole() {
    Role role = mapper.selectById(2L);
    role.setName("普通用户-更新");
    int result = mapper.updateById(role);
    Assertions.assertThat(result).isEqualTo(1);
    Role updated = mapper.selectById(2L);
    Assertions.assertThat(updated.getName()).isEqualTo("普通用户-更新");
  }

  @Test
  void testDeleteRole() {
    Role role = new Role();
    role.setCode("TO_DELETE");
    role.setName("待删除角色");
    role.setEnabled(true);
    mapper.insert(role);
    Long id = role.getId();
    int result = mapper.deleteById(id);
    Assertions.assertThat(result).isEqualTo(1);
    Assertions.assertThat(mapper.selectById(id)).isNull();
  }
}
