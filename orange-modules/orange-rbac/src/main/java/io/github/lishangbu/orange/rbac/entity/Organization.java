package io.github.lishangbu.orange.rbac.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

  /** 父组织ID，指向上级组织，顶级组织为0 */
  @NotNull(message = "上级组织不能为空")
  private Long parentId;

  /** 组织名称 */
  @NotBlank(message = "组织名称不能为空")
  private String name;

  /**
   * 组织编码，用于外部引用和唯一标识
   *
   * <p>建议使用字母、数字及下划线组合，长度不超过100
   */
  @NotBlank(message = "组织编码不能为空")
  private String code;

  /** 组织是否启用，true表示启用，false表示禁用 */
  @NotNull(message = "组织启用状态不能为空")
  private Boolean enabled;

  /** 备注信息 */
  private String remark;

  /** 排序顺序 */
  @NotNull(message = "排序顺序不能为空")
  private Integer sortOrder;

  /**
   * 顶层组织ID冗余字段，表示当前节点所属的顶层公司/集团ID
   *
   * <p>顶层节点自身为其rootId，子节点为其祖先的rootId 用于高效分组、权限控制、报表统计等场景
   */
  private Long rootId;
}
