-- 组织信息表
CREATE TABLE organization (
    id BIGINT NOT NULL PRIMARY KEY, -- 主键
    parent_id BIGINT NOT NULL DEFAULT 0, -- 父组织ID
    name VARCHAR(100) NOT NULL, -- 名称
    code VARCHAR(100), -- 组织编码，用于外部引用和唯一标识
    enabled BOOLEAN DEFAULT TRUE NOT NULL, -- 组织是否启用
    remark VARCHAR(200), -- 备注
    sort_order INTEGER DEFAULT 0 NOT NULL, -- 排序顺序
    root_id BIGINT NOT NULL DEFAULT 0 -- 顶层组织ID冗余
);

-- 组织编码唯一约束
CREATE UNIQUE INDEX uk_organization_code ON organization(code);
