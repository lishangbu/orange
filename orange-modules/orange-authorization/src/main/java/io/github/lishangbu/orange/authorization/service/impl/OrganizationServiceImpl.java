package io.github.lishangbu.orange.authorization.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.lishangbu.orange.authorization.entity.Organization;
import io.github.lishangbu.orange.authorization.mapper.OrganizationMapper;
import io.github.lishangbu.orange.authorization.service.OrganizationService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 组织信息服务实现类
 *
 * <p>实现组织的分页、条件查询、增删改查等核心业务逻辑
 *
 * @author lishangbu
 * @since 2025/10/16
 */
@Service
public class OrganizationServiceImpl extends ServiceImpl<OrganizationMapper, Organization>
    implements OrganizationService {

  /**
   * 分页查询组织列表
   *
   * @param page 分页参数
   * @param condition 查询条件
   * @return 组织分页数据
   */
  @Override
  public IPage<Organization> getPageByOrganization(
      IPage<Organization> page, Organization condition) {
    LambdaQueryWrapper<Organization> wrapper = new LambdaQueryWrapper<>();
    if (StringUtils.hasText(condition.getName())) {
      wrapper.like(Organization::getName, condition.getName());
    }
    if (condition.getEnabled() != null) {
      wrapper.eq(Organization::getEnabled, condition.getEnabled());
    }
    wrapper.orderByAsc(Organization::getSortOrder);
    return this.page(page, wrapper);
  }

  /**
   * 新增组织信息
   *
   * @param organization 组织实体
   * @return 新增后的组织实体
   */
  @Override
  public Organization saveOrganization(Organization organization) {
    this.save(organization);
    return organization;
  }

  /**
   * 根据ID更新组织信息
   *
   * @param organization 组织实体
   */
  @Override
  public void updateOrganization(Organization organization) {
    this.updateById(organization);
  }

  /**
   * 根据ID删除组织
   *
   * @param id 组织ID
   */
  @Override
  public void deleteOrganization(Long id) {
    this.removeById(id);
  }

  /**
   * 根据ID查询组织详情
   *
   * @param id 组织ID
   * @return 组织实体
   */
  @Override
  public Organization getOrganizationById(Long id) {
    return this.getById(id);
  }
}
