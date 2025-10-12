package io.github.lishangbu.orange.authorization.mapper;

import io.github.lishangbu.orange.authorization.model.UserWithRoleCodes;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户信息(user)表数据库访问层
 *
 * <p>提供对用户信息的增删改查等操作
 *
 * @author lishangbu
 * @since 2025/08/19
 */
@Mapper
public interface UserMapper {
  /**
   * 通过用户名查询用户及其角色代码信息
   *
   * @param username 用户名，不能为空
   * @return 用户信息列表，通常只返回一个用户
   */
  Optional<UserWithRoleCodes> selectUserWithRoleCodesByUsername(@Param("username") String username);
}
