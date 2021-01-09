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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

/**
 * �˺�ע����ͼ�����
 * @author ����
 *
 */
public class Accountcancel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	

	/**
	 * Create the frame.
	 */
	public Accountcancel() {
		setTitle("\u8D26\u53F7\u6CE8\u9500");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Accountcancel.class.getResource("/sourse/12.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u4F60\u9700\u8981\u6CE8\u9500\u7684\u8D26\u53F7");
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(10, 79, 217, 28);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(264, 79, 141, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		/**
		 * ע���˺Ű�ť����¼�
		 */
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "ȷ��Ҫע�����˺�??","",JOptionPane.YES_NO_OPTION)==0) {
					String account=textField.getText();
					if(Iodao.accountJudge(account)) {
						setVisible(false);
						Iodao.accountCancel(account);
					}
					else {
						JOptionPane.showMessageDialog(null, "���˺Ų�����");
					}
				}
			}
		});
		btnNewButton.setBounds(148, 147, 105, 42);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Accountcancel.class.getResource("/sourse/apic25408_s.jpg")));
		lblNewLabel_1.setBounds(0, 10, 426, 243);
		contentPane.add(lblNewLabel_1);
	}
}
