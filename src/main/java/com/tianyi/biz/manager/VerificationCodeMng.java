package com.tianyi.biz.manager;

import com.tianyi.TianyiException;

/**
 * 验证码接口
 */
public interface VerificationCodeMng{

	/**
	 * 获取信任码
	 */
	String getRandcode(String appId, String appSecret)throws TianyiException;
	

	/**
	 * 发送验证码
	 */
	void send(String appId, String appSecret,String phone)throws TianyiException;
	
	/**
	 * 发送自定义验证码
	 * 
	 * @param appId
	 * @param appSecret
	 * @param phone
	 *            手机号码
	 * @param randCode
	 *            下发内容
	 * @param expTime
	 *            过期时间 (分钟)
	 * @throws TianyiException
	 */
	void send(String appId, String appSecret, String phone, String randCode,
			Integer expTime) throws TianyiException;
}
