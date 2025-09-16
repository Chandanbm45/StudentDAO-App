package in.pentagon.studentapp.index;

import java.util.ArrayList;
import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;

public class Login {
	public static void login() {
		Scanner sc=new Scanner(System.in);
		int choice=0;
		StudentDAO sdao=new StudentDAOImpl();
		System.out.println("<--Login Page-->");
		System.out.println("Enter the mail ID:");
		String mail=sc.next();
		System.out.println("Enter the password:");
		String pass=sc.next();
		Student a=sdao.getStudent(mail,pass);
		if(a!=null) {
			System.out.println("Login successful! Welcome"+a.getName());
			
			do {
				System.out.println("1. View Data");
				System.out.println("2. Search Users");
				System.out.println("3. Update account");
				System.out.println("4. Reset Password");
				System.out.println("5. Back to main menu");
				if(a.getId()==5) {
					System.out.println("6. View all users");
					System.out.println("7. Delete the user");
				}
				choice=sc.nextInt();
				switch(choice) {
				case 1: System.out.println(a);
				break;
				case 2: System.out.println("Enter the student name:");
						String name=sc.next();
						ArrayList<Student> sL1=sdao.getStudent(name);
						for(Student s3:sL1) {
							System.out.println("Student id: "+s3.getId());
							System.out.println("Student name: "+s3.getName());
							System.out.println("Student branch: "+s3.getBranch());
							System.out.println("Student location: "+s3.getLoc());
							System.out.println("Student phone: "+s3.getPhone());
						}	
				break;
				case 3: Update.update(a);
						
				break;
				case 4: Password.reset(a);
				break;
				case 5: System.out.println("Going back to main menu");
				break;
				case 6: System.out.println("Our users...!");
						ArrayList<Student>sL=sdao.getStudent();
						for(Student s:sL) {
							System.out.println(s);
						}
				break;
				case 7: System.out.println("Enter the Student id to delete: ");
						int id = sc.nextInt();
						boolean res = sdao.deleteStudent(id);
						if(res) {
							System.out.println("Student deleted successfully!");
							}
							else {
								System.out.println("Student not found or could not be deleted!");
							}
				break;
				default: System.out.println("Invalid choice");
				}
			}while(choice!=5);
		}
		else {
			System.out.println("Login failed");
		}
	}

}
