package cn.edu.jsu.hujie.junit;

import cn.edu.jsu.hujie.frm.Supermarketcashier;

/**
 * 测试类
 * @author 胡洁
 *
 */
public class Text1 {

	public static void main(String[] args) {
		Supermarketcashier frame = new Supermarketcashier();
		frame.setLocationRelativeTo(null);// 窗体居中
		// frame.setExtendedState(JFrame.MAXIMIZED_BOTH);//窗体最大化
		frame.setVisible(true);

	}

}
