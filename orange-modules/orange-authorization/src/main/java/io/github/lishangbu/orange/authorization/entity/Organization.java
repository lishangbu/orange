package io.github.lishangbu.orange.authorization.entity;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

/**
 * 组织信息实体类，封装组织的层级结构和基本属性
 *
 * <p>用于描述系统中的组织架构，支持多级父子关系和排序 适用于权限分组、数据隔离等业务场景
 *
 * @author lishangbu
 * @since 2025/9/17
 */
@Data
public class Organization implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  /** 主键，唯一标识组织 */
  private Long id;

  /** 父组织ID，指向上级组织，顶级组织为null */
  private Long parentId;

  /** 组织名称 */
  private String name;

  /** 组织简称 */
  private String shortName;

  /** 组织是否启用，true表示启用，false表示禁用 */
  private Boolean enabled = true;

  /** 备注信息 */
  private String remark;

  /** 排序顺序 */
  private Integer sortOrder;
}
