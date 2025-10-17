package io.github.lishangbu.orange.rbac.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.lishangbu.orange.rbac.entity.Organization;

/**
 * 组织信息数据库操作接口
 *
 * <p>提供组织信息的增删改查等基础操作 适用于多级组织架构的数据管理
 *
 * @author lishangbu
 * @since 2025/10/16
 */
public interface OrganizationMapper extends BaseMapper<Organization> {}
