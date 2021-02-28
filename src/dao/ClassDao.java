package dao;

import java.util.List;

import student.Grade;

public class ClassDao extends BasicDao<Grade>{
	
	//查询各个年级的人数
	public void SelectbyGrade() {
		List<Grade> list = super.QueryMulti("select student_grade,count(*) as count from student group by student_grade", Grade.class);
		System.out.println("年级"+"\t"+"人数");
		for(Grade grade: list)
			System.out.println(grade);
	}
}


