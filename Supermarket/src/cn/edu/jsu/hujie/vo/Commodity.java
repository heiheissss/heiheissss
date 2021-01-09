package cn.edu.jsu.hujie.vo;

import java.io.Serializable;

public class Commodity implements Serializable{

	private String id;
	private String type;
	private String name;
	private int number;
	private int price;
	public Commodity() {}
	public Commodity(String id, String type, String name, int number, int price) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.number = number;
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "商品编号:"+id+"\t商品类型:"+type+"\t商品名称："+name+"\t商品数量："+number+"\t商品单价："+price;
	}
	
}
