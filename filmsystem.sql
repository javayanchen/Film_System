/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : filmsystem

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2023-05-17 16:45:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `drama_type`
-- ----------------------------
DROP TABLE IF EXISTS `drama_type`;
CREATE TABLE `drama_type` (
  `drama_type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '电视剧分类编号，主键，自动增长\n',
  `type_id_id` int(11) NOT NULL COMMENT '电视剧分类编号',
  `drama_type_name` varchar(32) NOT NULL COMMENT '电视剧分类名称',
  PRIMARY KEY (`drama_type_id`) USING BTREE,
  KEY `type_id_id` (`type_id_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of drama_type
-- ----------------------------
INSERT INTO `drama_type` VALUES ('1', '1', '动画');
INSERT INTO `drama_type` VALUES ('2', '2', '古装');
INSERT INTO `drama_type` VALUES ('3', '3', '现代都市');

-- ----------------------------
-- Table structure for `film`
-- ----------------------------
DROP TABLE IF EXISTS `film`;
CREATE TABLE `film` (
  `film_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '影视编号，主键，自动增长\n',
  `film_name` varchar(100) NOT NULL COMMENT '影视名称\n',
  `type_id` int(11) NOT NULL COMMENT '影视类型，外键\n',
  `type_id_id` int(11) NOT NULL COMMENT '不同影视下的不同类型，外键',
  `film_time` varchar(11) DEFAULT '0:0' COMMENT '影视时长',
  `film_views` int(11) NOT NULL DEFAULT '0' COMMENT '浏览量',
  `film_author` varchar(32) NOT NULL COMMENT '影视导演',
  `film_intro` longtext NOT NULL COMMENT '影视简介',
  `film_image` longtext NOT NULL COMMENT '影视图片路径\n',
  `film_video` longtext NOT NULL COMMENT '影视视频路径\n',
  `status` int(11) NOT NULL DEFAULT '2' COMMENT '0-删除 1-热映中  2-待上映',
  PRIMARY KEY (`film_id`) USING BTREE,
  KEY `fk_film_type_id_file_type` (`type_id`) USING BTREE,
  CONSTRAINT `fk_film_type_id_file_type` FOREIGN KEY (`type_id`) REFERENCES `film_type` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of film
-- ----------------------------
INSERT INTO `film` VALUES ('1', '伍六七之暗影宿命 ', '4', '1', '7', '0', '何小疯', '本片主角伍六七原本在小鸡鸟上生活得无忧无虑,但因为失忆所以其身份成迷。随看外来者登入小岛认出了伍六七,各种阴谋也开始笼罩小鸡岛。于是伍六为了保护伙伴和他们的家园 详情 \r\n\r\n 本片主角伍六七原本在小鸡鸟上生活得无忧无虑,但因为失忆所以其身份成迷。随看外来者登入小岛认出了伍六七,各种阴谋也开始笼罩小鸡岛。于是伍六为了保护伙伴和他们的家园\r\n            ', 'C:\\Users\\27880\\Desktop', 'C:\\Users\\27880\\Desktop', '2');
INSERT INTO `film` VALUES ('2', '大明风华', '4', '2', '0', '0', '大明风华', '明永乐元年，御史大夫景清遭成祖朱棣满门抄斩，长女蔓姝为孙忠所救，化名孙若微收养家中。若干年后，隐秘势力“清正教”暗中操弄孙若微，欲将其嫁给野心勃勃的汉王。然而，因缘际会中她却嫁入东宫，成为与自己偶然相识的皇太孙朱瞻基的嫔妃。入宫后，身怀父仇家恨的孙若微历民间苍生之疾苦，睹宫廷险恶之争斗，她的心智逐渐成熟，情感也愈发倾向于心地善良的朱瞻基，最终，她决心放弃个人仇恨，辅佐登上皇位的丈夫为民众和天下谋求最大的幸福和安宁。朱瞻基英年溘逝，孙若微又先后经历了朱祁镇、朱祁钰两帝执政的时代，她用自己的气度和智慧数度救大明王朝于危难，并把自己一直秉持的仁德之心和以天下为己任的责任感传递到儿子朱祁镇身上。在后者开启的“英宗之治”中，历经坎坷的孙若薇终于可以“放下”命运所加与她的一切，坦然面对历史的洪流与辙痕\r\n            ', 'C:\\Users\\27880\\Desktop', 'C:\\Users\\27880\\Desktop', '2');
INSERT INTO `film` VALUES ('3', '大明风华', '4', '2', '0', '0', '大明风华', '明永乐元年，御史大夫景清遭成祖朱棣满门抄斩，长女蔓姝为孙忠所救，化名孙若微收养家中。若干年后，隐秘势力“清正教”暗中操弄孙若微，欲将其嫁给野心勃勃的汉王。然而，因缘际会中她却嫁入东宫，成为与自己偶然相识的皇太孙朱瞻基的嫔妃。入宫后，身怀父仇家恨的孙若微历民间苍生之疾苦，睹宫廷险恶之争斗，她的心智逐渐成熟，情感也愈发倾向于心地善良的朱瞻基，最终，她决心放弃个人仇恨，辅佐登上皇位的丈夫为民众和天下谋求最大的幸福和安宁。朱瞻基英年溘逝，孙若微又先后经历了朱祁镇、朱祁钰两帝执政的时代，她用自己的气度和智慧数度救大明王朝于危难，并把自己一直秉持的仁德之心和以天下为己任的责任感传递到儿子朱祁镇身上。在后者开启的“英宗之治”中，历经坎坷的孙若薇终于可以“放下”命运所加与她的一切，坦然面对历史的洪流与辙痕', 'C:\\Users\\27880\\Desktop', 'C:\\Users\\27880\\Desktop', '0');
INSERT INTO `film` VALUES ('4', '小欢喜', '4', '3', '6', '0', ' 汪俊', '北京某中档住宅小区顶楼，有三户人家的子女都进入了高考备战期。因抱着“一考定终身”的想法，三个家庭都陷入了无比焦灼的备战状态，由此引发的问题也接踵而至。林家的孩子因户籍原因无法在北京参考，全家人为此到天津买房，每天奔波往返于两个城市。乔家的两个孩子都明显偏科，让乔家夫妇焦急不已。冯家的孩子已经复读了三年，加上冯家夫妇隐藏了早已离婚的真相，整个家庭的气氛变得十分压抑。三个家庭各自在教育问题上反复挣扎，寻求出路。最终，孩子们都走出困境，获得成长。他们欣然接受了他们的考试结果。', 'C:\\Users\\27880\\Desktop', 'C:\\Users\\27880\\Desktop', '1');
INSERT INTO `film` VALUES ('5', '检察风', '5', '1', '0', '0', 'The Procurator', '大学教授夏薇（王丽坤饰）涉嫌故意杀人，舆论发酵失控，多方压力涌来。随着检察官李睿（黄景瑜饰）和同事张有成（王千源饰）对该案进行审查，发现作恶多端的富商陈鑫（包贝尔饰）与此案密切相关，一桩深埋多年的旧案被牵出…故意杀人案、强奸案、官商勾结环环相扣，所有人都被迫卷进这场命运的漩涡。李睿与夏薇辩护律师童雨辰（白百何饰）在法庭上激烈交锋，夏薇究竟为何沉默不语？她的丈夫洪俊山（冯绍峰饰）又隐藏了什么秘密？正邪敌我难辨，无法预料的危机等待着众人…\r\n            ', 'C:\\Users\\27880\\Desktop', 'C:\\Users\\27880\\Desktop', '2');
INSERT INTO `film` VALUES ('6', '速度与激情10', '5', '2', '0', '0', 'Fast X', '当家人们陷入危机，唐老大（范·迪塞尔 饰）为救飞车家族再度出山。终途启程，这场前所未有的疾速狂飙，你准备好了吗？', 'C:\\Users\\27880\\Desktop', 'C:\\Users\\27880\\Desktop', '1');
INSERT INTO `film` VALUES ('7', '灌篮高手', '5', '3', '0', '0', 'The First Slam Dunk', 'The First Slam Dunk」是《灌篮高手》首部大电影，也是最后一部！弥补青春遗憾的机会只此一次！宫城良田、三井寿、流川枫、樱木花道和赤木刚宪终于站在全国大赛的赛场，代表湘北高中与日本最强球队山王工业展开激烈对决。面对强大的对手，湘北五人组没有退缩，在安西教练的指导下，他们抱着破釜沉舟的决心热血奋战，究竟湘北能否取得比赛的最终胜利？承载好几代人热血梦想的全国大赛即将开赛，巅峰之战，就此一决！27年的等待即将划上完美句点，是时候跟自己的青春道别了！', 'C:\\Users\\27880\\Desktop', 'C:\\Users\\27880\\Desktop', '1');
INSERT INTO `film` VALUES ('8', '艾顿肋骨挫伤无缘太阳掘金G6 保罗也继续缺阵', '6', '1', '11', '0', '央视网', '在此前的天王山之战中，艾顿被布鲁斯-布朗肘到肋骨，之后他坚持比赛，但在赛后表示肋骨十分疼痛。今日，太阳宣布艾顿将因肋骨挫伤缺席系列赛G6。\r\n\r\n　　当地媒体报道，艾顿遭遇的是肋骨严重挫伤，他的肋骨以及核心部位痛感剧烈，影响了他的运动和呼吸。目前，太阳大比分2-3落后于掘金。除了艾顿之外，保罗也将因腹股沟拉伤继续缺席。\r\n            ', 'C:\\Users\\27880\\Desktop', 'C:\\Users\\27880\\Desktop', '2');
INSERT INTO `film` VALUES ('9', '欧联杯-博格巴助攻加蒂破门 尤文1-1绝平塞维利亚', '6', '2', '0', '8', '陈澜', '北京时间5月12日凌晨03:00，欧联杯半决赛首回合尤文图斯坐镇主场迎战塞维利亚。上半场恩内斯里破门，下半场博努奇伤退，博格巴助攻加蒂97分钟绝平，尤文图斯1-1战平塞维利亚。\r\n            ', 'C:\\Users\\27880\\Desktop', 'C:\\Users\\27880\\Desktop', '1');
INSERT INTO `film` VALUES ('10', '罗马站-郑钦文再胜科内 进32强即时排名跻身前20', '6', '3', '0', '0', '林芷', '北京时间5月12日，2023年WTA1000罗马站女单第二轮。中国球员郑钦文6-3/7-6（2）直落两盘击败世界排名第64位的法国好手科内，继去年法网之后再胜对手，昂首晋级女单32强。\r\n\r\n凭借本场胜利，郑钦文收获65个积分，即时排名挺进Top20，列第18位。\r\n            ', 'C:\\Users\\27880\\Desktop', 'C:\\Users\\27880\\Desktop', '2');
INSERT INTO `film` VALUES ('11', '肖申克的救赎', '5', '2', '0', '0', '弗兰克·德拉邦特', '故事讲述了银行家安迪因被错判谋杀妻子和她的情人而入狱，在那里他结识了一些罪犯，他们之间结下了深厚的友谊，最终安迪在朋友们的帮助下逃出了监狱，并找到了藏起来的伞兵刀，正义最终战胜了邪恶。', '/images/xskdjs.jpg\', \'/videos/xskdjs.mp4\'', '/images/xskdjs.jpg\', \'/videos/xskdjs.mp4\'', '1');
INSERT INTO `film` VALUES ('12', '大话西游之月光宝盒', '5', '1', '0', '0', '刘镇伟', '悟空和紫霞仙子为了寻找月光宝盒而历经千辛万苦，经过一番波折后终于拿到了月光宝盒，但是却遭到了妖怪的袭击，经过一番激战，孙悟空和紫霞仙子最终战胜了妖怪，保卫了月光宝盒。', '\'/images/dhxyszmg.jpg', '\'/images/dhxyszmg.jpg', '1');
INSERT INTO `film` VALUES ('13', '大话西游之大圣娶亲', '5', '1', '0', '0', '刘镇伟', '孙悟空为了追寻自由而拜师学艺，他在路上结识了猪八戒、沙悟净和唐僧，一路上经历了许多困难和危险，最终成功地护送唐僧取回了真经，成就了大圣的名号。', '/images/dhxyszdsqq.jpg', '/images/dhxyszdsqq.jpg', '1');
INSERT INTO `film` VALUES ('14', '盗梦空间', '5', '2', '0', '0', '克里斯托弗·诺兰', '故事讲述了一个关于梦境和现实之间错综复杂的故事，影片采用非线性的故事结构，通过梦境的层层嵌套，让观众沉浸在这个充满惊奇和感动的世界中', '/images/dmkj.jpg', '/images/dmkj.jpg', '1');
INSERT INTO `film` VALUES ('15', '霸王别姬', '5', '1', '0', '0', '陈凯歌', '讲述了程蝶衣与段小楼这两个男人的一生，一个是武生，一个是女装旦角，在舞台上他们互相依靠、互相支持，创造出了不朽的艺术形象。但在现实生活中，他们之间却有着太多的矛盾和疏离，最终导致了悲剧的结局。', 'images/slzq.jpg', 'images/slzq.jpg', '1');
INSERT INTO `film` VALUES ('16', '泰坦尼克号', '5', '2', '0', '0', '詹姆斯·卡梅隆', '故事讲述了铁匠威尔和富家女露丝在号称“永不沉没”的泰坦尼克号上相遇，并坠入爱河，但最终在船只触礁沉没的灾难中，威尔为了让露丝生存下去而牺牲了自己。', '/images/ttnkh.jpg', '/images/ttnkh.jpg', '1');
INSERT INTO `film` VALUES ('17', '复仇者联盟4', '5', '2', '0', '0', '安东尼·罗素 / 乔·罗素', '\'《复仇者联盟4：终局之战》是由漫威影业出品的科幻动作电影，为2012年电影《复仇者联盟》及2015年电影《复仇者联盟2：奥创纪元》的续集，也是漫威影业“第三阶段”的第四部作品，由安东尼·罗素和乔·罗素共同执导，小罗伯特·唐尼、 克里斯·埃文斯、克里斯·海姆斯沃斯、马克·鲁法洛、斯嘉丽·约翰逊等联合主演。', '/picsum.photos', '/picsum.photos', '1');
INSERT INTO `film` VALUES ('18', '阿凡达', '5', '2', '0', '0', '詹姆斯·卡梅隆', '《阿凡达》（Avatar）是一部2009年上映的3D科幻电影，由詹姆斯·卡梅隆执导，桑娜·沙芬、赛门·威尔斯等主演。该片讲述了人类为了开采一种名为“不可思议”的矿物质而到达潘多拉星球并与当地族人纳美人发生冲突的故事。', '/picsum.photos', '/picsum.photos', '1');
INSERT INTO `film` VALUES ('19', '星球大战7：原力觉醒', '5', '2', '0', '0', 'J·J·艾布拉姆斯', '\'《星球大战7：原力觉醒》是由J·J·艾布拉姆斯执导的一部科幻电影，是《星球大战》系列中的第七部作品。该片由黛西·雷德利、约翰·博耶加、奥斯卡·伊萨克等主演。', '/picsum.photos', '/picsum.photos', '1');
INSERT INTO `film` VALUES ('20', '琅琊榜', '4', '2', '0', '0', '孔笙', '讲述了蒙毅先后历任琅琊阁七品翰林院编修、开国公太子詹事、任光禄少卿、菜园子督监、南楚大将军等职位，最终成为一代功臣的故事。', 'langyabang.jpeg', 'langyabang.jpeg', '1');
INSERT INTO `film` VALUES ('21', '三生三世十里桃花', '4', '2', '0', '0', '林玉芬', '通过逆天改命的白浅、因爱守护的夜华和几经波折的凤九三个人物之间的感情纠葛，展现出仙侠世界中的种种情感。', 'sanshengsanshi.jpeg', 'sanshengsanshi.jpeg', '0');
INSERT INTO `film` VALUES ('22', '独孤皇后', '4', '2', '0', '0', '赵军', '讲述了北周著名女政治家独孤伽罗经历了人生中的三段感情，从一个柔弱的少女成长为能够自立、自主的女子汉子，并最终成为“北周贤后”的故事。', 'dugu.jpeg\'', 'dugu.jpeg\'', '1');
INSERT INTO `film` VALUES ('23', '楚乔传', '4', '2', '0', '0', '郑晓龙', '\'讲述了杨幂饰演的时空穿越者楚乔，在异世界里历经千辛万苦，逆袭嬴国公的故事', 'chuqiaozhuan.mp4', 'chuqiaozhuan.mp4', '1');
INSERT INTO `film` VALUES ('24', '步步惊心', '4', '2', '0', '0', '李国立', '根据同名小说改编，讲述了穿越到清朝的现代女子张晓穹，在历史中的波澜万丈的爱情故事。', 'qingyuanian.jpeg', 'qingyuanian.jpeg', '1');
INSERT INTO `film` VALUES ('25', '庆余年', '4', '2', '0', '0', '陈家霖', '以宋末欧阳修、苏轼为原型，绘制出了一个真实而鲜活的大宋城市画卷和以欧阳修为首的文艺群体的生活状态。', 'qingyuanian.mp4', 'qingyuanian.mp4', '0');
INSERT INTO `film` VALUES ('26', '芈月传', '4', '2', '0', '0', '张黎', '\'通过叙述战国时代秦国后宫艰苦的生活以及赵姬崛起的过程，展现出中华文明的辉煌和女性的坚强不屈。', 'miyue.mp4', 'miyue.mp4', '0');
INSERT INTO `film` VALUES ('27', '巴特勒24+8 热火淘汰尼克斯晋级NBA东部决赛', '6', '1', '0', '0', '殷实', '北京时间5月13日，NBA季后赛第二轮，热火96-92胜尼克斯，大比分4-2淘汰尼克斯晋级东部决赛。\r\n\r\n\r\n画中画\r\n开场尼克斯率先发力，热火队处于下风，首节尼克斯队领先热火队7分。第二节，热火队一波10-0反超打停尼克斯，半场结束时，热火领先尼克斯1分。\r\n\r\n下半场，热火一直保持微弱领先，三节过后，热火队领先3分。第四节，尼克斯紧咬比分但一直未能反超，最终，热火96-92险胜尼克斯。', 'C:\\Users\\27880\\Desktop', 'C:\\Users\\27880\\Desktop', '1');
INSERT INTO `film` VALUES ('28', '掘金4-2太阳进西决 约基奇32+10+11布克仅12分', '6', '1', '0', '0', '殷实', '北京时间5月12日，NBA季后赛继续进行，丹佛掘金队赢球晋级西部决赛。约基奇送出32分、10个篮板和12次助攻，穆雷和波普都得分20+，他们率队上半场确立大比分优势，掘金队在西部半决赛第六场做客以125-100大胜菲尼克斯太阳队。掘金队以4-2淘汰太阳队晋级，他们将在西部决赛等待洛杉矶湖人队和金州勇士队之间的胜者。\r\n\r\n\r\n画中画\r\n掘金队的约基奇得到32分、10个篮板和12次助攻，穆雷得到26分、4个篮板和4次助攻，波普得到21分和5个篮板，布朗得到13分和5个篮板，波特得到10分和5个篮板。太阳队的佩恩得到31分和6个篮板，杜兰特得到23分、5个篮板和5次助攻，布克13投4中，得到12分和8次助攻，兰戴尔得到13分和5个篮板。\r\n\r\n[图]掘金4-2太阳进西决 约基奇32+10+11布克12分\r\n\r\n[图]掘金4-2太阳进西决 约基奇32+10+11布克12分\r\n\r\n掘金队首发阵容：穆雷、波特、波普、戈登、约基奇\r\n\r\n太阳队首发阵容：佩恩、沙梅特、布克、杜兰特、兰戴尔', 'C:\\Users\\27880\\Desktop', 'C:\\Users\\27880\\Desktop', '1');
INSERT INTO `film` VALUES ('29', '艾顿肋骨挫伤无缘太阳掘金G6 保罗也继续缺阵', '6', '1', '0', '0', '殷实', '北京时间5月12日，据著名NBA记者沙姆斯-查拉尼亚报道，太阳中锋德安德烈-艾顿因肋骨挫伤将缺席今日太阳对阵掘金的第六战。\r\n\r\n　　在此前的天王山之战中，艾顿被布鲁斯-布朗肘到肋骨，之后他坚持比赛，但在赛后表示肋骨十分疼痛。今日，太阳宣布艾顿将因肋骨挫伤缺席系列赛G6。\r\n\r\n　　当地媒体报道，艾顿遭遇的是肋骨严重挫伤，他的肋骨以及核心部位痛感剧烈，影响了他的运动和呼吸。目前，太阳大比分2-3落后于掘金。除了艾顿之外，保罗也将因腹股沟拉伤继续缺席。', 'C:\\Users\\27880\\Desktop', 'C:\\Users\\27880\\Desktop', '1');
INSERT INTO `film` VALUES ('30', '浓眉未进入脑震荡保护协议 大概率出战湖勇G6', '6', '1', '0', '0', '殷实', '央视网消息：北京时间5月12日，据湖人跟队记者乔万-布哈报道，湖人球星安东尼-戴维斯未进入脑震荡保护协议，大概率出战湖人勇士系列赛第六战。湖勇大战G5的第四节，浓眉被鲁尼打到头部，随后伤退离场，一度坐轮椅去接受检查。\r\n\r\n当时NBA场边记者克里斯-海恩斯透露，浓眉可能出现脑震荡症状，一旦进入脑震荡保护协议，他将无法出战湖勇大战的G6。\r\n\r\n　　而经过今日的检查，湖人主帅哈姆透露，浓眉未进入脑震荡保护协议，大概率出战明日的G6。在湖人官方的伤病报告中，浓眉的出战状态同样为大概率出战。', 'C:\\Users\\27880\\Desktop', 'C:\\Users\\27880\\Desktop', '1');
INSERT INTO `film` VALUES ('31', '2脚世界波，1-1！欧冠19亿对决：哈兰德隐身，瓜帅0换人', '6', '3', '0', '0', '叶青足球世界', '北京时间5月10日凌晨，欧冠半决赛首回合，皇马主场迎战曼城。韦尼修斯世界波打破僵局，德布劳内的冷箭扳平比分，两队1-1握手言和，次回合的伊蒂哈德之战，将是真正的生死对决。\r\n\r\n\r\n\r\n\r\n瓜迪奥拉不整活，哈兰德、格拉利什、B席、德布劳内、京多安联袂首发，斯通斯继续踢“腰卫摇摆人”；皇马的首发没有任何悬念，本泽马搭配巴西双子星，莫德里奇、克罗斯掌控中场。这场19亿欧元对决（曼城10.5亿，皇马8.6亿），可谓是举世瞩目。\r\n\r\n\r\n\r\n\r\n球迷闭着眼睛，也能猜到剧情——曼城占据控球权，将战火烧到皇马半场；皇马压缩433阵型，诱敌深入，任由曼城“无效控球”，韦尼修斯、罗德里戈伺机而动，一旦有机会迅速反击。\r\n\r\n\r\n\r\n\r\n哈兰德有些沉寂\r\n\r\n上半场的曼城，控球率高达70%，场面上压制皇马，但哈兰德、罗德里、德布劳内的射门，并未形成真正的威胁。反观皇马，1次闪电反击，第1脚射门，就打破僵局：\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n卡马文加与莫德里奇配合，法国小将带球长驱直入，皇马进攻瞬间提速。卡马文加传球，韦尼修斯禁区外轰出世界波，皇马1-0领先！\r\n\r\n\r\n\r\n\r\n镜头给到曼城球员——斯通斯、埃德森一脸茫然：场面占优的是曼城，但领先的是皇马。韦尼修斯欧冠7球6助，展现巨星风采；卡马文加的奔袭，更是惊艳。皇马的00后球员，看上去像身经百战的老将。\r\n\r\n\r\n\r\n\r\n易边再战，皇马依旧是老套路：绝不轻易出击，一旦压上，便是绝对机会。两大名帅博弈斗法，玩起心理战：曼城压迫力度减弱，皇马就加强冲击；曼城也“学”皇马，让出控球权，让皇马犯错。\r\n\r\n\r\n\r\n\r\n第67分钟，曼城扳平比分：卡马文加的传球被拦截，格拉利什、京多安传递配合，大禁区弧顶处，德布劳内右脚低射死角，1-1！\r\n\r\n\r\n\r\n\r\n1-1之后，双方又进入拉锯战。皇马见招拆招，有机会就逐渐压上，加强前场的突击。巴尔韦德穿裆阿坎吉，卡马文加的带球冲击，都创造出机会。第77分钟，克罗斯任意球吊入禁区，本泽马的头球冲顶被埃德森扑出。\r\n\r\n\r\n\r\n\r\n最后10分钟，曼城中后场控球传递，皇马稳扎稳打，双方都非常谨慎。皇马先后换上阿森西奥、琼阿梅尼、纳乔，曼城则是按兵不动。第84分钟，韦尼修斯耍起彩虹过人，但沃克死死卡住韦尼修斯。\r\n\r\n\r\n\r\n\r\n第90分钟，琼阿梅尼的重炮惊出曼城一身冷汗。\r\n\r\n最终，两队打成1-1平，下周三，双方移师伊蒂哈德球场。对瓜迪奥拉的曼城来说，平局可以接受。全场0换人，这说明瓜迪奥拉对场上的球员表现满意。', 'C:\\Users\\27880\\Desktop', 'C:\\Users\\27880\\Desktop', '1');
INSERT INTO `film` VALUES ('32', '西甲-巴萨4-2西班牙人提前4轮夺冠 莱万双响', '6', '3', '0', '0', '网易体育', '北京时间5月15日凌晨3点，22/23赛季西甲联赛第34轮继续。在科内利亚体育场，巴塞罗那客场4-2轻取西班牙人，提前4轮赢得联赛冠军。莱万梅开二度，巴尔德传射，孔德打进处子球，普阿多和何塞卢为西班牙人各进一球。\r\n\r\n\r\n\r\n\r\n\r\n第6分钟孔德右路底线倒三角传球，佩德里禁区右侧推射远角滑门而过。第10分钟巴尔德左路突破底线横传，莱万小禁区中路推射破门。1-0，巴萨首开纪录！\r\n\r\n\r\n\r\n20分钟佩德里右路传中，巴尔德小禁区左侧凌空垫射破门。2-0，巴萨扩大优势，巴尔德传射！\r\n\r\n\r\n\r\n26分钟孔德禁区弧右侧大力抽射，皮球稍稍偏出。40分钟拉菲尼亚反击中右路横传，莱万小禁区中路左脚铲射破门。3-0，巴萨锁定胜局，莱万梅开二度！\r\n\r\n\r\n\r\n46分钟达德尔右路横传，布莱斯维特点球点左侧扫射，孔德飞身将球挡出。\r\n\r\n53分钟德容中路精准挑传，孔德右侧小禁区前头球破门。4-0，孔德收获处子球！\r\n\r\n\r\n\r\n65分钟阿尔巴左路传中，登贝莱前点甩头偏出远门柱。70分钟普阿多禁区右侧单刀低射，特尔施特根用腿将球挡出。\r\n\r\n74分钟卡莱罗后场直传，普阿多单刀挑射破门。1-4，西班牙人扳回一球！\r\n\r\n\r\n\r\n92分钟西班牙人左路传中，达德尔点球点前头球击中门柱，何塞卢小禁区右侧补射破门。2-4，西班牙人再追一球！\r\n\r\n\r\n\r\n西班牙人(5-3-2)：13-帕切科/2-奥斯卡-希尔、23-蒙特斯、24-塞尔吉-戈麦斯(46’5-卡莱罗)、4-卡夫雷拉、14-奥利万(84’30-科莱索)/21-梅拉梅德(88’20-埃斯波西托)、10-达德尔、6-丹尼斯-苏亚雷斯(46’7-普阿多)/17-布莱斯维特(56’3-佩德罗萨)、9-何塞卢\r\n\r\n巴塞罗那(4-3-3)：1-特尔施特根/23-孔德、4-阿劳霍(63’18-阿尔巴)、15-克里斯滕森(75’17-马科斯-阿隆索)、28-巴尔德/8-佩德里(89’19-凯西)、5-布斯克茨、21-德容/22-拉菲尼亚(62’7-登贝莱)、9-莱万多夫斯基、30-加维(75’10-法蒂)', 'C:\\Users\\27880\\Desktop\\', 'C:\\Users\\27880\\Desktop\\', '1');
INSERT INTO `film` VALUES ('33', '法甲-姆巴佩双响梅西复出 巴黎5-0阿雅克肖6分领跑', '6', '3', '0', '0', '张琳', '北京时间5月14日凌晨3点，22/23赛季法甲联赛第35轮继续。在王子公园球场，巴黎圣日耳曼主场5-0大胜阿雅克肖，以6分优势领跑积分榜，阿雅克肖提前降级。姆巴佩梅开二度，法比安-鲁伊斯和阿什拉夫各进一球，阿雅克肖球员优素福乌龙，阿什拉夫和曼加尼被红牌罚下。\r\n\r\n\r\n\r\n在人员方面，梅西和阿什拉夫解禁复出，金彭贝、内马尔、努诺-门德斯、穆凯莱和彭贝莱因伤休战。21分钟达尼洛-佩雷拉直传，法比安-路易斯中路小禁区前外脚背弹射破门。1-0，巴黎首开纪录！\r\n\r\n\r\n\r\n32分钟姆巴佩小禁区前乱战中射门被扑出，阿什拉夫小禁区右侧补射破门。2-0，巴黎扩大优势！\r\n\r\n\r\n\r\n46分钟埃基蒂克禁区中路分球，姆巴佩左侧小禁区前大力抽射，皮球被扑了一下后仍滚入网窝。3-0，巴黎锁定胜局！\r\n\r\n\r\n\r\n53分钟拉莫斯后场长传，阿维内尔头球解围不远，姆巴佩大禁区中路凌空抽射破门。4-0，姆巴佩梅开二度！\r\n\r\n\r\n\r\n60分钟达尼洛-佩雷拉禁区弧左侧大力兜射，索拉卡罗将球扑住。\r\n\r\n72分钟维蒂尼亚直传，马基尼奥斯禁区左侧射门，皮球被优素福挡入自家大门。5-0，巴黎血洗阿雅克肖！\r\n\r\n\r\n\r\n80分钟曼加尼放倒梅西后又踢一脚，双方球员发生冲突，阿什拉夫和曼加尼均被红牌罚下。\r\n\r\n\r\n\r\n\r\n\r\n87分钟维达尔头球解围不远，扎伊尔-埃梅里右侧小禁区前凌空抽射踢偏。\r\n\r\n巴黎圣日耳曼(3-4-1-2)：99-多纳鲁马/5-马基尼奥斯、4-拉莫斯、15-达尼洛-佩雷拉(70’31-比希阿布)/2-阿什拉夫、6-维拉蒂(64’18-桑谢斯)、8-法比安-鲁伊斯(64’17-维蒂尼亚)、14-贝尔纳特(83’28-索莱尔)/30-梅西/44-埃基蒂克(83’33-扎伊尔-埃梅里)、7-姆巴佩\r\n\r\n阿雅克肖(4-5-1)：16-索拉卡罗/20-优素福、21-阿维内尔、15-维达尔、3-伊斯迈尔-迪亚洛(71’2-阿方斯)/4-巴雷托(83’29-查布罗勒)、8-马切蒂、23-曼加尼、6-库塔德尔(63’34-苏玛诺)、27-斯帕达努达(63’38-切格拉)/7-伊德里斯(64’5-诺里)', 'C:\\Users\\27880\\Desktop\\', 'C:\\Users\\27880\\Desktop\\', '1');
INSERT INTO `film` VALUES ('34', '权力的游戏', '5', '2', '1:30', '0', 'kiybgn', '权力的游戏', 'DesktopfilmsystemTwooutartifactsfilmsystem_war_explodedfileupload2.jpg', 'DesktopfilmsystemTwooutartifactsfilmsystem_war_explodedfileupload2.jpg', '2');
INSERT INTO `film` VALUES ('35', '权力的游戏', '5', '2', '1:30', '0', 'kiybgn', '权力的游戏', 'DesktopfilmsystemTwooutartifactsfilmsystem_war_explodedfileupload2.jpg', 'DesktopfilmsystemTwooutartifactsfilmsystem_war_explodedfileupload2.jpg', '2');
INSERT INTO `film` VALUES ('42', '伍六七', '4', '1', '25:25', '801', '未知', '伍六七\r\n            ', '/fileupload/49022dc8-e470-488d-b376-ac67d3be2f8c2.jpg', '/fileupload/49022dc8-e470-488d-b376-ac67d3be2f8c2.jpg', '1');
INSERT INTO `film` VALUES ('43', '伍六七', '4', '2', '25:25', '500', '未知', '伍六七', '/fileupload/1150dccc-ccec-473c-9d1f-3868a3b733f92.jpg', '/fileupload/1150dccc-ccec-473c-9d1f-3868a3b733f92.jpg', '2');
INSERT INTO `film` VALUES ('44', '郭艾伦24分赵继伟17+11 辽宁横扫浙江成功卫冕  ', '6', '1', '25:25', '1000', '浙江篮男', '郭艾伦24分赵继伟17+11 辽宁横扫浙江成功卫冕  \r\n            ', '/fileupload/4ea4c916-7f9b-4266-8828-72ed61bed48616.jpg', '/fileupload/4ea4c916-7f9b-4266-8828-72ed61bed48616.jpg', '1');
INSERT INTO `film` VALUES ('45', '复仇者联盟4', '5', '2', '1:45', '100000', 'kaiajid', '复仇者联盟4\r\n            ', '/fileupload/ec5d8bdb-cd97-44c8-bccb-ecf92e95be1612.jpg', '/fileupload/ec5d8bdb-cd97-44c8-bccb-ecf92e95be1612.jpg', '1');
INSERT INTO `film` VALUES ('46', '灌篮高手', '4', '1', '25:25', '85473', '井上肆廖', '灌篮高手\r\n            \r\n            ', '/fileupload/1e4b59a8-4e76-4ac7-916a-8e03dd0ee58a6.jpg', '/fileupload/1e4b59a8-4e76-4ac7-916a-8e03dd0ee58a6.jpg', '2');
INSERT INTO `film` VALUES ('47', '小欢喜', '4', '3', '1:45', '851', '海清', '小欢喜\r\n            ', '/fileupload/cbf52ad2-e2fc-4ace-b938-21f296bd18ed4.jpg', '/fileupload/cbf52ad2-e2fc-4ace-b938-21f296bd18ed4.jpg', '1');
INSERT INTO `film` VALUES ('48', '检察风云', '4', '3', '1:45', '9523', '王珞丹', '检察风云\r\n            ', '/fileupload/2e0e35c5-af71-4d05-8ef5-07d69a46f1e85.jpg', '/fileupload/2e0e35c5-af71-4d05-8ef5-07d69a46f1e85.jpg', '1');
INSERT INTO `film` VALUES ('49', '法国对战哈莫马', '6', '3', '1:45', '894', '国际足协', '法国对战哈莫马\r\n            ', '/fileupload/826015f4-3781-436c-9a27-39e4cdaee85b18.jpg', '/fileupload/826015f4-3781-436c-9a27-39e4cdaee85b18.jpg', '1');
INSERT INTO `film` VALUES ('50', 'C罗踢进决胜一球', '6', '3', '1:45', '962', '国际足协', 'C罗踢进决胜一球\r\n            ', '/fileupload/39deaf81-d3ee-42d0-a9d7-45b85f79804c17.jpg', '/fileupload/39deaf81-d3ee-42d0-a9d7-45b85f79804c17.jpg', '1');
INSERT INTO `film` VALUES ('51', '吉米 巴特勒', '6', '1', '1:45', '3154', '国际篮协', '吉米 巴特勒\r\n            ', '/fileupload/54877b00-9b48-4af2-97ad-2e0bfec3f54315.jpg', '/fileupload/54877b00-9b48-4af2-97ad-2e0bfec3f54315.jpg', '1');
INSERT INTO `film` VALUES ('52', '速度与激情10', '5', '2', '1:45', '8491', '路易斯 莱特里尔', '速度与激情10\r\n            ', '/fileupload/f6bfaf61-e273-485d-8360-cd182ed838bd8.jpg', '/fileupload/f6bfaf61-e273-485d-8360-cd182ed838bd8.jpg', '1');
INSERT INTO `film` VALUES ('53', '阿凡达', '5', '2', '1:45', '69854', '詹姆斯 卡梅隆', '阿凡达\r\n            ', '/fileupload/8ad58b7a-ad4b-4ed0-876a-e16bfe45b82e9.jpg', '/fileupload/8ad58b7a-ad4b-4ed0-876a-e16bfe45b82e9.jpg', '1');
INSERT INTO `film` VALUES ('54', '大话西游', '5', '1', '1:45', '21546', '刘镇伟', '大话西游\r\n            ', '/fileupload/fecf4a95-f018-4d0c-b5b1-29d5e4f913b411.jpg', '/fileupload/fecf4a95-f018-4d0c-b5b1-29d5e4f913b411.jpg', '1');
INSERT INTO `film` VALUES ('55', '是激动', '4', '1', '25:25', '0', '市东南方', '是激动', '/fileupload/12df36d5-ffa3-4f51-8e00-53ec68b5f10f13.jpg', '/fileupload/12df36d5-ffa3-4f51-8e00-53ec68b5f10f13.jpg', '2');

-- ----------------------------
-- Table structure for `film_type`
-- ----------------------------
DROP TABLE IF EXISTS `film_type`;
CREATE TABLE `film_type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '影视分类编号，主键，自动增长\n',
  `type_name` varchar(32) DEFAULT NULL COMMENT '影视分类名称',
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of film_type
-- ----------------------------
INSERT INTO `film_type` VALUES ('4', '电视剧');
INSERT INTO `film_type` VALUES ('5', '电影');
INSERT INTO `film_type` VALUES ('6', '体育');

-- ----------------------------
-- Table structure for `movie_type`
-- ----------------------------
DROP TABLE IF EXISTS `movie_type`;
CREATE TABLE `movie_type` (
  `movie_type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '电影分类编号，主键，自动增长',
  `type_id_id` int(11) NOT NULL COMMENT '电影分类编号',
  `movie_type_name` varchar(32) NOT NULL COMMENT '电影分类名称\n',
  PRIMARY KEY (`movie_type_id`) USING BTREE,
  KEY `type_id_id` (`type_id_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of movie_type
-- ----------------------------
INSERT INTO `movie_type` VALUES ('1', '1', '大陆');
INSERT INTO `movie_type` VALUES ('2', '2', '美国');
INSERT INTO `movie_type` VALUES ('3', '3', '日本');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色编号，主键，自动增长，1-普通用户 2-\n管理员',
  `role_name` varchar(32) NOT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '普通用户');
INSERT INTO `role` VALUES ('2', '管理员');

-- ----------------------------
-- Table structure for `sport_type`
-- ----------------------------
DROP TABLE IF EXISTS `sport_type`;
CREATE TABLE `sport_type` (
  `sport_type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '体育视频分类编号，主键，自动增长\n',
  `type_id_id` int(11) NOT NULL COMMENT '体育视频分类编号',
  `sport_type_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '体育视频分类名称',
  PRIMARY KEY (`sport_type_id`) USING BTREE,
  KEY `type_id_id` (`type_id_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sport_type
-- ----------------------------
INSERT INTO `sport_type` VALUES ('1', '1', '篮球');
INSERT INTO `sport_type` VALUES ('2', '2', '网球');
INSERT INTO `sport_type` VALUES ('3', '3', '足球');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号，主键，自动增长\n',
  `user_name` varchar(32) NOT NULL DEFAULT '' COMMENT '用户登录时使用的帐号名称\n',
  `user_password` varchar(32) NOT NULL DEFAULT '' COMMENT '用户登录时使用的密码\n',
  `email` varchar(32) NOT NULL COMMENT '用户邮箱',
  `role_id` int(11) NOT NULL COMMENT '用户的角色编号，外键\n',
  `create_time` datetime NOT NULL COMMENT '用户创建日期\n',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '用户账号状态：0-禁用 1-可用',
  PRIMARY KEY (`user_id`) USING BTREE,
  KEY `fk_user_role_id_role` (`role_id`) USING BTREE,
  CONSTRAINT `fk_user_role_id_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'lucy', 'lucy123', 'lucy@example.com', '1', '2023-05-12 03:34:31', '0');
INSERT INTO `user` VALUES ('2', 'jack', 'jack123', 'jack@example.com', '1', '2023-05-12 03:34:31', '0');
INSERT INTO `user` VALUES ('3', 'tom', 'tom123456', 'tom@example.com', '1', '2023-05-12 03:34:31', '0');
INSERT INTO `user` VALUES ('4', 'mary', 'mary123', 'mary@example.com', '1', '2023-05-12 03:34:31', '1');
INSERT INTO `user` VALUES ('5', 'bob', 'bob123', 'bob@example.com', '2', '2023-05-12 03:34:31', '0');
INSERT INTO `user` VALUES ('31', '小牧', '2D21844F2CFCD4862E41BA064C3A4FD3', '20@qq.com', '2', '2023-05-15 00:00:00', '1');
INSERT INTO `user` VALUES ('32', '小林', '2D21844F2CFCD4862E41BA064C3A4FD3', '20151@qq.com', '1', '2023-05-15 00:00:00', '1');
INSERT INTO `user` VALUES ('33', '小小', '2D21844F2CFCD4862E41BA064C3A4FD3', '2049453119@qq.com', '1', '2023-05-17 00:00:00', '1');
INSERT INTO `user` VALUES ('34', '邻里', '2D21844F2CFCD4862E41BA064C3A4FD3', '2049453119@qq.com', '1', '2023-05-17 00:00:00', '1');
INSERT INTO `user` VALUES ('35', '啥地方呢', '2D21844F2CFCD4862E41BA064C3A4FD3', '2049453119@qq.com', '1', '2023-05-17 00:00:00', '1');
