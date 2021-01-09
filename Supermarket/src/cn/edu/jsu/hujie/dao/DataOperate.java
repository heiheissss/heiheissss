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
 * ������Ĳ���
 * @author ����
 *
 */
public class DataOperate {

	private static String firstName = "��Ǯ��������֣��������������������������ʩ�ſײ��ϻ���κ�ս���л������ˮ��������˸��ɷ�����³Τ������ﻨ������Ԭ��ۺ��ʷ�Ʒ����Ѧ�׺����������ޱϺ�����������ʱ��Ƥ���뿵����Ԫ������ƽ�ƺ�������Ҧ��տ����ë����ױ���갼Ʒ��ɴ�̸��é���ܼ�������ף������������ϯ����ǿ��·¦Σ��ͯ�չ�÷ʢ�ֵ�����������Ĳ��﷮���������֧�¾̹�¬Ī�������Ѹɽ�Ӧ�������ڵ��������������ʯ�޼�ť�������ϻ���½��������춻���κ�ӷ����ഢ���������ɾ��θ����ڽ��͹�����ɽ�ȳ������ȫۭ�����������������ﱩ�����������������ղ����Ҷ��˾��۬�輻��ӡ�ް׻���̨�Ӷ����̼���׿�����ɳ����������ܲ�˫��ݷ����̷�����̼������Ƚ��۪Ӻȴ�ɣ���ţ��ͨ�����༽ۣ����ũ�±�ׯ�̲����ֳ�Ľ����ϰ�°���������������θ����߾Ӻⲽ�����������Ŀܹ�»�ڶ�Ź�����εԽ��¡ʦ�������˹��������������Ǽ��Ŀ�����ɳؿ������ᳲ�������󽭺�����Ȩ�ָ��滸����ٹ˾���Ϲ�ŷ���ĺ�������˶��������ʸ�ξ�ٹ����̨��ұ���������������̫����������������ԯ�������������Ľ����������˾ͽ˾������˾���붽�ӳ�����ľ����������������ṫ���ذμй��׸����������ַ���۳Ϳ�նθɰ��ﶫ�����ź��ӹ麣����΢����˧�ÿ�������������������������Ĳ��٦�����Ϲ�ī�������갮��١�����Ը��ټ�����";
	
	private static String girl = "���Ӣ���������Ⱦ���������֥��Ƽ�����ҷ���ʴ��������÷���������滷ѩ�ٰ���ϼ����ݺ�����𷲼Ѽ�������������Ҷ�������������ɺɯ������ٻ�������ӱ¶������������Ǻɵ���ü������ޱݼ���Է�ܰ�������԰��ӽ�������ع���ѱ�ˬ������ϣ����Ʈ�����������������������ܿ�ƺ������˿ɼ���Ӱ��֦˼�� ";
	
	private static String boy = "ΰ�����㿡��ǿ��ƽ�����Ļ�������������־��������ɽ�ʲ���������Ԫȫ��ʤѧ��ŷ���������ɱ�˳���ӽ��β��ɿ��ǹ���ﰲ����ï�����м�ͱ벩���Ⱦ�����׳��˼Ⱥ���İ�����ܹ����ƺ���������ԣ���ܽ���������ǫ�����֮�ֺ��ʲ����������������ά�������������󳿳�ʿ�Խ��������׵���ʱ̩ʢ��衾��ڲ�����ŷ纽��";

	
	
	/**
	 * �����ȡi��j�������
	 * @param i ����
	 * @param j ����
	 * @return int
	 */
	public static int getNum(int i, int j) {
		return (int) (Math.random() * (j - i + 1) + i);
	}

	/**
	 * ��ȡ��Ʒ���
	 * @return StringBuilder
	 */
	public static StringBuilder getId() {
		StringBuilder id = new StringBuilder(String.valueOf(getNum(0, 100000)));
		return id;
	}
	
	/**
	 * ��ȡ��Ʒ����
	 * @return String
	 */
	public static String getType() {
		String type[] = { "ʳ����", "�����", "��Ϸ��", "��װ��" };
		return type[getNum(0, 3)];
	}
	
	/**
	 * ��ȡ��Ʒ����
	 * @return String
	 */
	public static String getName() {
		String first, second, three;
		three = "";
		int index = getNum(0, firstName.length() - 1);
		first = firstName.substring(index, index + 1);
		int sex = getNum(0, 1);// ���ȡ�Ա�����1Ϊ������0ΪŮ��
		String str = boy;// ��������Ϊ�����ַ���
		int length = boy.length();// ��ȡ�����ַ����ĳ���
		if (sex == 0) {// ��������ȡΪ0�������ָ�ΪŮ��
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
	 * �����Ʒ����
	 * @return int
	 */
	public static int getNumber() {
		return getNum(1, 100);
	}

	/**
	 * �����Ʒ����
	 * @return int
	 */
	public static int getPrice() {
		return getNum(1, 100);
	}

	/**
	 * ��ý��׵���
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
	 * ��ý���ʱ��
	 * @return StringBuilder
	 */
	public static StringBuilder getTime() {
		StringBuilder s=new StringBuilder("2020/");
		s.append(String.valueOf(getNum(1, 12))+"/");
		s.append(String.valueOf(getNum(1, 30)));
		return s;
	}
}
