package view;

import java.util.Scanner;

import dao.ClassDao;
import dao.StudentDao;


public class StudentView {
	private static StudentDao studao = new StudentDao();
	private static ClassDao cla = new ClassDao();
	
	
	public static void studetnview1() {
		System.out.println("--------1.ͳ��ѧ������--------");
		System.out.println("--------2.�鿴ѧ������--------");
		System.out.println("--------3.��ѧ�Ų�ѯѧ������----");
		System.out.println("--------4.��������ѯѧ����Ϣ----");
		System.out.println("--------5.�޸�ѧ����������-----");
		System.out.println("--------6.ɾ��ѧ����Ϣ--------");
		System.out.println("--------7.��ѯ�����꼶������----");
		System.out.println("--------8.�����꼶��ѯѧ������Ϣ-");
		System.out.println("--------0.�˳�-------------");
	}
	
	public static void studentview2() throws Exception {
		Scanner in = new Scanner(System.in);
		
		a:
		while(true) {
			StudentView.studetnview1();
			System.out.println("�������������");
			switch(in.nextInt()) {
			case 1:
				System.out.println(studao.StudentCount());
				break;
			case 2:
				studao.SelectAllStudent();
				break;
			case 3:
				System.out.println("������ѧ�ţ�");
				String id = in.next();
				System.out.println(studao.SelectNamebyId(id));
				break;
			case 4:
				System.out.println("������������");
				studao.SelectStudentbyName(in.next());
				break;
			case 5:
				System.out.println("�����Ҫ�޸ĵ�ѧ����ѧ�ţ�");
				String student_id = in.next();
				System.out.println("�����Ҫ�޸ĵ�ѧ�������գ�");
				String borndate = in.next();
				System.out.println(studao.updateBornday(borndate, student_id) > 0? "�޸ĳɹ�":"�޸�ʧ��");
				break;
			case 6:
				System.out.println("������Ҫɾ����ѧ����ѧ�ţ�");
				String number = in.next();
				System.out.println("��ȷ��Ҫɾ����ѧ���ǣ�"+number+','+"����Ϊ"+studao.SelectNamebyId(number)+"��ѧ����Ϣ��?(Yes/No)");
				String answer = in.next();
				if(answer.equals("Yes")) {
					System.out.println(studao.DeleteStu(number) > 0? "ɾ���ɹ�":"ɾ��ʧ��");
					break;
				}
				else {
					break;
				}
			case 7:
				cla.SelectbyGrade();
				break;
			case 8:
				System.out.println("������Ҫ��ѯ���꼶��");
				studao.SelectbyGrade(in.next());
				break;
			case 0:
				System.out.println("��л����ʹ�ã���ӭ�´�������");
				break a;
			}
			
		}
		in.close();
	}

}
