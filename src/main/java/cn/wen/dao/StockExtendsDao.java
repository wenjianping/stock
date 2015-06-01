package cn.wen.dao;

import cn.wen.entity.StockExtends;

public interface StockExtendsDao {

	public StockExtends query(String code, String day);

	public boolean update(StockExtends stockExtends);

	public boolean save(StockExtends stockExtends);

}
