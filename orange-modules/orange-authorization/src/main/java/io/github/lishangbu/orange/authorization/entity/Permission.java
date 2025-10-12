package io.github.lishangbu.orange.authorization.entity;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

/**
 * 权限(Permission)实体类
 *
 * @author lishangbu
 * @since 2025/08/28
 */
@Data
public class Permission implements Serializable {
  @Serial private static final long serialVersionUID = 1L;

  /** 主键 */
  private Long id;

  /** 权限名称 */
  private String name;

  /** 权限编码 */
  private String code;

  /** 父权限ID */
  private Long parentId;

  /** 请求方法 */
  private String method;

  /** 描述 */
  private String description;

  /** 是否启用 */
  private Boolean enabled;

  /** 排序顺序 */
  private Integer sortOrder;
}
