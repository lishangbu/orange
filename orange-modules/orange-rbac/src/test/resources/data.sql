-- 测试用组织数据
-- 根组织与多级子组织，用于 mapper 和 controller 单元测试

INSERT INTO organization (id, parent_id, name, code, enabled, remark, sort_order) VALUES (1, 0, '根组织', 'ORG_ROOT', TRUE, '系统顶级组织', 0);
INSERT INTO organization (id, parent_id, name, code, enabled, remark, sort_order) VALUES (2, 1, '研发部', 'ORG_RND', TRUE, '负责产品研发', 1);
INSERT INTO organization (id, parent_id, name, code, enabled, remark, sort_order) VALUES (3, 1, '产品部', 'ORG_PRODUCT', TRUE, '负责需求与产品设计', 2);
INSERT INTO organization (id, parent_id, name, code, enabled, remark, sort_order) VALUES (4, 2, '后端组', 'ORG_BACKEND', TRUE, '后端开发组', 1);
INSERT INTO organization (id, parent_id, name, code, enabled, remark, sort_order) VALUES (5, 2, '前端组', 'ORG_FRONTEND', FALSE, '前端开发组（已禁用）', 2);
INSERT INTO organization (id, parent_id, name, code, enabled, remark, sort_order) VALUES (6, 3, '产品体验组', 'ORG_PRODUCT_EXP', TRUE, '负责用户体验与产品测试', 1);

