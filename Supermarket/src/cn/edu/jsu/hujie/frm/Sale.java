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
import cn.edu.jsu.hujie.dao.Exceldao;

import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.RowFilter;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * 销售商品的图形界面
 * @author 胡洁
 *
 */
public class Sale extends JFrame {
	private Vector<Vector> stuInfo = new Vector<>();
	private TableRowSorter sorter;
	private DefaultTableModel model;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	
	public Sale() {

		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sale.class.getResource("/sourse/e10.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 384);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.GREEN);
		menuBar.setBackground(Color.GREEN);
		menuBar.setBounds(0, 0, 523, 23);
		contentPane.add(menuBar);

		JMenu mnNewMenu = new JMenu("\u9500\u552E\u5546\u54C1");
		mnNewMenu.setMnemonic('a');
		menuBar.add(mnNewMenu);
		Vector<String> title = new Vector<String>();
		Collections.addAll(title, "商品编号", "商品类型", "商品名称", "商品数量", "商品价格");
		table = new JTable();
		stuInfo = new Dbcdao().obtainsql();
		model = new DefaultTableModel(stuInfo, title) {
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
		// 菜单（显示商品信息）
		JMenuItem mntmNewMenuItem = new JMenuItem("\u663E\u793A\u5546\u54C1\u4FE1\u606F");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stuInfo = new Dbcdao().obtainsql();
				model = new DefaultTableModel(stuInfo, title) {
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
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("\u5BC6\u7801\u7BA1\u7406");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Passwordchange pass=new Passwordchange();
				pass.setVisible(true);
				pass.setLocationRelativeTo(null);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		//注销账号
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u6CE8\u9500\u8D26\u53F7");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Accountcancel a=new Accountcancel();
				a.setVisible(true);
				a.setLocationRelativeTo(null);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("\u5176\u4ED6");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		mnNewMenu_2.add(mntmNewMenuItem_3);

		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(-11, 22, 534, 49);
		contentPane.add(toolBar);

		//随机增加商品信息
		JButton btnNewButton = new JButton("\u589E\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector<Vector> v = Dbcdao.obtainsql();
				for (int i = 0; i < v.size(); i++) {
					stuInfo.add(v.get(i));
				}

				model = new DefaultTableModel(stuInfo, title) {
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
			}
		});
		btnNewButton.setIcon(new ImageIcon(Sale.class.getResource("/sourse/f10.png")));
		toolBar.add(btnNewButton);

		//查找按钮
		JButton btnNewButton_1 = new JButton("\u641C\u7D22");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField.getText();
				sorter.setRowFilter(RowFilter.regexFilter(str));
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(Sale.class.getResource("/sourse/f9.png")));
		toolBar.add(btnNewButton_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 110, 523, 190);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(table);

		//支付按钮
		JButton btnNewButton_4 = new JButton("\u652F\u4ED8");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int j = 0;
				File file = new File("D:/销售记录.txt");
				try {
					FileWriter fw = new FileWriter(file, true);
					for (int i = 0; i < model.getRowCount(); i++) {
						String str = model.getValueAt(i, 0).toString();
						String str1 = model.getValueAt(i, 1).toString();
						String str2 = model.getValueAt(i, 2).toString();
						String str3 = model.getValueAt(i, 3).toString();
						String str4 = model.getValueAt(i, 4).toString();
						j += Integer.parseInt(str3) * Integer.parseInt(str4);
						fw.write(str+"\t"+str1+"\t"+str2+"\t"+str3+"\t"+str4+"\r\n");
					}
					fw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "您需要支付"+j+"元");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				//把销售记录写到Excel表格
				try {
					Exceldao.excelAdd();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBounds(211, 310, 108, 27);
		contentPane.add(btnNewButton_4);

		textField = new JTextField();
		textField.setBounds(156, 79, 163, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u8F93\u5165\u76F8\u5173\u5546\u54C1\u4FE1\u606F");
		lblNewLabel.setBounds(22, 81, 108, 19);
		contentPane.add(lblNewLabel);
	}
}
