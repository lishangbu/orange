package io.github.lishangbu.orange.authorization.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.lishangbu.orange.authorization.entity.Menu;
import java.util.List;

/**
 * 菜单数据存储层
 *
 * @author lishangbu
 * @since 2025/9/19
 */
public interface MenuMapper extends BaseMapper<Menu> {
  /**
   * 通过角色代码查询所有菜单
   *
   * @param roleCodes 角色编码列表
   * @return 菜单列表
   */
  List<Menu> selectListByRoleCodes(List<String> roleCodes);
}
