package cn.wen.entity;

import java.util.Date;

import cn.ichano.common.util.JsonUtil;

/**
 * 股票基本信息
 * 
 * @author wenjp
 *
 */
public class Stock {

	/**
	 * 
	 * type(1股票2指数3基金) + 地市(sz,sh)+ 6位编码
	 */
	private String code;

	private String name;


	/**
	 * 上市时间
	 */
	private String onlieTime;
	
	/**
	 * 上市\停牌
	 */
	private int onlineType;


	/**
	 * 行业
	 */
	private String industry;


	/**
	 * 市盈率
	 */
	private String ratio;

	private String price;

	/**
	 * 市净率
	 */
	private String pb;

	/**
	 * 总市值
	 */
	private String marketValue;

	/**
	 * 总股本
	 */
	private String totalStock;
	
	/**
	 * 流通股本
	 */
	private String circulationStock;

	private Date updateTime;

	private String desc;

	private StockExtends stockExtends;

	public StockExtends getStockExtends() {
		return stockExtends;
	}

	public void setStockExtends(StockExtends stockExtends) {
		this.stockExtends = stockExtends;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getRatio() {
		return ratio;
	}

	public void setRatio(String ratio) {
		this.ratio = ratio;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(String marketValue) {
		this.marketValue = marketValue;
	}

	public String getTotalStock() {
		return totalStock;
	}

	public void setTotalStock(String totalStock) {
		this.totalStock = totalStock;
	}

	public String getCirculationStock() {
		return circulationStock;
	}

	public void setCirculationStock(String circulationStock) {
		this.circulationStock = circulationStock;
	}

	public String getPb() {
		return pb;
	}

	public void setPb(String pb) {
		this.pb = pb;
	}

	public String getOnlieTime() {
		return onlieTime;
	}

	public void setOnlieTime(String onlieTime) {
		this.onlieTime = onlieTime;
	}

	public int getOnlineType() {
		return onlineType;
	}

	public void setOnlineType(int onlineType) {
		this.onlineType = onlineType;
	}

	@Override
	public String toString() {
		return JsonUtil.toJsonPrettyString(this);
	}

}
