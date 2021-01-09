package cn.edu.jsu.hujie.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.hujie.dao.Iodao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 * 修改密码的图形界面
 * @author 胡洁
 *
 */
public class Passwordchange extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	
	public Passwordchange() {
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Passwordchange.class.getResource("/sourse/h13.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u8D26\u53F7");
		lblNewLabel.setBounds(55, 27, 132, 33);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(197, 27, 110, 33);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u4F60\u7684\u65B0\u5BC6\u7801");
		lblNewLabel_1.setBounds(55, 89, 132, 33);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u8BF7\u518D\u6B21\u8F93\u5165\u4F60\u7684\u5BC6\u7801");
		lblNewLabel_2.setBounds(55, 153, 132, 33);
		contentPane.add(lblNewLabel_2);

		// 修改密码按钮
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String account = textField.getText();
				String password1 = new String(passwordField.getPassword());
				String password2 = new String(passwordField_1.getPassword());
				if (account.equals("") || password1.equals("") || password2.equals("")) {
					JOptionPane.showMessageDialog(null, "所有信息不能为空");
				} else {
					if (password1.equals(password2)) {
						if(Iodao.accountJudge(account)) {
							Iodao.passwordChange(account, password1);
							JOptionPane.showMessageDialog(null, "修改密码成功");
						} else {
							JOptionPane.showMessageDialog(null, "没有该账号");
						}
					} else {
						JOptionPane.showMessageDialog(null, "2次输入的密码不一样");
					}
				}

			}
		});
		btnNewButton.setBounds(150, 215, 97, 33);
		contentPane.add(btnNewButton);

		passwordField = new JPasswordField();
		passwordField.setBounds(197, 95, 110, 33);
		contentPane.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(197, 153, 110, 33);
		contentPane.add(passwordField_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Passwordchange.class.getResource("/sourse/apic28909_s.jpg")));
		lblNewLabel_3.setBounds(0, 0, 436, 263);
		contentPane.add(lblNewLabel_3);
	}
}
