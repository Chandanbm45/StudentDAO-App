package in.pentagon.studentapp.index;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;

public class Signup {
	public static void signup() {
		Scanner sc=new Scanner(System.in);
		
		StudentDAO sdao=new StudentDAOImpl();
		Student s=new Student();
		System.out.println("<--Student Signup-->");
		System.out.println("Enter the name");
		s.setName(sc.next());
		System.out.println("Enter the Phone");
		s.setPhone(sc.nextLong());
		System.out.println("Enter the mail ID");
		s.setMail(sc.next());
		System.out.println("Enter the Branch");
		s.setBranch(sc.next());
		System.out.println("Enter the location");
		s.setLoc(sc.next());
		System.out.println("Set a new password");
		String password=sc.next();
		System.out.println("Confirm the password");
		String confirmpassword=sc.next();
		
		if(password.equals(confirmpassword)) {
			s.setPassword(confirmpassword);
			boolean res=sdao.insertStudent(s);
			if(res) {
				System.out.println("Data added successfully");
			}
			else {
				System.out.println("Failed to create a account");
			}
		}
		else {
			System.out.println("Password mismatch!");
		}
	}

}
