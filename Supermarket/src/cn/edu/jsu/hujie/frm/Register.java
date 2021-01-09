package cn.edu.jsu.hujie.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.hujie.dao.Iodao;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 账号注册的图形界面
 * @author 胡洁
 *
 */
public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	public Register() {
			
		
		setResizable(false);
		setTitle("\u6CE8\u518C\u754C\u9762");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Register.class.getResource("/sourse/e10.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u4F60\u7684\u8D26\u53F7");
		lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBounds(71, 64, 142, 34);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(242, 64, 112, 34);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u4F60\u7684\u5BC6\u7801");
		lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(71, 128, 142, 34);
		contentPane.add(lblNewLabel);

		passwordField = new JPasswordField();
		passwordField.setBounds(242, 128, 112, 34);
		contentPane.add(passwordField);
		
		//注册成功按钮
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Iodao.registerJudge(textField.getText(), new String(passwordField.getPassword()))) {
					Iodao.dataStorage(textField.getText() + "\t" + new String(passwordField.getPassword()),true);
					JOptionPane.showMessageDialog(null, "注册成功");
				}
			}
		});
		btnNewButton.setBounds(163, 198, 106, 34);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Register.class.getResource("/sourse/000ff6d55b607446.jpg")));
		lblNewLabel_2.setBounds(0, 0, 446, 272);
		contentPane.add(lblNewLabel_2);
	}

}
