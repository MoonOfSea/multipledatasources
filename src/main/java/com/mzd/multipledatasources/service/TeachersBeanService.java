package com.mzd.multipledatasources.service;

import com.mzd.multipledatasources.bean.TeachersBean;
import com.mzd.multipledatasources.mapper.test02.TeachersBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: ycz
 * @Date: 2019/11/12
 */
@Service
public class TeachersBeanService {
    @Autowired
    private TeachersBeanMapper teachersBeanMapper;

    public List<TeachersBean> findAll(){
        return teachersBeanMapper.selectAll();
    }
}
