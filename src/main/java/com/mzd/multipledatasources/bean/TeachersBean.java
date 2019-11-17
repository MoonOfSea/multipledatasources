package com.mzd.multipledatasources.bean;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "cs_teacher")
public class TeachersBean {
	@Id
	private String id;
	private String teachername;
	private String classid;
	@Column(name = "creat_time")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createtime;
}
