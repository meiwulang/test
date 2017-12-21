package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "my")
public class Config {
	private String name;
	private Integer port;
	private List<String> servers = new ArrayList<String>();

	public String geName() {
		return this.name;
	}

	public Integer gePort() {
		return this.port;
	}

	public List<String> getServers() {
		return this.servers;
	}
}