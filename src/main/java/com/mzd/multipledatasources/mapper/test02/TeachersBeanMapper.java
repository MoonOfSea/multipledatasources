package com.mzd.multipledatasources.mapper.test02;

import com.mzd.multipledatasources.bean.TeachersBean;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author: ycz
 * @Date: 2019/11/12
 */
@Repository
public interface TeachersBeanMapper extends Mapper<TeachersBean> {
}
