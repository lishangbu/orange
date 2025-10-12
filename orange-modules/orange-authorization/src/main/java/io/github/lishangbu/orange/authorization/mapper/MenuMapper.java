package io.github.lishangbu.orange.authorization.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.lishangbu.orange.authorization.entity.Menu;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
   * <ol>
   *   <li>使用 DISTINCT 去重，避免 JOIN 导致重复权限记录
   *   <li>使用实体关系 join，避免直接依赖中间表
   * </ol>
   *
   * @return 菜单列表
   */
  @Select(
      """
          SELECT DISTINCT m.*
          FROM menu m
          JOIN menu_role mr ON m.id = mr.menu_id
          JOIN role r ON mr.role_id = r.id
          WHERE r.code IN
          <foreach collection='roleCodes' item='code' open='(' separator=',' close=')'>
            #{code}
          </foreach>
          ORDER BY m.sort_order DESC
      """)
  List<Menu> selectListByRoleCodes(@Param("roleCodes") List<String> roleCodes);
}
