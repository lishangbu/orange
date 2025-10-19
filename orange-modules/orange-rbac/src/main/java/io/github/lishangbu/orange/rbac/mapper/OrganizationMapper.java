package io.github.lishangbu.orange.rbac.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.lishangbu.orange.rbac.entity.Organization;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 组织信息数据库操作接口
 *
 * <p>提供组织信息的增删改查等基础操作 适用于多级组织架构的数据管理
 *
 * @author lishangbu
 * @since 2025/10/16
 */
public interface OrganizationMapper extends BaseMapper<Organization> {

  /**
     * 查询指定组织及其所有下级组织（含自身）
     * <p>
     * 根据组织ID，递归返回该节点及其所有子孙节点，结果按 sortOrder、id 升序排列
     *
     * @param id 组织ID，不能为空
     * @return 组织及其所有下级组织列表
     */
    List<Organization> selectOrganizationWithDescendantsById(Long id);

  /**
   * 查询指定组织ID列表及其所有下级组织（含自身）
   * <p>
   * 根据组织ID列表，递归返回每个节点及其所有子孙节点，结果按 sortOrder、id 升序排列
   * 适用于批量树结构查询、权限分组等场景
   *
   * @param ids 组织ID列表，不能为空
   * @return 组织及其所有下级组织列表,带分页
   */
  List<Organization> selectOrganizationsWithDescendantsByIds(List<Long> ids);


  /**
     * 递归查询所有子节点（不包含当前节点）
     * <p>
     * 根据指定父组织ID，返回其所有下级组织（多级），不包含父节点本身
     * 结果按 sortOrder、id 升序排列
     *
     * @param parentId 父组织ID，不能为空
     * @return 所有子孙节点的组织列表
     */
    List<Organization> selectAllChildrenByParentId(Long parentId);


  /**
   * 模糊查询组织列表
   * <p>
   * 支持按组织ID、父ID、启用状态、编码、名称等字段进行过滤，结果按 sortOrder、id 升序排列
   * 适用于组织管理的分页展示、条件检索等场景
   *
   * @param organization 查询条件，包含组织名称、启用状态、编码等字段，允许为 null
   * @return 组织分页数据，包含组织列表和分页信息，永不为 null
   */
  List<Organization> selectListByOrganization(@Param("organization") Organization organization);

  /**
   * 根据组织ID列表查询对应的根组织ID列表
   *
   * <p>用于批量获取多个组织的顶级组织标识，支持分页查询
   *
   * @param page 分页参数，包含页码和每页大小
   * @param ids 组织ID列表，不能为空
   * @return 根组织ID列表，按输入ID顺序返回
   */
  IPage<Long> selectRootIdByIds(IPage<Organization> page, List<Long> ids);


}
