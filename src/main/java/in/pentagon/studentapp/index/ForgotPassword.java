package in.pentagon.studentapp.index;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;

public class ForgotPassword {
	public static void forgot() {
		Scanner sc=new Scanner(System.in);
		StudentDAO sdao=new StudentDAOImpl();
		System.out.println("<----Forgot Password---->");
		System.out.println("Enter your registered Mail Id");
		String mail=sc.next();
		
		System.out.println("Enter your Phone Number");
		Long phone=sc.nextLong();
		
		Student s=sdao.getStudent(phone, mail);
		if(s!=null) {
			System.out.println("Enter the new password");
			String newpass=sc.next();
			System.out.println("Enter the confirm password");
			String confirmpass=sc.next();
			
			if(newpass.equals(confirmpass)) {
				s.setPassword(newpass);
				boolean res=sdao.updateStudent(s);
				if(res) {
					System.out.println("Password updated sucesfully");
				}else {
					System.out.println("Failed to update password. Try again!");
				}
			}else {
				System.out.println("Password does not match!");
			}
		}else {
			System.out.println("Invalid MailId or Phone number");
		}
	}
} 
