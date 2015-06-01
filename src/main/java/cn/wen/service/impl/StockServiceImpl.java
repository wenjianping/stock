package cn.wen.service.impl;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.log4j.Logger;

import cn.ichano.common.util.HttpUtil;

import cn.wen.entity.Stock;
import cn.wen.service.StockService;

public class StockServiceImpl implements StockService {
	private static Logger LOGGER = Logger.getLogger(HttpUtil.class);

	Parse parse = new CmParse();

	private static interface Parse {
		public void parse(byte[] data);
	}

	private static class CmParse implements Parse {

		@Override
		public void parse(byte[] data) {

		}
	}

	private String getUrl(String code) {
		// TODO Auto-generated method stub
		return "http://hq.sinajs.cn/list=sh" + code;
	}

	@Override
	public Stock parse(String code) {

		String callUrl = getUrl(code);
		HttpGet httpGet = new HttpGet(callUrl);
		httpGet.addHeader("Content-Type", "application/text;charset=GBK");
		byte[] result = null;
		try {
			result = HttpUtil.executeForByte(httpGet);
		} catch (ClientProtocolException e) {
			LOGGER.error("");
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		String htmlData = new String(result, Charset.forName("GBK"));

		String data = htmlData.substring(htmlData.indexOf("\"") + 1,
				htmlData.length() - 3);

		System.out.println(data);
		// sample http://c-zhiwu.iteye.com/blog/718342
		// http://free0007.iteye.com/blog/1131163
		// Parser parser = Parser.createParser(htmlData, "utf-8");

		Stock stock = parseData(data);
		return stock;
	}

	private Stock parseData(String data) {
		String[] datas = data.split(",");
		Stock stock = new Stock();
		stock.setName(datas[0]);
		stock.setPrice(datas[2]);

		return null;
	}

	public static void main(String[] args) {

		StockServiceImpl impl = new StockServiceImpl();
		impl.parse("600377");

	}

}
