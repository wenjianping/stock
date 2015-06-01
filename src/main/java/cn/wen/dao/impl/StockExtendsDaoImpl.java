package cn.wen.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.ichano.common.cache.Cacheable;
import cn.ichano.common.cache.Cacheable.Type;
import cn.ichano.common.config.Env;
import cn.ichano.common.db.dao.IBaseDao;

import cn.wen.dao.StockExtendsDao;
import cn.wen.entity.StockExtends;

@Component
public class StockExtendsDaoImpl implements StockExtendsDao {

	@Autowired
	IBaseDao baseDao;

	@Override
	@Cacheable(cacheClass = StockExtends.class, field = "#code,day", type = Type.QUERY)
	public StockExtends query(String code,String day) {
		String sql = Env.getConfig()
.getValue(
				"cn.wen.entity.stockextends.query");
		return baseDao.querySingle(sql, StockExtends.class, new Object[] {
				code, day });

	}

	@Override
	@Cacheable(cacheClass = StockExtends.class, field = "#stockExtends.code,stockExtends.day", type = Type.UPDATE)
	public boolean update(StockExtends stockExtends) {
		String sql = Env.getConfig().getValue(
				"cn.wen.entity.stockextends.update");
		baseDao.update(sql, null, stockExtends);
		return true;
	}

	@Cacheable(cacheClass = StockExtends.class, field = "#stockExtends.code,stockExtends.day", type = Type.UPDATE)
	@Override
	public boolean save(StockExtends stockExtends) {
		String sql = Env.getConfig()
				.getValue("cn.wen.entity.stockextends.save");
		baseDao.update(sql, null, stockExtends);
		return true;
	}

}
