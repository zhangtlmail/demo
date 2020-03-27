/**
 * 
 */
package com.example.demo.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author zhangtl
 * @Time 2020年3月22日
 */
public class Position implements Serializable {
	private Integer id;
	private String name;
	@JsonFormat(pattern="yyyy-MM-dd",timezone="Asia/Shanghai")
	private Date createDate;
	private Boolean enabled;
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj==null||getClass()!=obj.getClass()) {
			return false;
		}
		Position position=(Position) obj;
		return Objects.equals(name, position.name);
	}
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	public Position() {
		super();
	}
	
	public Position(String name) {
		super();
		this.name = name;
	}

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
		this.name = name==null?null:name.trim();
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
}
