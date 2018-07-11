package com.example.demo.logback;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Level;

/** 
* @Description: 测试logback的级别 
* @author 王斌
* @date 2018年7月11日 
*  
*/
@RestController
public class TestLogbackLevel {
	private static final Logger test1 = LoggerFactory.getLogger("com.test.mq");
	private static final Logger test2 = LoggerFactory.getLogger("com.test.redis");
	private static final Logger test3 = LoggerFactory.getLogger("com.test.esl");

	@PostConstruct
	public void setLevel() {
		((ch.qos.logback.classic.Logger) test1).setLevel(Level.INFO);
		((ch.qos.logback.classic.Logger) test2).setLevel(Level.INFO);
		((ch.qos.logback.classic.Logger) test3).setLevel(Level.INFO);
	}

	@RequestMapping("setlevel")
	public int setLoggersLevel(@RequestParam("loggerName") String loggerName,
	        @RequestParam("logersLevel") String logersLevel) {
		ch.qos.logback.classic.Logger currentLogger = (ch.qos.logback.classic.Logger) LoggerFactory
		        .getLogger(loggerName);
		currentLogger.setLevel(Level.valueOf(logersLevel));
		return 1;

	}

	@RequestMapping("print")
	public void printLog() {
		test1.debug("test1 debug");
		test1.info("test1 info");
		test1.error("test1 error");
		test2.debug("test2 debug");
		test2.info("test2 info");
		test2.error("test2 error");
		test3.debug("test3 debug");
		test3.info("test3 info");
		test3.error("test3 error");
	}
}
