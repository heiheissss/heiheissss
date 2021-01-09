package cn.edu.jsu.hujie.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.hujie.dao.DataOperate;
import cn.edu.jsu.hujie.dao.Dbcdao;
import cn.edu.jsu.hujie.dao.Iodao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.JobAttributes;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.SubmissionPublisher;
import java.awt.event.ActionEvent;

/**
 * ��¼��ͼ�ν���
 * @author ����
 *
 */
public class Supermarketcashier extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private Register register;

	/**
	 * Create the frame.
	 */
	public Supermarketcashier() {
		setResizable(false);
		setBackground(Color.CYAN);
		setForeground(Color.CYAN);
		setTitle("\u8D85\u5E02\u6536\u94F6\u7CFB\u7EDF");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Supermarketcashier.class.getResource("/sourse/e10.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 429);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Supermarketcashier.class.getResource("/sourse/apic25494_s.jpg")));
		lblNewLabel.setBounds(0, 0, 578, 206);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237");
		lblNewLabel_1.setBounds(147, 216, 63, 25);
		contentPane.add(lblNewLabel_1);

		JComboBox comboBox = new JComboBox(new String[] { "����Ա", "����Ա" });
		comboBox.setToolTipText("");
		comboBox.setBounds(211, 216, 123, 33);
		contentPane.add(comboBox);

		JLabel lblNewLabel_2 = new JLabel("\u8D26\u6237");
		lblNewLabel_2.setBounds(147, 251, 63, 33);
		contentPane.add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBounds(211, 253, 123, 33);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("\u5BC6\u7801");
		lblNewLabel_3.setBounds(147, 286, 63, 33);
		contentPane.add(lblNewLabel_3);

		passwordField = new JPasswordField();
		passwordField.setBounds(211, 288, 123, 33);
		contentPane.add(passwordField);
		// ��¼��ť�¼�
		JButton btnpassword = new JButton("\u767B\u5F55");
		btnpassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().toString().contains("����Ա")) {
					if (Iodao.loginJudgment(textField.getText(), new String(passwordField.getPassword()),
							"D:/����Ա�˺�����.txt")) {
						JOptionPane.showMessageDialog(null, "��¼�ɹ�");
						setVisible(false);
						Sale frame1 = new Sale();
						frame1.setVisible(true);
						frame1.setLocationRelativeTo(null);
//�����ݿ������Ʒ
//						try {
//							Dbcdao.addsql();
//						} catch (SQLException e1) {
//							e1.printStackTrace();
//						}
					} else {
						JOptionPane.showMessageDialog(null, "�˺Ż��������");
					}
				} else {
					if (Iodao.loginJudgment(textField.getText(), new String(passwordField.getPassword()),
							"D:/����Ա�˻�����.txt")) {
						JOptionPane.showMessageDialog(null, "��¼�ɹ�");
						setVisible(false);
						// �����ݿ������Ʒ
//						try {
//							Dbcdao.addsql();
//						} catch (SQLException e1) {
//							e1.printStackTrace();
//						}
						Administration frame2 = new Administration();
						frame2.setVisible(true);
						frame2.setLocationRelativeTo(null);// �������
					} else {
						JOptionPane.showMessageDialog(null, "�˺Ż��������");
					}
				}
			}
		});
		btnpassword.setForeground(Color.BLUE);
		btnpassword.setBackground(Color.WHITE);
		btnpassword.setBounds(297, 342, 87, 40);
		contentPane.add(btnpassword);
		// ע�ᰴť�¼�
		JButton btnaccount = new JButton("\u6CE8\u518C");
		btnaccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().toString().contains("����Ա")) {
					// ʹ���߳̿�������һ���߳�
					new Thread(new Runnable() {
						@Override
						public void run() {
							register = new Register();
							register.setVisible(true);
							register.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							register.setLocationRelativeTo(null);
							setVisible(false);
							// register.setExtendedState(JFrame.MAXIMIZED_BOTH);���
							register.addWindowListener(new WindowAdapter() {
								@Override
								public void windowClosing(WindowEvent e) {
									setVisible(true);
								}
							});
						}

					}).start();

				} else {
					JOptionPane.showMessageDialog(null, "����Ա����ע��");
				}
			}

		});
		btnaccount.setForeground(Color.BLUE);
		btnaccount.setBackground(Color.WHITE);
		btnaccount.setBounds(147, 342, 87, 40);
		contentPane.add(btnaccount);

	}

}