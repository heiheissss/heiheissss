package cn.edu.jsu.hujie.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * 对文件进行增加、删除、修改、查找
 * @author 胡洁
 *
 */
public class Iodao {
	/**
	 * 
	 * @param account 账号
	 * @param password 密码
	 * @param filename 文件名
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
	 * 注册要求
	 * @param account 账号
	 * @param password 密码
	 * @return boolean
	 */
	public static boolean registerJudge(String account, String password) {
		if (account.equals("")) {
			JOptionPane.showMessageDialog(null, "账号不能为空");
			return false;
		} else if (account.length() != 11 || !account.matches("\\d+")) {
			JOptionPane.showMessageDialog(null, "账号长度必须是11位，而且为数字");
			return false;
		} else if (accountJudge(account)) {
			JOptionPane.showMessageDialog(null, "该账户已存在");
			return false;
		} else if (password.length() == 0) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return false;
		}

		return true;
	}

	/**
	 * 存取账号密码
	 * @param data 账号密码
	 * @param flag 文件追加
	 */
	public static void dataStorage(String data,boolean flag) {
		File file = new File("D:/收银员账号密码.txt");
		try {
			FileWriter fw = new FileWriter(file, flag);
			fw.write(data + "\r\n");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 账号判断是否存在
	 * @param account 账号
	 * @return boolean 
	 */
	public static boolean accountJudge(String account) {
		File file = new File("D:/收银员账号密码.txt");
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
	 * 修改密码
	 * @param account 账号
	 * @param password 密码
	 */
	public static void passwordChange(String account, String password) {
		File file = new File("D:/收银员账号密码.txt");
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
	 * 注销账号
	 * @param account 账号
	 */
		public static void accountCancel(String account) {
			File file = new File("D:/收银员账号密码.txt");
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
