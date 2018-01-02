package com.tianyi.biz.manager.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.common.http.HttpException;
import com.common.util.ChinarequestUtils;
import com.common.util.ParamMap;
import com.tianyi.TianyiException;
import com.tianyi.biz.manager.TianyiBase;
import com.tianyi.biz.manager.VerificationCodeMng;

@Transactional
@Service
public class VerificationCodeMngImpl extends TianyiBase implements VerificationCodeMng {
	
	private Logger log=LoggerFactory.getLogger(VerificationCodeMngImpl.class);

	@Override
	public String getRandcode(String appId, String appSecret) throws TianyiException {
		String chinaURL = ChinarequestUtils.proxyRequest(ChinarequestUtils.CHANNEL_TIANYI_SEND_MSG_CONFIG_ID,
				"http://api.189.cn/v2/dm/randcode/token");
		long start=System.currentTimeMillis();
		Map<String, Object> response = super.httpRequest(appId, appSecret, chinaURL, new HashMap<String, String>());
		log.info("china proxy URL:{} time:{}",chinaURL, System.currentTimeMillis() - start);
		return (String) response.get("token");
	}

	@Override
	public void send(String appId, String appSecret, String phone) throws TianyiException {
		String chinaURL = ChinarequestUtils.proxyRequest(ChinarequestUtils.CHANNEL_TIANYI_SEND_MSG_CONFIG_ID,
				"http://api.189.cn/v2/dm/randcode/send");
		long start=System.currentTimeMillis();
		super.httpRequest(appId, appSecret, chinaURL,
				new ParamMap<String, String>().add("phone", phone).add("url", "http://183.129.161.187/tianyi.html")
						.add("exp_time", "30").add("token", getRandcode(appId, appSecret)).getPraamMap());
		log.info("china proxy URL:{} time:{}",chinaURL, System.currentTimeMillis() - start);
	}

	public static void main(String[] args) throws HttpException, TianyiException {
		try {
			VerificationCodeMng tianyi = new VerificationCodeMngImpl();
			tianyi.send("372066830000038943", "5ccc7c362da30da027ac692ba2219e55", "15990146310", "991778", 30);
		} catch (TianyiException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void send(String appId, String appSecret, String phone, String randCode, Integer expTime)
			throws TianyiException {
		String chinaURL = ChinarequestUtils.proxyRequest(ChinarequestUtils.CHANNEL_TIANYI_SEND_MSG_CONFIG_ID,
				"http://api.189.cn/v2/dm/randcode/sendSms");
		long start = System.currentTimeMillis();
		super.httpRequest(appId, appSecret, chinaURL,
				new ParamMap<String, String>().add("phone", phone).add("randcode", randCode)
						.add("exp_time", String.valueOf(expTime)).add("token", getRandcode(appId, appSecret))
						.getPraamMap());
		log.info("china proxy URL:{} time:{}", chinaURL, System.currentTimeMillis() - start);
	}
}
