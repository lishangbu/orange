Orange 
========================================================================

[![Build Status](https://github.com/lishangbu/orange/actions/workflows/build.yml/badge.svg)](https://maven.apache.org)
[![License](https://img.shields.io/github/license/lishangbu/orange)](https://github.com/lishangbu/orange/blob/main/LICENSE)

## Table of Contents

- [项目背景](#项目背景)
- [使用](#使用)
- [功能](#功能)
- [维护者](#维护者)
- [许可证](#许可证)

## 项目背景

今天，看着公司代码库几千行的前端，动辄一分钟的启动时间，后台五六个DateUtils,数不清的StringUtils，看着这个据说使用若依二开得来的框架，实在是忍不了了，一把删除，顷刻炼化。同事惊呼道：~~方源，~~
你到底要干什么？没有若依大人，我们如何抗衡业务？
很简单，我搓一个不就是了。说完，我的气息终于不再掩饰，显露而出，九年功力。一瞬间，公司再次一寂。因此，本项目就诞生了。

## 特点

### 简单纯净

本项目力求做到简单纯净，去除一切不必要的依赖和复杂性，专注于核心功能的实现。

除了Spring家族的核心依赖，如无必要，绝不引入多余的第三方依赖。

### 面向未来

本项目技术栈极其激进，都是为了未来开发考虑的。

- **Java 25**: 作为最新的LTS版本，Java 25引入了许多现代化特性和性能改进，确保项目在未来几年内保持竞争力。
- **Spring Boot 4.0**: 充分利用Spring Boot的最新功能和改进，简化开发流程，提高生产效率。
- **Spring Framework 7**: 采用最新的Spring Framework版本，享受其增强的功能和更好的性能。
- **Spring Security 7**: 提供最新的安全特性和改进，确保应用的安全性，最具现代化开发体验的Spring Authorization Server也已经回到了Spring Security怀抱。
- **Mybatis Flex**: 又是Mybatis阵营的一个新生产物，虽然我个人是真的喜欢Spring Data JPA跟Spring Data Common规范，Hibernate 6.x只能算重，开发体验其实真的不差，但自有国情在此。
- **Lombok Plugin**: 经典的简化代码工具，这可能也是很多Javaer的第一个APT工具。

### 基本功能

作为一个后台管理快速开发脚手架，基于RBAC的权限管理这一应用场景已经被前辈们玩烂了，因此，本项目的基本功能上也是大差不差，不会缺，但也很难有惊喜

### 特色功能

但如果以下功能是你所需要的，那不妨考虑一下本项目。

#### 一致性

开发这个框架的初衷就是面向协同与多人协作，本项目的所有设计和实现都以“简单、直接、可协作”为最高原则，力求让每一位开发者都能轻松上手、愉快协作。
在这里，没有复杂的依赖地狱，没有风格混乱的代码，没有难以追踪的数据库变更。本项目用自动化工具和严格规范武装自己，让开发回归本质，让协作变得高效。

##### 代码风格统一维护

代码格式化风格良莠不齐？pom文件定义混乱？在本项目中，永远不会出现类似问题:
代码统一采用[Spotless](https://github.com/diffplug/spotless),配合其自带的git hook，让代码一尘不染。

##### 数据库统一维护

本项目采用 [Liquibase](https://www.liquibase.com) 作为数据库迁移和版本管理工具，实现数据库结构的自动化维护和一致性。 所有数据库变更均通过编写标准化的 changelog 文件（如 XML、YAML 或 SQL 格式）进行管理，避免手动执行 SQL 带来的风险。 每次功能开发或修复均需编写对应的数据库变更脚本，提交至版本库，确保所有环境结构一致。 

#### 单元测试覆盖

本项目高度重视代码质量与稳定性，所有核心模块均要求单元测试覆盖。

#### AI体验

如果开发者自己都不能通过AI解放生产力，又如何解放客户的生产力？
本项目注重开发过程中的AI体验，并在多个环节集成AI辅助工具，提升开发效率和代码质量。


## 使用

要查看该项目的实际应用，请参阅[在线文档](https://lishangbu.github.io/orange-site/document)。

文档由[vitepress](https://vitepress.dev)托管，如果你想在本地运行，需要自行安装。

## 维护者

[ShangBu Li](https://github.com/lishangbu)

## 许可证

[MIT](https://opensource.org/license/mit)

Copyright (c) 2025-present, Shangbu Li
