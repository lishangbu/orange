package io.github.lishangbu.orange.authorization.service.impl;

import io.github.lishangbu.orange.authorization.entity.Menu;
import io.github.lishangbu.orange.authorization.mapper.MenuMapper;
import io.github.lishangbu.orange.authorization.model.MenuTreeNode;
import io.github.lishangbu.orange.authorization.service.MenuService;
import io.github.lishangbu.orange.web.util.TreeUtils;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * 菜单服务接口实现
 *
 * @author lishangbu
 * @since 2025/9/19
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
  private final MenuMapper menuMapper;

  @Override
  public List<MenuTreeNode> listMenuTreeByRoleCodes(List<String> roleCodes) {
    List<Menu> menus = menuMapper.selectListByRoleCodes(roleCodes);
    log.debug("根据角色编码获取到 [{}] 条菜单记录", menus == null ? 0 : menus.size());
    return buildTreeFromMenus(menus, 0L);
  }

  /**
   * 将权限实体列表转换为树节点并构建树结构
   *
   * <ol>
   *   <li>处理空集合，返回不可变空列表
   *   <li>将 Permission 映射为 PermissionTreeNode
   *   <li>使用通用的 {@link TreeUtils}构建树
   * </ol>
   *
   * @param menus 权限实体列表，允许为 null
   * @return 树结构的 PermissionTreeNode 列表，永远不返回 null
   * @see TreeUtils#buildTree(List, Function, Function, Function, BiConsumer)
   */
  private List<MenuTreeNode> buildTreeFromMenus(List<Menu> menus, Long parentId) {
    if (CollectionUtils.isEmpty(menus)) {
      return Collections.emptyList();
    }

    List<MenuTreeNode> treeNodes =
        menus.stream().map(MenuTreeNode::new).collect(Collectors.toList());

    return TreeUtils.buildTree(
        treeNodes,
        MenuTreeNode::getId,
        MenuTreeNode::getParentId,
        MenuTreeNode::getChildren,
        MenuTreeNode::setChildren,
        parentId);
  }
}
