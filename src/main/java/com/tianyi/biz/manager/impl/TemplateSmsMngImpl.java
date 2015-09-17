package com.tianyi.biz.manager.impl;

import java.net.URLEncoder;
import java.util.Map;

import com.common.http.HttpException;
import com.common.util.JsonUtils;
import com.common.util.ParamMap;
import com.common.web.util.WebUtils;
import com.tianyi.TianyiException;
import com.tianyi.biz.manager.TemplateSmsMng;
import com.tianyi.biz.manager.TianyiBase;

public class TemplateSmsMngImpl extends TianyiBase implements TemplateSmsMng{

	@Override
	public void send(String appId, String appSecret, String phone,
			String templateId, Map<String, String> params) throws TianyiException {
		String templateParam = JsonUtils.renderJson(params);
		super.httpRequest(
				appId,
				appSecret,
				"http://api.189.cn/v2/emp/templateSms/sendSms",
				new ParamMap<String, String>().add("acceptor_tel", phone)
						.add("template_id", templateId)
						.add("template_param", templateParam).getPraamMap());
	}


	
	public static void main(String[] args) {
		TemplateSmsMng templateSmsMng = new TemplateSmsMngImpl();
		// templateSmsMng.send(
		// "13777368110",
		// "91002014",垌
		// new ParamMap().add("param1", "悠语旗舰店")
		// .add("param2", "http://u.uco.com/do ")
		// .add("param3", "yellowroc 淘宝ID").getPraamMap());
//		templateSmsMng
//				.send("15990146310",
//						"35F0505CD27E46AC918914F6C872",
//						"您成功申请了 雅诗兰黛优惠券，请点击下面网址: http://u.uco.com/asdff 领取,需要用您刚才登记的yellow_roc进行授权登录【悠可】",
//						"13777368110");
	}
}
