INSERT INTO role (id, code, name, enabled)
VALUES (1, 'ROLE_SUPER_ADMIN', '超级管理员', true),
       (2, 'ROLE_TEST', '测试员', true);

INSERT INTO "user" (id, username, password)
VALUES (1, 'admin', '{bcrypt}$2a$10$IlYJ6qn4gyXUL.CCLzlN4ujjzlfI.3UbB0VQrYSUmiaPKpcnxdU.G');

INSERT INTO user_role_relation (user_id, role_id)
VALUES (1, 1),
       (1, 2);

insert into menu (id, parent_id, disabled, extra, icon, key, label, show, path, name, redirect, component, sort_order,
                  pinned, show_tab, enable_multi_tab)
values (1, null, false, null, 'iconify-[mage--dashboard-chart]', 'dashboard', '仪表板', true, 'dashboard', 'dashboard',
        null, 'dashboard/index', 0, true, true, false),
       (2, null, false, null, 'iconify-[mdi--security]', 'auth', '权限管理', true, 'auth', 'auth', null,
        'rbac', 0, false, true, false),
       (3, 2, false, null, 'iconify-[mdi--company]', 'organization', '组织管理', true, 'organization', 'organization', null,
        'rbac/organization/index', 0, false, true, false),
       (4, 2, false, null, 'iconify-[mdi--user-key]', 'role', '角色管理', true, 'role', 'role', null,
        'rbac/role/index', 0, false, true, false);

INSERT INTO role_menu_relation (role_id,menu_id)
VALUES (1, 1),
       (2, 1),
       (1, 2),
       (2, 2),
       (1, 3),
       (2, 3),
       (1, 4),
       (2, 4);
