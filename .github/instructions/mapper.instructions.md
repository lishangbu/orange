---
applyTo: "*Mapper.java"
---

# Mapper 代码与注释编写规范

## Mapper 规范

- 命名以 *Mapper 结尾，放在 mapper 包
- 继承 BaseMapper
- 负责数据持久化操作，不包含业务逻辑
- 接口和方法必须编写 JavaDoc 注释，说明查询/操作目的、参数、返回值
- 注释结尾不使用中文句号，保持简洁

### 命名规约

- 优先按 Spring Data JPA 规范命名查询方法
- 单条查询：`selectByXXX`
- 列表查询：`selectListByXXX`
- 存在性检查：`existsByXXX`
- 计数查询：`countByXXX`
- 删除操作：`deleteByXXX`

### 分页查询规范

- 分页参数使用 IPage 接口
- 返回类型使用 IPage<T>
- 注释中说明分页参数的作用

## 其他建议

- 避免在 Mapper 层编写业务逻辑
- 注意查询性能，适当添加数据库索引
- 批量操作注意数据量大小，避免内存溢出
- 对于大数据量查询，考虑使用流式处理或分批处理
- 原生 SQL 查询要注意数据库兼容性问题
