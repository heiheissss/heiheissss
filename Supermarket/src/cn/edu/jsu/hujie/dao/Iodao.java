package cn.edu.jsu.hujie.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * ���ļ��������ӡ�ɾ�����޸ġ�����
 * @author ����
 *
 */
public class Iodao {
	/**
	 * 
	 * @param account �˺�
	 * @param password ����
	 * @param filename �ļ���
	 * @return boolean
	 */
	public static boolean loginJudgment(String account, String password, String filename) {
		File file = new File(filename);
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String str;
			String[] ch;
			try {
				while ((str = br.readLine()) != null) {
					ch = str.split("\t");
					if (account.equals(ch[0]) && password.equals(ch[1])) {
						return true;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * ע��Ҫ��
	 * @param account �˺�
	 * @param password ����
	 * @return boolean
	 */
	public static boolean registerJudge(String account, String password) {
		if (account.equals("")) {
			JOptionPane.showMessageDialog(null, "�˺Ų���Ϊ��");
			return false;
		} else if (account.length() != 11 || !account.matches("\\d+")) {
			JOptionPane.showMessageDialog(null, "�˺ų��ȱ�����11λ������Ϊ����");
			return false;
		} else if (accountJudge(account)) {
			JOptionPane.showMessageDialog(null, "���˻��Ѵ���");
			return false;
		} else if (password.length() == 0) {
			JOptionPane.showMessageDialog(null, "���벻��Ϊ��");
			return false;
		}

		return true;
	}

	/**
	 * ��ȡ�˺�����
	 * @param data �˺�����
	 * @param flag �ļ�׷��
	 */
	public static void dataStorage(String data,boolean flag) {
		File file = new File("D:/����Ա�˺�����.txt");
		try {
			FileWriter fw = new FileWriter(file, flag);
			fw.write(data + "\r\n");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �˺��ж��Ƿ����
	 * @param account �˺�
	 * @return boolean 
	 */
	public static boolean accountJudge(String account) {
		File file = new File("D:/����Ա�˺�����.txt");
		String str;
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			try {
				while ((str = br.readLine()) != null) {
					String[] b = str.split("\t");
					if (b[0].equals(account)) {
						return true;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * �޸�����
	 * @param account �˺�
	 * @param password ����
	 */
	public static void passwordChange(String account, String password) {
		File file = new File("D:/����Ա�˺�����.txt");
		FileReader fr;
		try {
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String str;
			String ch[] = new String[1024];
			try {
				int i = 0;
				while ((str = br.readLine()) != null) {
					if (str.contains(account)) {
						str = account + "\t" + password;
					}
					ch[i++] = str;
				}
				br.close();
				for (int j = 0; j < i; j++) {
					if(j==0)
					dataStorage(ch[j],false);
					else dataStorage(ch[j], true);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * ע���˺�
	 * @param account �˺�
	 */
		public static void accountCancel(String account) {
			File file = new File("D:/����Ա�˺�����.txt");
			FileReader fr;
			try {
				fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String str;
				String ch[] = new String[1024];
				try {
					int i = 0;
					while ((str = br.readLine()) != null) {
						if (str.contains(account)) {
							continue;
						}
						ch[i++] = str;
					}
					br.close();
					for (int j = 0; j < i; j++) {
						if(j==0)
						dataStorage(ch[j],false);
						else dataStorage(ch[j], true);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		}
}
