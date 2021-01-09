package cn.edu.jsu.hujie.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import cn.edu.jsu.hujie.dbc.DatabaseConnectionSql;
import cn.edu.jsu.hujie.dao.DataOperate;
import cn.edu.jsu.hujie.dao.Dbcdao;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.AncestorEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 * 管理员的图像界面
 * @author 胡洁
 *
 */
public class Administration extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldid;
	private JTextField textFieldtype;
	private JTextField textFieldname;
	private JTextField textFieldnumber;
	private JTextField textFieldprice;
	private JTextField textFieldfind;
	private JTable table;
	private JTextField textFielddelete;
	private JTable table_1;
	private Vector<Vector> stuInfo = new Vector<>();
	private TableRowSorter sorter;
	private DefaultTableModel model;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	
	public Administration() {
		setTitle("\u7BA1\u7406\u5458");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Administration.class.getResource("/sourse/e10.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 579, 485);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("\u589E\u52A0", null, panel, null);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u7F16\u53F7");
		lblNewLabel.setBounds(43, 10, 105, 35);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u5546\u54C1\u7C7B\u578B");
		lblNewLabel_1.setBounds(43, 70, 105, 35);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u5546\u54C1\u540D\u79F0");
		lblNewLabel_2.setBounds(43, 132, 105, 35);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\u5546\u54C1\u6570\u91CF");
		lblNewLabel_3.setBounds(43, 195, 105, 35);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\u5546\u54C1\u4EF7\u683C");
		lblNewLabel_4.setBounds(43, 256, 105, 35);
		panel.add(lblNewLabel_4);

		textFieldid = new JTextField();
		textFieldid.setBounds(209, 17, 188, 35);
		panel.add(textFieldid);
		textFieldid.setColumns(10);

		textFieldtype = new JTextField();
		textFieldtype.setBounds(209, 77, 188, 35);
		panel.add(textFieldtype);
		textFieldtype.setColumns(10);

		textFieldname = new JTextField();
		textFieldname.setBounds(209, 139, 188, 35);
		panel.add(textFieldname);
		textFieldname.setColumns(10);

		textFieldnumber = new JTextField();
		textFieldnumber.setBounds(209, 202, 188, 35);
		panel.add(textFieldnumber);
		textFieldnumber.setColumns(10);

		textFieldprice = new JTextField();
		textFieldprice.setBounds(209, 263, 188, 35);
		panel.add(textFieldprice);
		textFieldprice.setColumns(10);

		// 增加商品
		JButton btnNewButton = new JButton("\u589E\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str1, str2, str3;
				int str4, str5;
				if (textFieldid.getText().length() == 0 || textFieldtype.getText().length() == 0
						|| textFieldname.getText().length() == 0 || textFieldnumber.getText().length() == 0
						|| textFieldprice.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "信息不能为空");
				} else {
					str1 = textFieldid.getText();
					str2 = textFieldtype.getText().toString();
					str3 = textFieldname.getText().toString();
					str4 = Integer.parseInt(textFieldnumber.getText());
					str5 = Integer.parseInt(textFieldprice.getText());

					if (Dbcdao.addData(str1, str2, str3, str4, str5)) {
						JOptionPane.showMessageDialog(null, "增加成功");
					} else {
						JOptionPane.showMessageDialog(null, "增加失败");
					}
				}

			}

		});
		btnNewButton.setBounds(144, 353, 122, 45);
		panel.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("\u67E5\u627E", null, panel_1, null);
		panel_1.setLayout(null);

		textFieldfind = new JTextField();
		textFieldfind.setBounds(206, 10, 173, 33);
		panel_1.add(textFieldfind);
		textFieldfind.setColumns(10);

		Vector<String> title = new Vector<String>();
		Collections.addAll(title, "商品编号", "商品类型", "商品名称", "商品数量", "商品价格");
		
		//查找按钮
		JButton btnfind = new JButton("\u67E5\u627E");
		btnfind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textFieldfind.getText();
				model = new DefaultTableModel(Dbcdao.obtainsql(str), title);
				table.setModel(model);
				sorter = new TableRowSorter<DefaultTableModel>(model);
				table.setRowSorter(sorter);
			}
		});
		btnfind.setBounds(389, 10, 107, 33);
		panel_1.add(btnfind);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 80, 546, 348);
		panel_1.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		model = new DefaultTableModel(Dbcdao.getTableRows(Dbcdao.getAllcommodity()), title) {
			public Class getColumnClass(int column) {// 获取列的类型
				Class returnValue;
				if ((column >= 0) && (column < getColumnCount())) {
					returnValue = getValueAt(0, column).getClass();
				} else {
					returnValue = Object.class;
				}
				return returnValue;
			}
		};
		table.setModel(model);
		sorter = new TableRowSorter<DefaultTableModel>(model);
		table.setRowSorter(sorter);

		JLabel lblNewLabel_6 = new JLabel(
				"\u8BF7\u8F93\u5165\u5546\u54C1\u7F16\u53F7\u6216\u7C7B\u578B\u6216\u540D\u79F0\u67E5\u627E");
		lblNewLabel_6.setBounds(0, 10, 196, 33);
		panel_1.add(lblNewLabel_6);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("\u5220\u9664", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("\u8BF7\u8F93\u5165\u8981\u5220\u9664\u7684\u5546\u54C1\u7F16\u53F7");
		lblNewLabel_5.setBounds(30, 45, 150, 30);
		panel_2.add(lblNewLabel_5);

		textFielddelete = new JTextField();
		textFielddelete.setBounds(238, 45, 138, 30);
		panel_2.add(textFielddelete);
		textFielddelete.setColumns(10);

		//删除按钮
		JButton btndelete = new JButton("\u5220\u9664");
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textFielddelete.getText();
				if (Dbcdao.deletesql(str)) {
					JOptionPane.showMessageDialog(null, "删除成功");
				} else {
					JOptionPane.showMessageDialog(null, "没有该商品编号");
				}
			}
		});
		btndelete.setBounds(164, 226, 129, 30);
		panel_2.add(btndelete);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("\u4FEE\u6539", null, panel_3, null);
		panel_3.setLayout(null);

		// 修改按钮
		JButton btnNewButton_3 = new JButton("\u4FEE\u6539");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table_1.getSelectedRow() != -1) {
					textField.setText(model.getValueAt(table_1.getSelectedRow(), 0).toString());
					textField_1.setText(model.getValueAt(table_1.getSelectedRow(), 1).toString());
					textField_2.setText(model.getValueAt(table_1.getSelectedRow(), 2).toString());
					textField_3.setText(model.getValueAt(table_1.getSelectedRow(), 3).toString());
					textField_4.setText(model.getValueAt(table_1.getSelectedRow(), 4).toString());
				}

			}
		});
		btnNewButton_3.setBounds(220, 10, 120, 33);
		panel_3.add(btnNewButton_3);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 92, 535, 346);
		panel_3.add(scrollPane_1);

		// 设置商品编号不可编辑
		table_1 = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				if (column == 0) {
					return false;
				}
				return true;
			}
		};

		JLabel lblNewLabel_7 = new JLabel("\u7F16\u53F7");
		lblNewLabel_7.setBounds(10, 59, 29, 21);
		panel_3.add(lblNewLabel_7);

		textField = new JTextField();
		textField.setForeground(Color.BLUE);
		textField.setBackground(Color.WHITE);
		textField.setEnabled(false);
		textField.setBounds(36, 59, 66, 21);
		panel_3.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("\u7C7B\u578B");
		lblNewLabel_8.setBounds(101, 59, 29, 21);
		panel_3.add(lblNewLabel_8);

		textField_1 = new JTextField();
		textField_1.setBounds(132, 59, 66, 21);
		panel_3.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("\u540D\u79F0");
		lblNewLabel_9.setBounds(208, 59, 29, 21);
		panel_3.add(lblNewLabel_9);

		textField_2 = new JTextField();
		textField_2.setBounds(241, 59, 66, 21);
		panel_3.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("\u6570\u91CF");
		lblNewLabel_10.setBounds(317, 59, 29, 21);
		panel_3.add(lblNewLabel_10);

		textField_3 = new JTextField();
		textField_3.setBounds(348, 59, 66, 21);
		panel_3.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setBounds(569, 67, 58, 15);
		panel_3.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("\u5355\u4EF7");
		lblNewLabel_12.setBounds(424, 59, 29, 21);
		panel_3.add(lblNewLabel_12);

		textField_4 = new JTextField();
		textField_4.setBounds(457, 59, 66, 21);
		panel_3.add(textField_4);
		textField_4.setColumns(10);

		scrollPane_1.setViewportView(table_1);
		table_1.setModel(model);
		table_1.setRowSorter(sorter);
		
		//修改按钮
		JButton btnNewButton_1 = new JButton("\u786E\u5B9A");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id,name,type;
				int price,number;
				id=textField.getText();
				type=textField_1.getText();
				name=textField_2.getText();
				number=Integer.parseInt(textField_3.getText());
				price=Integer.parseInt(textField_4.getText());
				Dbcdao.updatesql(id, type, name, number, price);
				JOptionPane.showMessageDialog(null, "修改成功");
				model=new DefaultTableModel(Dbcdao.getTableRows(Dbcdao.getAllcommodity()), title);
				table_1.setModel(model);
			}
		});
		btnNewButton_1.setBounds(356, 10, 109, 33);
		panel_3.add(btnNewButton_1);
	}
}
