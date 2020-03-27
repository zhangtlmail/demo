/**
 * 
 */
package com.example.demo.pojo;

import java.io.Serializable;

/**
 * @author zhangtl
 * @Time 2020年3月22日
 */
public class Role implements Serializable {
	private Integer id;
	private String name;
	private String nameZh;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameZh() {
		return nameZh;
	}
	public void setNameZh(String nameZh) {
		this.nameZh = nameZh;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", nameZh=" + nameZh + "]";
	}
	
}
