package io.github.lishangbu.orange.authorization.model;

import io.github.lishangbu.orange.authorization.entity.Permission;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

/**
 * 权限树节点
 *
 * @author lishangbu
 * @since 2025/8/28
 */
@Getter
@Setter
@ToString
public class PermissionTreeNode extends Permission {
  private List<PermissionTreeNode> children;

  public PermissionTreeNode(Permission permission) {
    if (permission != null) {
      BeanUtils.copyProperties(permission, this);
    }
  }
}
