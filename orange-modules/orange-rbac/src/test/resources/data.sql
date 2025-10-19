-- 顶级公司
INSERT INTO organization (id, parent_id, name, code, enabled, remark, sort_order, depth, root_id) VALUES
(1, 0, '橙果科技', 'chengguo', TRUE, '创新互联网企业', 1, 1, 1),
(2, 0, '星辰集团', 'xingchen', TRUE, '多元化产业集团', 2, 1, 2),
(3, 0, '蓝海能源', 'lanhai', TRUE, '新能源领军企业', 3, 1, 3),
(4, 0, '云杉信息', 'yunshan', TRUE, '信息技术服务商', 4, 1, 4),
(5, 0, '恒信地产', 'hengxin', TRUE, '地产开发与运营', 5, 1, 5),
(6, 0, '瑞丰医疗', 'ruifeng', TRUE, '医疗健康集团', 6, 1, 6),
(7, 0, '金桥物流', 'jinqiao', TRUE, '智慧物流平台', 7, 1, 7),
(8, 0, '天翼传媒', 'tianyi', TRUE, '数字传媒公司', 8, 1, 8),
(9, 0, '博远汽车', 'boyuan', TRUE, '智能汽车制造', 9, 1, 9),
(10, 0, '华腾金融', 'huateng', TRUE, '金融服务集团', 10, 1, 10),
(11, 0, '盛世食品', 'shengshi', TRUE, '食品加工企业', 11, 1, 11),
(12, 0, '启航教育', 'qihang', TRUE, '教育培训机构', 12, 1, 12),
(13, 0, '智联安防', 'zhilian', TRUE, '智能安防解决方案', 13, 1, 13),
(14, 0, '绿洲环保', 'lvzhou', TRUE, '环保科技公司', 14, 1, 14),
(15, 0, '远航旅游', 'yuanhang', TRUE, '旅游服务商', 15, 1, 15),
(16, 0, '新锐设计', 'xinrui', TRUE, '创意设计公司', 16, 1, 16),
(17, 0, '宏图建设', 'hongtu', TRUE, '建筑工程企业', 17, 1, 17),
(18, 0, '优品电商', 'youpin', TRUE, '电商平台', 18, 1, 18),
(19, 0, '安康制药', 'ankang', TRUE, '制药企业', 19, 1, 19),
(20, 0, '蓝天航空', 'lantian', TRUE, '航空运输公司', 20, 1, 20),
(21, 0, '光华文化', 'guanghua', TRUE, '文化传播机构', 21, 1, 21),
(22, 0, '恒远矿业', 'hengyuan', TRUE, '矿产资源开发', 22, 1, 22),
(23, 0, '盛达物业', 'shengda', TRUE, '物业管理公司', 23, 1, 23),
(24, 0, '新纪元科技', 'xinjiyuan', TRUE, '高新技术企业', 24, 1, 24),
(25, 0, '金瑞保险', 'jinrui', TRUE, '保险服务商', 25, 1, 25),
(26, 0, '天成咨询', 'tiancheng', TRUE, '管理咨询公司', 26, 1, 26),
(27, 0, '华信通信', 'huaxin', TRUE, '通信运营商', 27, 1, 27),
(28, 0, '嘉禾农业', 'jiahe', TRUE, '现代农业集团', 28, 1, 28),
(29, 0, '博睿数据', 'borui', TRUE, '大数据服务商', 29, 1, 29),
(30, 0, '安泰安保', 'antai', TRUE, '安保服务公司', 30, 1, 30),
(31, 0, '新视界影视', 'xinshijie', TRUE, '影视制作公司', 31, 1, 31);

-- 部门（每家公司2个部门）
INSERT INTO organization (id, parent_id, name, code, enabled, remark, sort_order, depth, root_id) VALUES
-- 橙果科技
(101, 1, '人力资源部', 'chengguo_hr', TRUE, '负责招聘与员工发展', 1, 2, 1),
(102, 1, '研发中心', 'chengguo_rd', TRUE, '技术研发与创新', 2, 2, 1),
-- 星辰集团
(103, 2, '财务部', 'xingchen_fin', TRUE, '财务管理与核算', 1, 2, 2),
(104, 2, '市场部', 'xingchen_marketing', TRUE, '市场推广与品牌建设', 2, 2, 2),
-- 蓝海能源
(105, 3, '工程部', 'lanhai_eng', TRUE, '项目工程管理', 1, 2, 3),
(106, 3, '运维部', 'lanhai_ops', TRUE, '设备运维与安全', 2, 2, 3),
-- 云杉信息
(107, 4, '产品部', 'yunshan_product', TRUE, '产品规划与设计', 1, 2, 4),
(108, 4, '技术部', 'yunshan_tech', TRUE, '技术开发与支持', 2, 2, 4),
-- 恒信地产
(109, 5, '项目部', 'hengxin_project', TRUE, '地产项目开发', 1, 2, 5),
(110, 5, '销售部', 'hengxin_sales', TRUE, '项目销售与客户服务', 2, 2, 5),
-- 瑞丰医疗
(111, 6, '医疗服务部', 'ruifeng_service', TRUE, '医疗服务运营', 1, 2, 6),
(112, 6, '药品部', 'ruifeng_drug', TRUE, '药品采购与管理', 2, 2, 6),
-- 金桥物流
(113, 7, '运输部', 'jinqiao_transport', TRUE, '物流运输管理', 1, 2, 7),
(114, 7, '仓储部', 'jinqiao_storage', TRUE, '仓储与库存管理', 2, 2, 7),
-- 天翼传媒
(115, 8, '内容部', 'tianyi_content', TRUE, '内容策划与制作', 1, 2, 8),
(116, 8, '运营部', 'tianyi_ops', TRUE, '平台运营与推广', 2, 2, 8),
-- 博远汽车
(117, 9, '制造部', 'boyuan_manufacture', TRUE, '汽车制造与装配', 1, 2, 9),
(118, 9, '质量部', 'boyuan_quality', TRUE, '质量检测与管控', 2, 2, 9),
-- 华腾金融
(119, 10, '投资部', 'huateng_invest', TRUE, '投资管理与分析', 1, 2, 10),
(120, 10, '风控部', 'huateng_risk', TRUE, '风险控制与合规', 2, 2, 10),
-- 盛世食品
(121, 11, '生产部', 'shengshi_prod', TRUE, '食品生产与加工', 1, 2, 11),
(122, 11, '品控部', 'shengshi_quality', TRUE, '品质管理与检测', 2, 2, 11),
-- 启航教育
(123, 12, '教务部', 'qihang_academic', TRUE, '教学管理与安排', 1, 2, 12),
(124, 12, '招生部', 'qihang_admission', TRUE, '招生宣传与服务', 2, 2, 12),
-- 智联安防
(125, 13, '技术部', 'zhilian_tech', TRUE, '安防技术研发', 1, 2, 13),
(126, 13, '项目部', 'zhilian_project', TRUE, '安防项目实施', 2, 2, 13),
-- 绿洲环保
(127, 14, '研发部', 'lvzhou_rd', TRUE, '环保技术研发', 1, 2, 14),
(128, 14, '市场部', 'lvzhou_marketing', TRUE, '环保市场推广', 2, 2, 14),
-- 远航旅游
(129, 15, '产品部', 'yuanhang_product', TRUE, '旅游产品设计', 1, 2, 15),
(130, 15, '客服部', 'yuanhang_service', TRUE, '客户服务与支持', 2, 2, 15),
-- 新锐设计
(131, 16, '设计部', 'xinrui_design', TRUE, '创意设计与策划', 1, 2, 16),
(132, 16, '运营部', 'xinrui_ops', TRUE, '项目运营管理', 2, 2, 16),
-- 宏图建设
(133, 17, '工程部', 'hongtu_eng', TRUE, '建筑工程管理', 1, 2, 17),
(134, 17, '采购部', 'hongtu_purchase', TRUE, '材料采购与供应', 2, 2, 17),
-- 优品电商
(135, 18, '商品部', 'youpin_goods', TRUE, '商品管理与采购', 1, 2, 18),
(136, 18, '运营部', 'youpin_ops', TRUE, '平台运营与推广', 2, 2, 18),
-- 安康制药
(137, 19, '研发部', 'ankang_rd', TRUE, '药品研发与创新', 1, 2, 19),
(138, 19, '生产部', 'ankang_prod', TRUE, '药品生产与质控', 2, 2, 19),
-- 蓝天航空
(139, 20, '飞行部', 'lantian_flight', TRUE, '航班运营与管理', 1, 2, 20),
(140, 20, '维修部', 'lantian_maintenance', TRUE, '飞机维修与保养', 2, 2, 20),
-- 光华文化
(141, 21, '编辑部', 'guanghua_edit', TRUE, '内容编辑与出版', 1, 2, 21),
(142, 21, '市场部', 'guanghua_marketing', TRUE, '文化市场推广', 2, 2, 21),
-- 恒远矿业
(143, 22, '采矿部', 'hengyuan_mining', TRUE, '矿产采掘与管理', 1, 2, 22),
(144, 22, '安全部', 'hengyuan_safety', TRUE, '矿区安全管理', 2, 2, 22),
-- 盛达物业
(145, 23, '客服部', 'shengda_service', TRUE, '客户服务与支持', 1, 2, 23),
(146, 23, '工程部', 'shengda_eng', TRUE, '物业工程维护', 2, 2, 23),
-- 新纪元科技
(147, 24, '研发部', 'xinjiyuan_rd', TRUE, '技术研发与创新', 1, 2, 24),
(148, 24, '市场部', 'xinjiyuan_marketing', TRUE, '市场推广与销售', 2, 2, 24),
-- 金瑞保险
(149, 25, '理赔部', 'jinrui_claim', TRUE, '保险理赔服务', 1, 2, 25),
(150, 25, '销售部', 'jinrui_sales', TRUE, '保险产品销售', 2, 2, 25),
-- 天成咨询
(151, 26, '咨询部', 'tiancheng_consult', TRUE, '管理咨询服务', 1, 2, 26),
(152, 26, '市场部', 'tiancheng_marketing', TRUE, '咨询市场推广', 2, 2, 26),
-- 华信通信
(153, 27, '网络部', 'huaxin_network', TRUE, '网络运营与维护', 1, 2, 27),
(154, 27, '客服部', 'huaxin_service', TRUE, '客户服务与支持', 2, 2, 27),
-- 嘉禾农业
(155, 28, '种植部', 'jiahe_plant', TRUE, '农作物种植管理', 1, 2, 28),
(156, 28, '销售部', 'jiahe_sales', TRUE, '农产品销售', 2, 2, 28),
-- 博睿数据
(157, 29, '数据部', 'borui_data', TRUE, '数据分析与处理', 1, 2, 29),
(158, 29, '产品部', 'borui_product', TRUE, '数据产品开发', 2, 2, 29),
-- 安泰安保
(159, 30, '安保部', 'antai_security', TRUE, '安保服务与管理', 1, 2, 30),
(160, 30, '技术部', 'antai_tech', TRUE, '安保技术研发', 2, 2, 30),
-- 新视界影视
(161, 31, '制作部', 'xinshijie_prod', TRUE, '影视制作与拍摄', 1, 2, 31),
(162, 31, '发行部', 'xinshijie_publish', TRUE, '影视发行与推广', 2, 2, 31);

-- 子部门（每部门2个子部门，深度3）
INSERT INTO organization (id, parent_id, name, code, enabled, remark, sort_order, depth, root_id) VALUES
-- 橙果科技
(201, 101, '招聘组', 'chengguo_hr_recruit', TRUE, '负责招聘流程', 1, 3, 1),
(202, 101, '员工关系组', 'chengguo_hr_relation', TRUE, '员工关系管理', 2, 3, 1),
(203, 102, '前端开发组', 'chengguo_rd_fe', TRUE, '前端技术研发', 1, 3, 1),
(204, 102, '后端开发组', 'chengguo_rd_be', TRUE, '后端技术研发', 2, 3, 1),
-- 星辰集团
(205, 103, '会计组', 'xingchen_fin_account', TRUE, '会计核算', 1, 3, 2),
(206, 103, '预算组', 'xingchen_fin_budget', TRUE, '预算管理', 2, 3, 2),
(207, 104, '品牌组', 'xingchen_marketing_brand', TRUE, '品牌推广', 1, 3, 2),
(208, 104, '活动组', 'xingchen_marketing_event', TRUE, '市场活动策划', 2, 3, 2),
-- 蓝海能源
(209, 105, '项目组', 'lanhai_eng_project', TRUE, '工程项目管理', 1, 3, 3),
(210, 105, '设计组', 'lanhai_eng_design', TRUE, '工程设计', 2, 3, 3),
(211, 106, '设备组', 'lanhai_ops_device', TRUE, '设备维护', 1, 3, 3),
(212, 106, '安全组', 'lanhai_ops_safety', TRUE, '安全管理', 2, 3, 3),
-- 云杉信息
(213, 107, '产品规划组', 'yunshan_product_plan', TRUE, '产品规划', 1, 3, 4),
(214, 107, '用户体验组', 'yunshan_product_ux', TRUE, '用户体验设计', 2, 3, 4),
(215, 108, '开发组', 'yunshan_tech_dev', TRUE, '技术开发', 1, 3, 4),
(216, 108, '运维组', 'yunshan_tech_ops', TRUE, '技术运维', 2, 3, 4),
-- 恒信地产
(217, 109, '项目策划组', 'hengxin_project_plan', TRUE, '项目策划', 1, 3, 5),
(218, 109, '工程组', 'hengxin_project_eng', TRUE, '工程实施', 2, 3, 5),
(219, 110, '客户组', 'hengxin_sales_client', TRUE, '客户服务', 1, 3, 5),
(220, 110, '渠道组', 'hengxin_sales_channel', TRUE, '销售渠道管理', 2, 3, 5),
-- 瑞丰医疗
(221, 111, '门诊组', 'ruifeng_service_outpatient', TRUE, '门诊服务', 1, 3, 6),
(222, 111, '住院组', 'ruifeng_service_inpatient', TRUE, '住院服务', 2, 3, 6),
(223, 112, '采购组', 'ruifeng_drug_purchase', TRUE, '药品采购', 1, 3, 6),
(224, 112, '仓储组', 'ruifeng_drug_storage', TRUE, '药品仓储', 2, 3, 6),
-- 金桥物流
(225, 113, '运输调度组', 'jinqiao_transport_dispatch', TRUE, '运输调度', 1, 3, 7),
(226, 113, '司机组', 'jinqiao_transport_driver', TRUE, '司机管理', 2, 3, 7),
(227, 114, '仓库组', 'jinqiao_storage_warehouse', TRUE, '仓库管理', 1, 3, 7),
(228, 114, '库存组', 'jinqiao_storage_inventory', TRUE, '库存管理', 2, 3, 7),
-- 天翼传媒
(229, 115, '内容策划组', 'tianyi_content_plan', TRUE, '内容策划', 1, 3, 8),
(230, 115, '内容制作组', 'tianyi_content_prod', TRUE, '内容制作', 2, 3, 8),
(231, 116, '平台运营组', 'tianyi_ops_platform', TRUE, '平台运营', 1, 3, 8),
(232, 116, '推广组', 'tianyi_ops_promotion', TRUE, '平台推广', 2, 3, 8),
-- 博远汽车
(233, 117, '装配组', 'boyuan_manufacture_assembly', TRUE, '汽车装配', 1, 3, 9),
(234, 117, '测试组', 'boyuan_manufacture_test', TRUE, '汽车测试', 2, 3, 9),
(235, 118, '质量检测组', 'boyuan_quality_check', TRUE, '质量检测', 1, 3, 9),
(236, 118, '质量管理组', 'boyuan_quality_manage', TRUE, '质量管理', 2, 3, 9),
-- 华腾金融
(237, 119, '投资分析组', 'huateng_invest_analysis', TRUE, '投资分析', 1, 3, 10),
(238, 119, '投资管理组', 'huateng_invest_manage', TRUE, '投资管理', 2, 3, 10),
(239, 120, '合规组', 'huateng_risk_compliance', TRUE, '合规管理', 1, 3, 10),
(240, 120, '风险评估组', 'huateng_risk_assess', TRUE, '风险评估', 2, 3, 10),
-- 盛世食品
(241, 121, '生产组', 'shengshi_prod_group', TRUE, '生产管理', 1, 3, 11),
(242, 121, '加工组', 'shengshi_prod_process', TRUE, '食品加工', 2, 3, 11),
(243, 122, '品质检测组', 'shengshi_quality_check', TRUE, '品质检测', 1, 3, 11),
(244, 122, '品质管理组', 'shengshi_quality_manage', TRUE, '品质管理', 2, 3, 11),
-- 启航教育
(245, 123, '教学管理组', 'qihang_academic_manage', TRUE, '教学管理', 1, 3, 12),
(246, 123, '课程组', 'qihang_academic_course', TRUE, '课程安排', 2, 3, 12),
(247, 124, '招生宣传组', 'qihang_admission_promo', TRUE, '招生宣传', 1, 3, 12),
(248, 124, '招生服务组', 'qihang_admission_service', TRUE, '招生服务', 2, 3, 12),
-- 智联安防
(249, 125, '技术研发组', 'zhilian_tech_rd', TRUE, '技术研发', 1, 3, 13),
(250, 125, '技术支持组', 'zhilian_tech_support', TRUE, '技术支持', 2, 3, 13),
(251, 126, '项目实施组', 'zhilian_project_impl', TRUE, '项目实施', 1, 3, 13),
(252, 126, '项目管理组', 'zhilian_project_manage', TRUE, '项目管理', 2, 3, 13),
-- 绿洲环保
(253, 127, '技术研发组', 'lvzhou_rd_tech', TRUE, '技术研发', 1, 3, 14),
(254, 127, '产品研发组', 'lvzhou_rd_product', TRUE, '产品研发', 2, 3, 14),
(255, 128, '市场推广组', 'lvzhou_marketing_promo', TRUE, '市场推广', 1, 3, 14),
(256, 128, '客户组', 'lvzhou_marketing_client', TRUE, '客户管理', 2, 3, 14),
-- 远航旅游
(257, 129, '产品设计组', 'yuanhang_product_design', TRUE, '产品设计', 1, 3, 15),
(258, 129, '产品管理组', 'yuanhang_product_manage', TRUE, '产品管理', 2, 3, 15),
(259, 130, '客户服务组', 'yuanhang_service_group', TRUE, '客户服务', 1, 3, 15),
(260, 130, '客户支持组', 'yuanhang_service_support', TRUE, '客户支持', 2, 3, 15),
-- 新锐设计
(261, 131, '创意组', 'xinrui_design_creative', TRUE, '创意策划', 1, 3, 16),
(262, 131, '设计组', 'xinrui_design_group', TRUE, '设计执行', 2, 3, 16),
(263, 132, '项目运营组', 'xinrui_ops_project', TRUE, '项目运营', 1, 3, 16),
(264, 132, '客户组', 'xinrui_ops_client', TRUE, '客户管理', 2, 3, 16),
-- 宏图建设
(265, 133, '工程管理组', 'hongtu_eng_manage', TRUE, '工程管理', 1, 3, 17),
(266, 133, '工程实施组', 'hongtu_eng_impl', TRUE, '工程实施', 2, 3, 17),
(267, 134, '采购组', 'hongtu_purchase_group', TRUE, '采购管理', 1, 3, 17),
(268, 134, '供应组', 'hongtu_purchase_supply', TRUE, '供应管理', 2, 3, 17),
-- 优品电商
(269, 135, '商品采购组', 'youpin_goods_purchase', TRUE, '商品采购', 1, 3, 18),
(270, 135, '商品管理组', 'youpin_goods_manage', TRUE, '商品管理', 2, 3, 18),
(271, 136, '平台运营组', 'youpin_ops_platform', TRUE, '平台运营', 1, 3, 18),
(272, 136, '推广组', 'youpin_ops_promotion', TRUE, '平台推广', 2, 3, 18),
-- 安康制药
(273, 137, '药品研发组', 'ankang_rd_group', TRUE, '药品研发', 1, 3, 19),
(274, 137, '新药组', 'ankang_rd_newdrug', TRUE, '新药研发', 2, 3, 19),
(275, 138, '生产管理组', 'ankang_prod_manage', TRUE, '生产管理', 1, 3, 19),
(276, 138, '质控组', 'ankang_prod_quality', TRUE, '质量控制', 2, 3, 19),
-- 蓝天航空
(277, 139, '航班运营组', 'lantian_flight_ops', TRUE, '航班运营', 1, 3, 20),
(278, 139, '飞行管理组', 'lantian_flight_manage', TRUE, '飞行管理', 2, 3, 20),
(279, 140, '维修组', 'lantian_maintenance_group', TRUE, '维修管理', 1, 3, 20),
(280, 140, '保养组', 'lantian_maintenance_care', TRUE, '飞机保养', 2, 3, 20),
-- 光华文化
(281, 141, '内容编辑组', 'guanghua_edit_content', TRUE, '内容编辑', 1, 3, 21),
(282, 141, '出版组', 'guanghua_edit_publish', TRUE, '出版管理', 2, 3, 21),
(283, 142, '市场推广组', 'guanghua_marketing_promo', TRUE, '市场推广', 1, 3, 21),
(284, 142, '客户组', 'guanghua_marketing_client', TRUE, '客户管理', 2, 3, 21),
-- 恒远矿业
(285, 143, '采矿管理组', 'hengyuan_mining_manage', TRUE, '采矿管理', 1, 3, 22),
(286, 143, '采矿实施组', 'hengyuan_mining_impl', TRUE, '采矿实施', 2, 3, 22),
(287, 144, '安全管理组', 'hengyuan_safety_manage', TRUE, '安全管理', 1, 3, 22),
(288, 144, '安全检查组', 'hengyuan_safety_check', TRUE, '安全检查', 2, 3, 22),
-- 盛达物业
(289, 145, '客户服务组', 'shengda_service_group', TRUE, '客户服务', 1, 3, 23),
(290, 145, '客户支持组', 'shengda_service_support', TRUE, '客户支持', 2, 3, 23),
(291, 146, '工程维护组', 'shengda_eng_maintain', TRUE, '工程维护', 1, 3, 23),
(292, 146, '工程管理组', 'shengda_eng_manage', TRUE, '工程管理', 2, 3, 23),
-- 新纪元科技
(293, 147, '技术研发组', 'xinjiyuan_rd_tech', TRUE, '技术研发', 1, 3, 24),
(294, 147, '产品研发组', 'xinjiyuan_rd_product', TRUE, '产品研发', 2, 3, 24),
(295, 148, '市场推广组', 'xinjiyuan_marketing_promo', TRUE, '市场推广', 1, 3, 24),
(296, 148, '销售组', 'xinjiyuan_marketing_sales', TRUE, '销售管理', 2, 3, 24),
-- 金瑞保险
(297, 149, '理赔服务组', 'jinrui_claim_service', TRUE, '理赔服务', 1, 3, 25),
(298, 149, '理赔管理组', 'jinrui_claim_manage', TRUE, '理赔管理', 2, 3, 25),
(299, 150, '销售组', 'jinrui_sales_group', TRUE, '销售管理', 1, 3, 25),
(300, 150, '客户组', 'jinrui_sales_client', TRUE, '客户管理', 2, 3, 25),
-- 天成咨询
(301, 151, '咨询服务组', 'tiancheng_consult_service', TRUE, '咨询服务', 1, 3, 26),
(302, 151, '咨询管理组', 'tiancheng_consult_manage', TRUE, '咨询管理', 2, 3, 26),
(303, 152, '市场推广组', 'tiancheng_marketing_promo', TRUE, '市场推广', 1, 3, 26),
(304, 152, '客户组', 'tiancheng_marketing_client', TRUE, '客户管理', 2, 3, 26),
-- 华信通信
(305, 153, '网络运营组', 'huaxin_network_ops', TRUE, '网络运营', 1, 3, 27),
(306, 153, '网络维护组', 'huaxin_network_maintain', TRUE, '网络维护', 2, 3, 27),
(307, 154, '客户服务组', 'huaxin_service_group', TRUE, '客户服务', 1, 3, 27),
(308, 154, '客户支持组', 'huaxin_service_support', TRUE, '客户支持', 2, 3, 27),
-- 嘉禾农业
(309, 155, '种植管理组', 'jiahe_plant_manage', TRUE, '种植管理', 1, 3, 28),
(310, 155, '种植实施组', 'jiahe_plant_impl', TRUE, '种植实施', 2, 3, 28),
(311, 156, '销售管理组', 'jiahe_sales_manage', TRUE, '销售管理', 1, 3, 28),
(312, 156, '销售服务组', 'jiahe_sales_service', TRUE, '销售服务', 2, 3, 28),
-- 博睿数据
(313, 157, '数据分析组', 'borui_data_analysis', TRUE, '数据分析', 1, 3, 29),
(314, 157, '数据处理组', 'borui_data_process', TRUE, '数据处理', 2, 3, 29),
(315, 158, '产品开发组', 'borui_product_dev', TRUE, '产品开发', 1, 3, 29),
(316, 158, '产品管理组', 'borui_product_manage', TRUE, '产品管理', 2, 3, 29),
-- 安泰安保
(317, 159, '安保服务组', 'antai_security_service', TRUE, '安保服务', 1, 3, 30),
(318, 159, '安保管理组', 'antai_security_manage', TRUE, '安保管理', 2, 3, 30),
(319, 160, '技术研发组', 'antai_tech_rd', TRUE, '技术研发', 1, 3, 30),
(320, 160, '技术支持组', 'antai_tech_support', TRUE, '技术支持', 2, 3, 30),
-- 新视界影视
(321, 161, '影视制作组', 'xinshijie_prod_group', TRUE, '影视制作', 1, 3, 31),
(322, 161, '拍摄组', 'xinshijie_prod_shoot', TRUE, '影视拍摄', 2, 3, 31),
(323, 162, '发行管理组', 'xinshijie_publish_manage', TRUE, '发行管理', 1, 3, 31),
(324, 162, '推广组', 'xinshijie_publish_promo', TRUE, '影视推广', 2, 3, 31);
