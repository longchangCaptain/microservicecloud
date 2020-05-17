package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;


//前后端分离，返回json串
@RestController
public class DeptController {
	@Autowired
	private DeptService deptService;
	
	@Autowired
	private DiscoveryClient client;
	
	//符合 REST资源转移的风格写法  get list 
	//@RequestMapping(value="//dept/add",method=RequestMethod.POST)
	@PostMapping("/dept/add")
	public boolean add(@RequestBody Dept dept){
		return deptService.add(dept);
	}
	@GetMapping("/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id){
		return deptService.get(id);
	}
	@GetMapping("/dept/list")
	public List<Dept> list(){
		return deptService.list();
	}
	
	@RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
	  public Object discovery()
	  {
	    List<String> list = client.getServices();
	    System.out.println("..."+list);

	    List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
	    for (ServiceInstance element : srvList) {
	     System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
	         + element.getUri());
	    }
	    return this.client;
	  }


	
}
