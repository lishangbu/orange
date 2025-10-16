package io.github.lishangbu.orange.authorization.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.lishangbu.orange.authorization.entity.Organization;

/**
 * 组织信息服务接口
 *
 * <p>定义组织相关的核心业务操作，支持分页、条件查询、增删改查等功能
 *
 * @author lishangbu
 * @since 2025/10/16
 */
public interface OrganizationService {

  /**
   * 分页查询组织列表
   *
   * <p>支持按名称、启用状态等条件进行模糊查询，结果按排序顺序升序排列
   *
   * @param page 分页参数，包含页码和每页大小
   * @param organizationCondition 查询条件，包含名称、启用状态等字段
   * @return 组织分页数据，包含组织列表和分页信息
   */
  IPage<Organization> getPageByOrganization(
      IPage<Organization> page, Organization organizationCondition);

  /**
   * 新增组织信息
   *
   * <p>创建一个新的组织信息
   *
   * @param organization 组织实体，包含名称、启用状态等信息
   * @return 新增后的组织实体
   */
  Organization saveOrganization(Organization organization);

  /**
   * 根据ID更新组织信息
   *
   * <p>支持更新名称、启用状态等字段
   *
   * @param organization 组织实体，包含需更新的字段，ID不能为空
   */
  void updateOrganization(Organization organization);

  /**
   * 根据ID删除组织
   *
   * <p>物理删除组织信息
   *
   * @param id 组织ID
   */
  void deleteOrganization(Long id);

  /**
   * 根据ID查询组织详情
   *
   * <p>返回指定ID的组织信息
   *
   * @param id 组织ID
   * @return 组织实体，未找到时返回null
   */
  Organization getOrganizationById(Long id);
}
