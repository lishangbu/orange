package io.github.lishangbu.orange.authorization.entity;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

/**
 * 角色信息(Role)实体类
 *
 * @author lishangbu
 * @since 2025/08/20
 */
@Data
public class Role implements Serializable {
  @Serial private static final long serialVersionUID = 1L;

  /** 主键 */
  private Long id;

  /** 角色代码 */
  private String code;

  /** 角色名称 */
  private String name;

  /** 角色是否启用 */
  private Boolean enabled;

  /**
   * 根角色ID，标识角色所属的顶级分组或父级角色
   * 用于角色分层管理，便于权限继承和组织结构映射
   * 可为空，表示无父级或为顶级角色
   */
  private Long rootId;
}
