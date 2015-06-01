package cn.wen.entity;


public class StockExtends {

	private String day;
	
	private String code;
	
	private String name;



	private String price;
	
	/**
	 * 净值
	 */
	private String netWorth;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getNetWorth() {
		return netWorth;
	}

	public void setNetWorth(String netWorth) {
		this.netWorth = netWorth;
	}


}
