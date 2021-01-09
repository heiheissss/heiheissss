package cn.edu.jsu.hujie.vo;

//����ģʽ
public class Market {

	private String oddnumber;//���׵���
	private String id;//��Ʒ���
	private int buynumber;//��������
	private int price;//����
	private int money;//���
	private String time;//����ʱ��
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
		return "���׵���\t" + this.oddnumber + "��Ʒ���\t" + this.id + "��������\t" + this.buynumber + "����\t" + this.price
				+ "��Ʒ���\t" + this.money + "����ʱ��" + this.time;
	}

}
