package com.tianyi.biz.manager;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import open189.sign.ParamsSign;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.common.http.HttpClient;
import com.common.http.HttpException;
import com.common.http.PostParameter;
import com.common.http.Response;
import com.common.util.ChinarequestUtils;
import com.common.util.JsonUtils;
import com.tianyi.TianyiException;

public class TianyiBase {
	
	private Logger log=LoggerFactory.getLogger(TianyiBase.class);

	private static final String TOKEN_HTTP = "https://oauth.api.189.cn/emp/oauth2/v2/access_token";

	/**
	 * 获取授权token
	 * 
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	protected Map<String, Object> getTianyiToken(String appId, String appSecret) throws TianyiException {
		Response response;
		try {
			String chinaURL = ChinarequestUtils.proxyRequest(ChinarequestUtils.CHANNEL_TIANYI_SEND_MSG_CONFIG_ID,
					TOKEN_HTTP);
			long start = System.currentTimeMillis();
			response = HttpClient.newConnection().post(chinaURL,
					new PostParameter[] { new PostParameter("grant_type", "client_credentials"),
							new PostParameter("app_id", appId), new PostParameter("app_secret", appSecret) });
			log.info("china proxy URL:{} time:{}", chinaURL, System.currentTimeMillis() - start);
			return JsonUtils.toMap(response.getResponseAsString());
		} catch (HttpException e) {
			throw new TianyiException(e, "获取天翼TOKEN失败");
		}
	}

	/**
	 * 获取签名
	 * 
	 * @param params
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	protected String getSign(Map<String, String> params, String appSecret) {
		/* 定义TreeMap容器实例，用于装载请求参数 */
		TreeMap<String, String> paramsMap = new TreeMap<String, String>(params);

		// 调用SDK方法，获得参数签名值
		try {
			return URLDecoder.decode(ParamsSign.value(paramsMap, appSecret),
					"UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException("签名失败" + e.getMessage(), e);
		}
	}

	public Map<String, Object> httpRequest(String appId, String appSecret,
			String url, Map<String, String> params) throws TianyiException {

		// 没有传入授权码，则获取默认授权码
		Map<String, Object> map = this.getTianyiToken(appId, appSecret);
		String token = (String) map.get("access_token");

		// 设置授权编号
		params.put("app_id", appId);

		// 设置授权
		params.put("access_token", token);

		// 设置时间戳
		params.put("timestamp",
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

		// 设置签名
		params.put("sign", getSign(params, appSecret));

		PostParameter[] postParameters = new PostParameter[params.size()];

		// 将Map转换成httpclient参数
		int i = 0;
		for (Map.Entry<String, String> entry : params.entrySet()) {
			postParameters[i] = new PostParameter(entry.getKey(),
					entry.getValue());
			i++;
		}

		Response response;
		try {
			response = HttpClient.newConnection().post(url,
					postParameters);
		} catch (HttpException e) {
			throw new TianyiException(e, "天翼能力HTTP请求失败");
		}

		Map<String, Object> resultMap = JsonUtils.toMap(response
				.getResponseAsString());

		String res_code = resultMap.get("res_code") == null ? null : resultMap
				.get("res_code").toString();
		String res_message = resultMap.get("res_message") == null ? null
				: resultMap.get("res_message").toString();

		if (res_code != null && !StringUtils.equals(res_code, "0")) {
			throw new TianyiException(res_code, res_message);
		}

		return resultMap;
	}

}
