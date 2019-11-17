package com.mzd.multipledatasources.service;

import com.mzd.multipledatasources.bean.TeachersBean;
import com.mzd.multipledatasources.bean.TestBean;
import com.mzd.multipledatasources.mapper.test01.TestBeanMapper;
import com.mzd.multipledatasources.mapper.test01.TestBeanMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author: ycz
 * @Date: 2019/11/12
 */
@Service
public class TestBeanService {
    @Autowired
    private TestBeanMapper testBeanMapper;

    public List<TestBean> findAll(){
        List<TestBean> testBeanList = testBeanMapper.selectAll();
        return testBeanList;
    }
    public int inserteOne(){
        TestBean testBean=new TestBean();
        testBean.setId("1");
        testBean.setScore(90);
        int count = testBeanMapper.insertSelective(testBean);
        System.out.println("插入的id： "+testBean.getUserid());
        return count;
    }

    public List<TestBean> selecteByQuery(){
        Example example=new Example(TestBean.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("score",90);
        List<TestBean> list = testBeanMapper.selectByExample(example);
        return list;
    }

    public List<TestBean> selecteByQueryByOrder(){
        Example example=new Example(TestBean.class);
        example.setOrderByClause("score desc");//根据score降序
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("classid",1);//classid=1
        RowBounds rb=new RowBounds(0,10);//查询10条数据
        List<TestBean> list = testBeanMapper.selectByExampleAndRowBounds(example,rb);
        return list;
    }

}
