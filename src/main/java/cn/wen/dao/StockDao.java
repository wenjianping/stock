package cn.wen.dao;

import java.util.List;

import cn.wen.entity.Stock;

public interface StockDao {

	public boolean save(Stock stock);
	
	public Stock query(String code);
	
	public boolean delete(String code);

	public boolean update(Stock stock);

	public List<String> queryAll();
}
