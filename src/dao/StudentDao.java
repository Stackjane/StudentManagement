package dao;

import java.util.List;
import student.Student;

public class StudentDao extends BasicDao<Student>{
	

	//统计学生人数
	public Long StudentCount() {
		return (Long)super.Scalar("select count(*) from student");
	}
	
	//查看学生名单
	public void SelectAllStudent() {
		List<Student> list = super.QueryMulti("select * from student", Student.class);
		System.out.println("学号"+"\t"+"姓名"+"\t"+"出生日期"+"\t"+"\t"+"年级"+"\t"+"电话");
		for(Student stu:list)
			System.out.println(stu);
	}

	//按照学号查询学生姓名
	public String SelectNamebyId(String id) {
		return (String)super.Scalar("select student_name from student where student_id = ?",id);
	}
	//根据学生的姓名查询学生的信息
	public void SelectStudentbyName(String name) {
		Student stu = super.QuerySingle("select * from student where student_name = ?", Student.class, name);
		System.out.println("学号"+"\t"+"姓名"+"\t"+"出生日期"+"\t"+"\t"+"年级"+"\t"+"电话");
		System.out.println(stu);
	}
	//修改学生的出生日期
	public int updateBornday(String borndate,String student_id) {
		return super.update("update student set borndate = ? where student_id = ?", borndate,student_id);
	}
	
	//删除学生的信息
	public int DeleteStu(String student_id) {
		return super.update("delete from student where student_id = ?", student_id);
	}
	
	//按照年级查询学生信息
	public void SelectbyGrade(String grade) {
		List<Student> list = super.QueryMulti("select * from student where student_grade = ?", Student.class, grade);
		System.out.println("学号"+"\t"+"姓名"+"\t"+"出生日期"+"\t"+"\t"+"年级"+"\t"+"电话");
		for(Student stu: list)
			System.out.println(stu);
	}
	
}
