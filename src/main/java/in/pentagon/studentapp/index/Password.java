package in.pentagon.studentapp.index;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;

public class Password {
	public static void reset(Student s) {
		Scanner sc = new Scanner(System.in);
		StudentDAO sdao = new StudentDAOImpl();
		System.out.println("Enter the phone");
		long phone = sc.nextLong();

		System.out.println("Enter the Mail");
		String mail = sc.next();

		if (s.getPhone() == phone && s.getMail().equals(mail))
		{
			System.out.println("Set the new Password");
			String pass = sc.next();

			System.out.println("Confirm the password");
			String confirm = sc.next();
			if (pass.equals(confirm)) {
				s.setPassword(pass);
				boolean res = sdao.updateStudent(s);
				if (res) {
					System.out.println("Updated Sucessfully");
				} else {
					System.out.println("Failed to Update Password");
				}
			} else {
				System.out.println("password MisMatched");
			}
		}else {
			System.out.println("Invalid mailid or number");
		}
	}
}
