package com.mzd.multipledatasources.controller;

import com.mzd.multipledatasources.bean.TeachersBean;
import com.mzd.multipledatasources.bean.TestBean;
import com.mzd.multipledatasources.service.TeachersBeanService;
import com.mzd.multipledatasources.service.TestBeanService;
import com.mzd.multipledatasources.service.TransactionService1;
import com.mzd.multipledatasources.service.TransactionService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * 多数据源事务测试
 * 
 * @author acer
 *
 */
@RestController
public class TransactionController {
	@Autowired
	private TransactionService1 ts1;
	@Autowired
	private TransactionService2 ts2;

	@Autowired
	private TestBeanService testBeanService;

	@Autowired
	private TeachersBeanService teachersBeanService;


	@RequestMapping("/savetest.do")
	public String savetest() {
		TestBean tb = new TestBean();
		tb.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		tb.setScore(99);
		tb.setClassid("1");
		tb.setUserid("a");
		ts1.savetestBean(tb);
		return "success";
	}

	@RequestMapping("/saveteacher.do")
	public String saveteacher() {
		TeachersBean tb = new TeachersBean();
		tb.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		tb.setTeachername("汪老师");
		tb.setClassid("2");
		ts2.saveTeacher(tb);
		return "success";
	}

	@RequestMapping("/findAllTestbean.do")
	public String findAllTestbean() {
		List<TestBean> all = testBeanService.findAll();
		for (TestBean tb:all ) {
			System.out.println(tb.getId()+" "+ tb.getUserid()+" "+tb.getScore());
		}
		return "success";
	}

	@RequestMapping("/findAllTeacherbean.do")
	public String findAllTeacherbean() {
		List<TeachersBean> all = teachersBeanService.findAll();

		for (TeachersBean teacher:all) {
			System.out.println(teacher.getId()+"  "+teacher.getTeachername()+"  "+teacher.getClassid()+teacher.getCreatetime());
		}
		return "success";
	}

	@RequestMapping("/selecteByQueryByOrder.do")
	public String selecteByQueryByOrder() {
		List<TestBean> testBeanList = testBeanService.selecteByQueryByOrder();
		for (TestBean testBean : testBeanList) {
			System.out.println(testBean.getId()+" 班级: "+testBean.getClassid()+" 分数: "+testBean.getScore());
		}
		return "success";
	}

}
