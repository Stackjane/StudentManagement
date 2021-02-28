package dao;

import java.util.List;
import student.Student;

public class StudentDao extends BasicDao<Student>{
	

	//ͳ��ѧ������
	public Long StudentCount() {
		return (Long)super.Scalar("select count(*) from student");
	}
	
	//�鿴ѧ������
	public void SelectAllStudent() {
		List<Student> list = super.QueryMulti("select * from student", Student.class);
		System.out.println("ѧ��"+"\t"+"����"+"\t"+"��������"+"\t"+"\t"+"�꼶"+"\t"+"�绰");
		for(Student stu:list)
			System.out.println(stu);
	}

	//����ѧ�Ų�ѯѧ������
	public String SelectNamebyId(String id) {
		return (String)super.Scalar("select student_name from student where student_id = ?",id);
	}
	//����ѧ����������ѯѧ������Ϣ
	public void SelectStudentbyName(String name) {
		Student stu = super.QuerySingle("select * from student where student_name = ?", Student.class, name);
		System.out.println("ѧ��"+"\t"+"����"+"\t"+"��������"+"\t"+"\t"+"�꼶"+"\t"+"�绰");
		System.out.println(stu);
	}
	//�޸�ѧ���ĳ�������
	public int updateBornday(String borndate,String student_id) {
		return super.update("update student set borndate = ? where student_id = ?", borndate,student_id);
	}
	
	//ɾ��ѧ������Ϣ
	public int DeleteStu(String student_id) {
		return super.update("delete from student where student_id = ?", student_id);
	}
	
	//�����꼶��ѯѧ����Ϣ
	public void SelectbyGrade(String grade) {
		List<Student> list = super.QueryMulti("select * from student where student_grade = ?", Student.class, grade);
		System.out.println("ѧ��"+"\t"+"����"+"\t"+"��������"+"\t"+"\t"+"�꼶"+"\t"+"�绰");
		for(Student stu: list)
			System.out.println(stu);
	}
	
}
