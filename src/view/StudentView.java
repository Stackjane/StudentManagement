package view;

import java.util.Scanner;

import dao.ClassDao;
import dao.StudentDao;


public class StudentView {
	private static StudentDao studao = new StudentDao();
	private static ClassDao cla = new ClassDao();
	
	
	public static void studetnview1() {
		System.out.println("--------1.统计学生人数--------");
		System.out.println("--------2.查看学生名单--------");
		System.out.println("--------3.按学号查询学生姓名----");
		System.out.println("--------4.按姓名查询学生信息----");
		System.out.println("--------5.修改学生出生日期-----");
		System.out.println("--------6.删除学生信息--------");
		System.out.println("--------7.查询各个年级的人数----");
		System.out.println("--------8.按照年级查询学生的信息-");
		System.out.println("--------0.退出-------------");
	}
	
	public static void studentview2() throws Exception {
		Scanner in = new Scanner(System.in);
		
		a:
		while(true) {
			StudentView.studetnview1();
			System.out.println("请输入操作键：");
			switch(in.nextInt()) {
			case 1:
				System.out.println(studao.StudentCount());
				break;
			case 2:
				studao.SelectAllStudent();
				break;
			case 3:
				System.out.println("请输入学号：");
				String id = in.next();
				System.out.println(studao.SelectNamebyId(id));
				break;
			case 4:
				System.out.println("请输入姓名：");
				studao.SelectStudentbyName(in.next());
				break;
			case 5:
				System.out.println("请输出要修改的学生的学号：");
				String student_id = in.next();
				System.out.println("请输出要修改的学生的生日：");
				String borndate = in.next();
				System.out.println(studao.updateBornday(borndate, student_id) > 0? "修改成功":"修改失败");
				break;
			case 6:
				System.out.println("请输入要删除的学生的学号：");
				String number = in.next();
				System.out.println("请确认要删除的学号是："+number+','+"姓名为"+studao.SelectNamebyId(number)+"的学生信息吗?(Yes/No)");
				String answer = in.next();
				if(answer.equals("Yes")) {
					System.out.println(studao.DeleteStu(number) > 0? "删除成功":"删除失败");
					break;
				}
				else {
					break;
				}
			case 7:
				cla.SelectbyGrade();
				break;
			case 8:
				System.out.println("请输入要查询的年级：");
				studao.SelectbyGrade(in.next());
				break;
			case 0:
				System.out.println("感谢您的使用，欢迎下次再来！");
				break a;
			}
			
		}
		in.close();
	}

}
