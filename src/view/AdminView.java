package view;

import java.util.Scanner;
import dao.AdminDao;

public class AdminView {
	
	public static void adminview() {
		Scanner in = new Scanner(System.in);
		System.out.println("�������û�����");
		String username = in.next();
		System.out.println("���������룺");
		String password = in.next();
		AdminDao admin = new AdminDao();
		Long object = (Long) admin.Scalar("select count(*) from admin where username = ? and password = ?",username,password);
		System.out.println(object > 0? "��¼�ɹ���":"��֤ʧ��");
	}
}
