package com.atguigu.springcloud.entities;

import java.io.Serializable;

//import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

//压制警告
@SuppressWarnings("serial")   
//get set 方法
@Data    
//@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain=true)  //支持链方法
public class Dept implements Serializable //为持久化，必须序列化     Dept(Entity) orm mysql-->Dept(table) 类表关系映射
{ 
	private Long deptno; // 主键
	private String dname; // 部门名称
	private String db_source;
	// 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
	
	public Dept(String dname) {
		super();
		this.dname = dname;
	}

}
