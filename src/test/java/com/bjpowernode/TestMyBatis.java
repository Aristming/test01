package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import com.bjpowernode.vo.QueryParam;
import com.bjpowernode.vo.StudentAndClassroomVo;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.*;

public class TestMyBatis {

    @Test
    public void testSelectStudentWhere(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student student = new Student();
        student.setName("mengru");
//        student.setEmail("mengru@");
        student.setAge(20);
        List<Student> students = dao.selectStudentWhere(student);
        for (Student s:students){
            System.out.println(s);
        }
    }
    @Test
    public void testfor(){
        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
//         String sql = "select *from student where id in (1001,1002,1003)";
        String sql = "select *from student where id in";
        StringBuilder builder = new StringBuilder();
        int init = 0;
        int len = list.size();
        builder.append("(");

//        for (Integer i:list){
//            builder.append(i);
//            if(len -init>1) {
//                builder.append(",");
//            }
//            init++;
//        }
//还是要多掌握Java提供的方法
        for (Integer i:list){
            builder.append(i).append(",");
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append(")");
        System.out.println(sql+builder);
    }

    @Test
    public void testSelectForeachOne(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Student> students = dao.selectForeachOne(list);
        for (Student s:students){
            System.out.println(s);
        }
    }

    @Test
    public void testSelectForeachTwo(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> list = new ArrayList<>();
        Student s1 = new Student();
        s1.setId(1);
        Student s2 = new Student();
        s1.setId(2);
        list.add(s1);
        list.add(s2);

        List<Student> students = dao.selectForeachTwo(list);
        for (Student stu:students){
            System.out.println(stu);
        }
    }
    @Test
    public void testSelectStudentAll(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        PageHelper.startPage(1,3);
        List<Student> list = dao.selectSudentAll();
        for (Student s:list){
            System.out.println(list);
        }
    }
    @Test
    public void testSelect20(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Map<String,Object>> list = dao.select20();
        for (Map<String,Object> map:list){
            Set<String> stringSet = map.keySet();
            for (String key:stringSet){
                System.out.println("key: "+key);
                System.out.println("value:"+map.get(key));
            }
        }
    }
    @Test
    public void testSelect21(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<StudentAndClassroomVo> voList = dao.select21();
        for (StudentAndClassroomVo vo:voList){
            System.out.println(vo);
        }
    }

}

