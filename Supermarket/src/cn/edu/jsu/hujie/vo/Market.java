package cn.edu.jsu.hujie.vo;

//单例模式
public class Market {

	private String oddnumber;//交易单号
	private String id;//商品编号
	private int buynumber;//购买数量
	private int price;//单价
	private int money;//金额
	private String time;//销售时间
	private static Market market;

	private Market() {
	}

	private Market(String oddnumber, String id, int buynymber, int price, int money, String time) {
		this.oddnumber = oddnumber;
		this.id = id;
		this.buynumber = buynymber;
		this.price = price;
		this.money = money;
		this.time = time;
	}

	public static Market getMarket() {
		if (market == null)
			market = new Market();
		return market;
	}

	public static Market getMarket(String oddnumber, String id, int buynymber, int price, int money, String time) {
		if (market == null)
			market = new Market(oddnumber, id, buynymber, price, money, time);
		return market;
	}

	public String getOddnumber() {
		return oddnumber;
	}

	public void setOddnumber(String oddnumber) {
		this.oddnumber = oddnumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getBuynumber() {
		return buynumber;
	}

	public void setBuynumber(int buynumber) {
		this.buynumber = buynumber;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public static void setMarket(Market market) {
		Market.market = market;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "交易单号\t" + this.oddnumber + "商品编号\t" + this.id + "购买数量\t" + this.buynumber + "单价\t" + this.price
				+ "商品金额\t" + this.money + "交易时间" + this.time;
	}

}
