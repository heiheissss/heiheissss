package cn.edu.jsu.hujie.junit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cn.edu.jsu.hujie.dao.Dbcdao;
import cn.edu.jsu.hujie.vo.Commodity;


public class Text2 {

	public static void main(String[] args) {
		List<Commodity> list=Dbcdao.getAllcommodity();
		Iterator it=list.iterator();
		while(it.hasNext()) {
			Commodity c=(Commodity) it.next();
			System.out.println(c);
		}
	}

}
