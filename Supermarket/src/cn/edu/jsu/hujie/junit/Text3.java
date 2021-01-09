package cn.edu.jsu.hujie.junit;

import java.io.IOException;
import java.sql.SQLException;

import cn.edu.jsu.hujie.dao.Dbcdao;
import cn.edu.jsu.hujie.dao.Exceldao;

public class Text3 {

	//导出Excel表格
	public static void main(String[] args) throws IOException, SQLException {
		//Exceldao.excelAdd();
		Dbcdao.addsqlMarket();
	}

}
