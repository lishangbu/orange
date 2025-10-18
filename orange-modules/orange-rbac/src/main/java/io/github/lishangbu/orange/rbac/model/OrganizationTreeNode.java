package io.github.lishangbu.orange.rbac.model;

import io.github.lishangbu.orange.rbac.entity.Organization;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * 组织树节点
 *
 * @author lishangbu
 * @since 2025/8/28
 */
@Getter
@Setter
@ToString
public class OrganizationTreeNode extends Organization {
  private List<OrganizationTreeNode> children;

  public OrganizationTreeNode(Organization organization) {
    if (organization != null) {
      BeanUtils.copyProperties(organization, this);
    }
  }
}
