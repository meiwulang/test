package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description TODO
 * @author 王斌
 * @date 2017年11月3日 下午1:50:52
 * @version V1.0
 */
@EnableAutoConfiguration
@SpringBootApplication
public class App {
	@Value("${test}")
	private String string;

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(args));
		SpringApplication.run(App.class, args);
	}
}
