package com.example.demo.json2xml;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;

/** 
* @Description: TODO 
* @author 王斌
* @date 2018年7月11日 
*  
*/
public class TestJson2xml {
	public static void main(String[] args) {
		String info = "{\"version\":\"1.0\",\"command\":\"update_customer\",\"sequence\":56645,\"customer_id\":\"listen1\",\"agent_list\":[\"1008\"],\"caller_list\":[{\"id\":\"gw1\",\"number\":\"888\",\"sip_server\":\"10.250.250.155:5060\",\"sip_user_name\":\"admin\",\"sip_password\":\"admin\",\"sip_register\":0,\"capacity\":30,\"router\":\"\"},{\"id\":\"gw2\",\"number\":\"888\",\"sip_server\":\"10.250.250.155:5060\",\"sip_user_name\":\"admin\",\"sip_password\":\"admin\",\"sip_register\":0,\"capacity\":30,\"router\":\"\"}]}";
		JSONObject jsonObject = JSONObject.parseObject(info);
		createService(jsonObject);
	}

	public static void createService(JSONObject jsonObject) {
		try {
			// 模板页面
			String daoTemplate = getPath("template\\gw.xml");
			// 写入到磁盘里面去
			String customerId = jsonObject.getString("customer_id");
			String result = replaceValues(daoTemplate, jsonObject, customerId);
			// 要生成的根目录
			String daoRoot = getPath("template");
			File rootPath = new File(daoRoot);
			// 如果不存在那么久创建
			if (!rootPath.exists()) rootPath.mkdirs();
			// 产生接口文件
			File daoJava = new File(rootPath, customerId + "-gw.xml");
			// 讲模板中替换好的数据通过写入目录中去
			FileUtils.writeStringToFile(daoJava, result, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static String replaceValues(String path, JSONObject jsonObject, String customerId) throws IOException {
		String item = FileUtils.readFileToString(new File(path), "UTF-8");
		String result = "<include>\n";
		List<Map<String, Object>> callerList = (List<Map<String, Object>>) jsonObject.get("caller_list");
		for (Map<String, Object> map : callerList) {
			result += item.replace("[customer_id]", customerId).replace("[id]", (String) map.get("id"))
			        .replace("[username]", (String) map.get("sip_user_name"))
			        .replace("[password]", (String) map.get("sip_password"))
			        .replace("[realm]", (String) map.get("sip_server"))
			        .replace("[register]", (Integer) map.get("sip_register") == 1 ? "true" : "false");
		}
		result += "</include>";
		return result;
	}

	public static String getPath(String appendPath) {
		String path = System.getProperty("user.dir");
		if (StringUtils.isEmpty(appendPath)) {
			return path;
		} else {
			return path + "\\" + appendPath;
		}
	}
}
