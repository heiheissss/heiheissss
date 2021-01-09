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

import cn.edu.jsu.hujie.dbc.DatabaseConnectionSql;
import cn.edu.jsu.hujie.vo.Commodity;

/**
 * 数据库操作
 * @author 胡洁
 *
 */
public class Dbcdao {

	/**
	 * 返回sql语句查询结果查询结果
	 * @return ResultSet
	 */
	public static ResultSet getResult() {
		DatabaseConnectionSql d = new DatabaseConnectionSql();
		Connection c = (Connection) d.getConnection();
		String sql = "SELECT * FROM commodity";
		PreparedStatement p;
		ResultSet r = null;
		try {
			p = c.prepareStatement(sql);
			r = p.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
	/**
	 * 增加商品的信息
	 * @param id 商品编号
	 * @param type 商品类型
	 * @param name 商品名称
	 * @param number 商品数量
	 * @param price 商品价格
	 * @return boolean 
	 */

	public static boolean addData(String id, String type, String name, int number, int price) {
		
		DatabaseConnectionSql data = new DatabaseConnectionSql();
		Connection con = (Connection) data.getConnection();
		String sql0 = "select id from commodity";
		try {
			PreparedStatement p = con.prepareStatement(sql0);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				if (id.equals(rs.getString(1))) {
					return false;
				}
			}
			p.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String sql = "insert into commodity(id,type,name,number,price) values('" + id + "','" + type + "','" + name
				+ "','" + number + "','" + price + "')";
		try {
			Statement s = con.createStatement();
			s.executeUpdate(sql);
			s.addBatch(sql);
			s.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return true;
	}

	/**
	 * 把商品信息加入到数据库
	 * @throws SQLException
	 */

	public static void addsql() throws SQLException {
		DatabaseConnectionSql d = new DatabaseConnectionSql();
		Connection c = (Connection) d.getConnection();
		String sql = "insert into commodity(id,type,name,number,price) values(?,?,?,?,?)";
		String sql0 = "select id from commodity";
		PreparedStatement s = c.prepareStatement(sql);
		PreparedStatement p = c.prepareStatement(sql0);
		ArrayList<String> alist = new ArrayList<>();
		ResultSet r = p.executeQuery();
		while (r.next()) {
			alist.add(r.getString(1));
		}
		p.close();
		for (int i = 0; i < 10000;) {
			String id = DataOperate.getId().toString();
			if (!alist.contains(id)) {
				alist.add(id);
				s.setString(1, id);
				s.setString(2, DataOperate.getType());
				s.setString(3, DataOperate.getName());
				s.setInt(4, DataOperate.getNumber());
				s.setInt(5, DataOperate.getPrice());
				s.addBatch();
				i++;
			}
		}
		s.executeBatch();
		s.close();
	}
	/**
	 * 删除数据库信息
	 * @param str 商品编号（修改条件）
	 * @return boolean
	 */
	public static boolean deletesql(String str) {
		ResultSet rs=getResult();
		int flag=0;
		try {
			while(rs.next()) {
				if(rs.getString(1).equals(str)) {
					flag=1;
					break;
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		if(flag==0) {
			return false;
		}
		DatabaseConnectionSql d=new DatabaseConnectionSql();
		Connection con=d.getConnection();
		String sql="delete from commodity where id='"+str+"'";
		try {
			Statement s=con.createStatement();
			s.executeUpdate(sql);
			s.addBatch(sql);
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * 修改数据库的信息
	 * @param id 商品编号
	 * @param type 商品类型
	 * @param name 商品名称
	 * @param number 商品数量
	 * @param price 商品价格
	 */
	public static void updatesql(String id,String type,String name,int number,int price) {
		DatabaseConnectionSql d=new DatabaseConnectionSql();
		Connection con=d.getConnection();
		String sql="update commodity set type='"+type+"',name='"+name+"',number='"+number+"',price='"+price+"' where id='"+id+"'";
		try {
			Statement s=con.createStatement();
			s.executeUpdate(sql);
			s.addBatch(sql);
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 把数据库信息放入到list集合
	 * @return List
	 */
	public static List<Commodity> getAllcommodity() {
		List<Commodity> list=new ArrayList<>();
		try {
			ResultSet rs=getResult();
			while(rs.next()) {
				Commodity c=new Commodity(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	/**
	 * 返回list集合的数据
	 * @param list Cmmodity集合
	 * @return Vector
	 */
	public static Vector<Vector> getTableRows(List<Commodity> list){
		Vector<Vector> rows=new Vector<Vector>();
		for(int i=0;i<list.size();i++) {
			Vector row=new Vector();
			Commodity c=list.get(i);
			Collections.addAll(row,c.getId(),c.getType(),c.getName(),c.getNumber(),c.getPrice());
			rows.add(row);
		}		
		return rows;
	}
	

	/**
	 * 随机获取数据库的信息
	 * @return Vector
	 */
		public static Vector<Vector> obtainsql() {
			Vector<Vector> rows = new Vector<>();
			DatabaseConnectionSql d = new DatabaseConnectionSql();
			Connection c = (Connection) d.getConnection();
			String sql = "SELECT TOP 5 * FROM commodity ORDER BY NEWID()";
			try {
				PreparedStatement p = c.prepareStatement(sql);
				ResultSet r = p.executeQuery();
				while (r.next()) {
					Vector row = new Vector<>();
					Collections.addAll(row, r.getString(1), r.getString(2), r.getString(3), r.getInt(4), r.getInt(5));
					rows.add(row);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rows;
		}
	
	
		/**
		 * 获取数据库的信息(方法重载)
		 * 根据参数查找需要的数据
		 * @param str 查找条件
		 * @return Vector
		 */
		public static Vector<Vector> obtainsql(String str) {
			Vector<Vector> rows = new Vector<>();
			try {
				ResultSet r = getResult();
				if (str.length() != 0) {
					while (r.next()) {
						if (r.getString(1).contains(str) || r.getString(2).contains(str) || r.getString(3).contains(str)) {
							Vector row = new Vector<>();
							Collections.addAll(row, r.getString(1), r.getString(2), r.getString(3), r.getInt(4),
									r.getInt(5));
							rows.add(row);
						}
					}
				} else {
					while (r.next()) {
						Vector row = new Vector<>();
						Collections.addAll(row, r.getString(1), r.getString(2), r.getString(3), r.getInt(4), r.getInt(5));
						rows.add(row);
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rows;
		}
		
		/**
		 * 把销售信息加入到数据库
		 * @throws SQLException
		 */
		public static void addsqlMarket() throws SQLException {
			DatabaseConnectionSql d = new DatabaseConnectionSql();
			Connection c = (Connection) d.getConnection();
			String sql = "insert into market(oddnumber,id,buynumber,price,money,time) values(?,?,?,?,?,?)";
			String sql0 = "select oddnumber from market";
			PreparedStatement s = c.prepareStatement(sql);
			PreparedStatement p = c.prepareStatement(sql0);
			ArrayList<String> alist = new ArrayList<>();
			ResultSet r = p.executeQuery();
			while (r.next()) {
				alist.add(r.getString(1));
			}
			p.close();
			for (int i = 0; i < 10000;) {
				String oddnumber = DataOperate.getOddnumber().toString();
				if (!alist.contains(oddnumber)) {
					alist.add(oddnumber);
					s.setString(1, oddnumber);
					s.setString(2, DataOperate.getId().toString());
					int x,y;
					x=DataOperate.getNumber();
					y=DataOperate.getPrice();
					s.setInt(3,x );
					s.setInt(4, y);
					s.setInt(5, x*y);
					s.setString(6, DataOperate.getTime().toString());
					s.addBatch();
					i++;
				}
			}
			s.executeBatch();
			s.close();
		}
}
