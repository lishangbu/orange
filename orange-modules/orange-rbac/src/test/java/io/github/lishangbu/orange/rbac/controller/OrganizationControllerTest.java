package io.github.lishangbu.orange.rbac.controller;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.lishangbu.orange.rbac.entity.Organization;
import io.github.lishangbu.orange.rbac.service.OrganizationService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * 组织控制器单元测试
 *
 * <p>使用 Mockito 模拟 Service 层，验证 Controller 的委托逻辑
 *
 * @author lishangbu
 * @since 2025/10/18
 */
class OrganizationControllerTest {

  @Mock private OrganizationService organizationService;

  private OrganizationController controller;

  private AutoCloseable mocksCloseable;

  @BeforeEach
  void setUp() {
    mocksCloseable = MockitoAnnotations.openMocks(this);
    controller = new OrganizationController(organizationService);
  }

  @AfterEach
  void tearDown() throws Exception {
    if (mocksCloseable != null) {
      mocksCloseable.close();
    }
  }

  @Test
  void page_shouldDelegateToServiceAndReturnPage() {
    Page<Organization> requestPage = new Page<>(1, 10);
    Organization cond = new Organization();

    IPage<Organization> expected = new Page<>(1, 10);
    expected.setRecords(java.util.Collections.singletonList(new Organization()));

    when(organizationService.getPageByOrganization(any(), any())).thenReturn(expected);

    IPage<Organization> result = controller.page(requestPage, cond);

    assertSame(expected, result);
    verify(organizationService, times(1)).getPageByOrganization(requestPage, cond);
  }

  @Test
  void create_shouldDelegateAndReturnSavedOrganization() {
    Organization input = new Organization();
    input.setName("研发部");
    input.setCode("ORG_RND");
    input.setEnabled(true);
    input.setSortOrder(1);

    Organization saved = new Organization();
    saved.setId(100L);
    saved.setName(input.getName());

    when(organizationService.saveOrganization(input)).thenReturn(saved);

    Organization result = controller.create(input);

    assertSame(saved, result);
    verify(organizationService, times(1)).saveOrganization(input);
  }

  @Test
  void update_shouldCallService() {
    Organization input = new Organization();
    input.setId(42L);
    input.setName("更新组织");

    doNothing().when(organizationService).updateOrganization(input);

    controller.update(input);

    verify(organizationService, times(1)).updateOrganization(input);
  }

  @Test
  void delete_shouldCallServiceWithId() {
    Long id = 55L;

    doNothing().when(organizationService).deleteOrganization(id);

    controller.delete(id);

    verify(organizationService, times(1)).deleteOrganization(id);
  }

  @Test
  void getById_shouldReturnOrganizationFromService() {
    Long id = 7L;
    Organization org = new Organization();
    org.setId(id);
    org.setName("部门");

    when(organizationService.getOrganizationById(id)).thenReturn(org);

    Organization result = controller.getById(id);

    assertSame(org, result);
    verify(organizationService, times(1)).getOrganizationById(id);
  }
}
