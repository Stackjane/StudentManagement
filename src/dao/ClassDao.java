package dao;

import java.util.List;

import student.Grade;

public class ClassDao extends BasicDao<Grade>{
	
	//��ѯ�����꼶������
	public void SelectbyGrade() {
		List<Grade> list = super.QueryMulti("select student_grade,count(*) as count from student group by student_grade", Grade.class);
		System.out.println("�꼶"+"\t"+"����");
		for(Grade grade: list)
			System.out.println(grade);
	}
}


