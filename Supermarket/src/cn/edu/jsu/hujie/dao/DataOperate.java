package cn.edu.jsu.hujie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import com.sun.net.httpserver.Authenticator.Result;

import cn.edu.jsu.hujie.dbc.DatabaseConnectionSql;
import cn.edu.jsu.hujie.vo.Commodity;

/**
 * 工具类的操作
 * @author 胡洁
 *
 */
public class DataOperate {

	private static String firstName = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田樊胡凌霍虞万支柯咎管卢莫经房裘缪干解应宗宣丁贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊於惠甄魏加封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘钭厉戎祖武符刘姜詹束龙叶幸司韶郜黎蓟薄印宿白怀蒲台从鄂索咸籍赖卓蔺屠蒙池乔阴郁胥能苍双闻莘党翟谭贡劳逄姬申扶堵冉宰郦雍却璩桑桂濮牛寿通边扈燕冀郏浦尚农温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古易慎戈廖庚终暨居衡步都耿满弘匡国文寇广禄阙东殴殳沃利蔚越夔隆师巩厍聂晁勾敖融冷訾辛阚那简饶空曾毋沙乜养鞠须丰巢关蒯相查后江红游竺权逯盖益桓公万俟司马上官欧阳夏侯诸葛闻人东方赫连皇甫尉迟公羊澹台公冶宗政濮阳淳于仲孙太叔申屠公孙乐正轩辕令狐钟离闾丘长孙慕容鲜于宇文司徒司空亓官司寇仉督子车颛孙端木巫马公西漆雕乐正壤驷公良拓拔夹谷宰父谷粱晋楚阎法汝鄢涂钦段干百里东郭南门呼延归海羊舌微生岳帅缑亢况后有琴梁丘左丘东门西门商牟佘佴伯赏南宫墨哈谯笪年爱阳佟第五言福百家姓续";
	
	private static String girl = "秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽 ";
	
	private static String boy = "伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";

	
	
	/**
	 * 随机获取i到j间的整数
	 * @param i 整数
	 * @param j 整数
	 * @return int
	 */
	public static int getNum(int i, int j) {
		return (int) (Math.random() * (j - i + 1) + i);
	}

	/**
	 * 获取商品编号
	 * @return StringBuilder
	 */
	public static StringBuilder getId() {
		StringBuilder id = new StringBuilder(String.valueOf(getNum(0, 100000)));
		return id;
	}
	
	/**
	 * 获取商品类型
	 * @return String
	 */
	public static String getType() {
		String type[] = { "食物类", "玩具类", "游戏类", "服装类" };
		return type[getNum(0, 3)];
	}
	
	/**
	 * 获取商品名称
	 * @return String
	 */
	public static String getName() {
		String first, second, three;
		three = "";
		int index = getNum(0, firstName.length() - 1);
		first = firstName.substring(index, index + 1);
		int sex = getNum(0, 1);// 随机取性别，例如1为男生，0为女生
		String str = boy;// 定义名字为男生字符串
		int length = boy.length();// 获取男生字符串的长度
		if (sex == 0) {// 如果随机获取为0，则名字改为女生
			str = girl;
			length = girl.length();
		}
		index = getNum(0, str.length() - 1);
		second = str.substring(index, index + 1);
		if (getNum(0, 1) == 1) {
			index = getNum(0, str.length() - 1);
			three = str.substring(index, index + 1);
		}
		return first + second + three;
	}
	
	/**
	 * 获得商品数量
	 * @return int
	 */
	public static int getNumber() {
		return getNum(1, 100);
	}

	/**
	 * 获得商品单价
	 * @return int
	 */
	public static int getPrice() {
		return getNum(1, 100);
	}

	/**
	 * 获得交易单号
	 * @return StringBuilder
	 */
	public static StringBuilder getOddnumber() {
		String str[]= {"A","B","C","D","E","S","M","N"};
		StringBuilder s=new StringBuilder(str[getNum(0, 7)]+"200040");
		int j=getNum(1000, 100000);
		s.append(String.valueOf(j));
		return s;
	}

	/**
	 * 获得交易时间
	 * @return StringBuilder
	 */
	public static StringBuilder getTime() {
		StringBuilder s=new StringBuilder("2020/");
		s.append(String.valueOf(getNum(1, 12))+"/");
		s.append(String.valueOf(getNum(1, 30)));
		return s;
	}
}
