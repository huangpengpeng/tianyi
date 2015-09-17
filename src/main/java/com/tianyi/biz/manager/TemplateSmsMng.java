package com.tianyi.biz.manager;

import java.util.Map;

import com.tianyi.TianyiException;

public interface TemplateSmsMng {

	public void send(String appId, String appSecret,String phone, String templateId, Map<String, String> params)throws TianyiException;
	
}
