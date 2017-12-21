package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @author 王斌
 * @date 2017年11月3日 下午3:28:40
 * @version V1.0
 */
@RestController
public class MyController {
	@Autowired
	Config config;

	@RequestMapping("getname")
	public String getName() {
		return "----->" + config.geName();
	}
}
