package com.mzd.multipledatasources.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "cs_test")
public class TestBean {
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "JDBC")//此处加上注解
	private String id;
	private String userid;
	private Integer score;
	private String classid;
	private Date createtime;

}
