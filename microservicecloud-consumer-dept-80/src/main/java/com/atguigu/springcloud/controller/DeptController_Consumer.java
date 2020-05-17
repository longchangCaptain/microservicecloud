package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atguigu.springcloud.entities.Dept;

@SuppressWarnings("unused")
@RestController
public class DeptController_Consumer {
	@Autowired
	private RestTemplate RestTemplate;
	
	//private static final String REST_URL_PREFIX="http://localhost:8001";
	private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";
	
	@GetMapping("/consumer/dept/add")
	public boolean addDept(Dept dept){
		return RestTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
	}
	@GetMapping("/consumer/dept/get/{id}")
	public Dept findById(@PathVariable("id") Long id){
		return RestTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
	}
	@SuppressWarnings("unchecked")
	@GetMapping("/consumer/dept/list")
	public List<Dept> findAll(){
		return RestTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
	}
	
	@RequestMapping(value="/consumer/dept/discovery")
	public Object discovery(){
		return RestTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery", Object.class);
	}
}
