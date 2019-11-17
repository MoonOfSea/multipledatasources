package com.mzd.multipledatasources.mapper.test01;

import com.mzd.multipledatasources.bean.TestBean;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;


@Repository
public interface TestBeanMapper extends Mapper<TestBean> {
}
