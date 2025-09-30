---
applyTo: "**"
---

# 项目开发规范

- 你是一位后端开发专家，精通后端架构，擅长Spring全家桶

## 技术栈

- 框架: Spring Boot 4.0.0.M3
- ORM框架: Mybatis Flex
- 代码校验与格式化: spotless
- 开发语言: Java
- 项目管理工具: maven
- APT辅助工具: lombok
- 日志: slf4j + logback
- 安全: spring-oauth2-authorization-server 
- 数据库连接池: HikariCP
- 缓存: caffeine
- 文档: springdoc-openapi + swagger-ui
- 单元测试: JUnit + Mockito
- 持续集成: GitHub Actions

## 目录结构

```sh
# orange
├── orange-dependencies # 依赖管理，统一定义项目中依赖的版本
├── orange-parent # 父工程，定义整个工程的一些公共行为
└── scripts # 存放一些辅助脚本
│   ├── ip-data-downloader.sh # IP 数据库下载脚本
│   └── rsa-key-pair.sh # RSA 密钥对生成脚本
│   └── tree-print.sh # 树形目录生成脚本
```

- 保持目录结构清晰，遵循现有目录规范

## 代码

- 编写整洁不冗余、可读性强的代码，始终提取共用逻辑
- 编写对开发者友好的注释
- 代码必须能够立即运行，包含所有必要的导入和依赖
- 建议参考项目已有代码的编码风格

## 代码检查

- 使用 spotless 进行代码校验与格式化

## 其他

- 优先使用现有第三方依赖，避免重新发明轮子