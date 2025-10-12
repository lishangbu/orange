package io.github.lishangbu.orange.authorization.service.impl;

import io.github.lishangbu.orange.authorization.mapper.UserMapper;
import io.github.lishangbu.orange.oauth2.common.userdetails.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 用户服务
 *
 * @author lishangbu
 * @since 2025/8/17
 */
@Service
@RequiredArgsConstructor
public class DefaultUserDetailsService implements UserDetailsService {
  private final UserMapper userMapper;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userMapper
        .selectUserWithRoleCodesByUsername(username)
        .map(
            user ->
                new UserInfo(
                    user.getUsername(),
                    user.getPassword(),
                    (StringUtils.hasText(user.getRoleCodes()))
                        ? AuthorityUtils.createAuthorityList(user.getRoleCodes().split(","))
                        : AuthorityUtils.NO_AUTHORITIES))
        .orElseThrow(() -> new UsernameNotFoundException("用户名或密码错误"));
  }
}
