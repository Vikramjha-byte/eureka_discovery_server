package com.vikram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class DCController {

	@Autowired
	private EurekaClient client;

	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	@RequestMapping("/")
	public String callService() {

		RestTemplate restTemplate = restTemplateBuilder.build();
		InstanceInfo instanceInfo = client.getNextServerFromEureka("service", false);

		String homePageUrl = instanceInfo.getHomePageUrl();

		ResponseEntity<String> exchange = restTemplate.exchange(homePageUrl, HttpMethod.GET, null, String.class);

		return exchange.getBody();
	}

}
