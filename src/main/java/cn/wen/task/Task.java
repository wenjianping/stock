package cn.wen.task;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import cn.wen.dao.StockDao;
import cn.wen.dao.StockExtendsDao;
import cn.wen.entity.Stock;
import cn.wen.service.StockService;

@Service
public class Task {

	@Autowired
	StockDao stockDao;

	@Autowired
	StockExtendsDao stockExtendsDao;

	@Autowired
	StockService stockService;

	@Scheduled(cron = "1 * 16  * * ? ")
	public void queryStock() {
		List<String> stockList = new ArrayList<String>();

		for (String code : stockList) {
			Stock stock = stockService.parse(code);
			stockDao.save(stock);
			stockExtendsDao.save(stock.getStockExtends());
		}
	}

}
