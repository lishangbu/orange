package io.github.lishangbu.orange.authorization.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.lishangbu.orange.authorization.entity.Organization;
import org.apache.ibatis.annotations.Mapper;

/**
 * 组织信息数据库操作接口
 *
 * <p>提供组织信息的增删改查等基础操作 适用于多级组织架构的数据管理
 *
 * @author lishangbu
 * @since 2025/10/16
 */
@Mapper
public interface OrganizationMapper extends BaseMapper<Organization> {}
