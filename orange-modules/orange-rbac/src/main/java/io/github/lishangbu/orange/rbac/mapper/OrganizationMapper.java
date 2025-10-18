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
     * 递归查询所有子节点（不包含当前节点）
     * <p>
     * 根据指定父组织ID，返回其所有下级组织（多级），不包含父节点本身
     * 结果按 sortOrder、id 升序排列
     *
     * @param parentId 父组织ID，不能为空
     * @return 所有子孙节点的组织列表
     */
    List<Organization> selectAllChildrenByParentId(Long parentId);
}
