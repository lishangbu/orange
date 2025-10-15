package io.github.lishangbu.orange.authorization.service;

import io.github.lishangbu.orange.authorization.model.MenuTreeNode;
import java.util.List;

/**
 * 菜单服务接口
 *
 * @author lishangbu
 * @since 2025/8/28
 */
public interface MenuService {
  /**
   * 根据角色代码获取菜单树
   *
   * @param roleCodes 角色代码
   * @return 菜单树节点列表
   */
  List<MenuTreeNode> listMenuTreeByRoleCodes(List<String> roleCodes);
}
