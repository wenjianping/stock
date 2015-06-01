package cn.wen.dao.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.ichano.common.cache.Cacheable;
import cn.ichano.common.cache.Cacheable.Type;
import cn.ichano.common.config.Env;
import cn.ichano.common.db.dao.IBaseDao;
import cn.ichano.common.util.FileUtil;

import cn.wen.dao.StockDao;
import cn.wen.entity.Stock;

@Component
public class StockDaoImpl implements StockDao {

	@Autowired
	IBaseDao baseDao;

	@Override
	@Cacheable(cacheClass = Stock.class, field = "#stock.code", type = Type.UPDATE)
	public boolean save(Stock stock) {
		String sql = Env.getConfig().getValue("cn.wen.entity.stock.save");
		baseDao.update(sql, null, stock);
		return true;
	}

	@Override
	@Cacheable(cacheClass = Stock.class, field = "#code", type = Type.QUERY)
	public Stock query(String code) {
		String sql = Env.getConfig().getValue("cn.wen.entity.stock.query");
		return baseDao.querySingle(sql, Stock.class, new Object[] { code });
		// return false;
	}

	@Override
	@Cacheable(cacheClass = Stock.class, field = "#code", type = Type.DELETE)
	public boolean delete(String code) {
		String sql = Env.getConfig().getValue("cn.wen.entity.stock.delete");
		baseDao.update(sql, null, new Object[] { code });
		return true;
	}

	@Override
	@Cacheable(cacheClass = Stock.class, field = "#stock.code", type = Type.UPDATE)
	public boolean update(Stock stock) {
		String sql = Env.getConfig().getValue("cn.wen.entity.stock.update");
		baseDao.update(sql, null, stock);
		return true;
	}

	@Override
	public List<String> queryAll() {
		return FileUtil.readLines(new File("config/codes.txt"), "utf-8");
		// return null;
	}

}
