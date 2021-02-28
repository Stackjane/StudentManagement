package student;

import java.util.Date;

public class Student {
	private String student_id;
	private String student_name;
	private Date borndate;
	private String student_grade;
	private String student_phone;
	
	
	
	public String getStudent_id() {
		return student_id;
	}



	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}



	public String getStudent_name() {
		return student_name;
	}



	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}



	public Date getBorndate() {
		return borndate;
	}



	public void setBorndate(Date borndate) {
		this.borndate = borndate;
	}



	public String getStudent_grade() {
		return student_grade;
	}



	public void setStudent_grade(String student_grade) {
		this.student_grade = student_grade;
	}



	public String getStudent_phone() {
		return student_phone;
	}



	public void setStudent_phone(String student_phone) {
		this.student_phone = student_phone;
	}



	@Override
	public String toString() {
		return student_id + "\t" + student_name + "\t" + borndate + "\t" + student_grade + "\t" + student_phone;
	}	
}
