package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;
import com.bjpowernode.vo.QueryParam;
import com.bjpowernode.vo.StudentAndClassroomVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    List<Map<String, Object>> select20();

    List<Student> selectStudentIf(Student student);
    List<Student> selectStudentWhere(Student student);
    List<Student> selectForeachOne(List<Integer> idList);
    List<Student> selectForeachTwo(List<Student> stulist);
    List<Student> selectSudentAll();


    List<StudentAndClassroomVo> select21();
}
