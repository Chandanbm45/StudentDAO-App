package in.pentagon.studentapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import in.pentagon.student.connection.Connector;
import in.pentagon.studentapp.dto.Student;

public class StudentDAOImpl implements StudentDAO{
	private Connection con;
	public StudentDAOImpl() {
		this.con=Connector.requestConnection();
		}

	//JDBC logics written here
	@Override
	public boolean insertStudent(Student s) {
		PreparedStatement ps=null;
		String query="INSERT INTO STUDENT VALUES(0,?,?,?,?,?,?,SYSDATE())";
		int i=0;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, s.getName());
			ps.setLong(2, s.getPhone());
			ps.setString(3, s.getMail());
			ps.setString(4, s.getBranch());
			ps.setString(5, s.getLoc());
			ps.setString(6, s.getPassword());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0) {
			return true;
		}
		else {
		return false;
	}

	}

	@Override
	public boolean updateStudent(Student s) {
		PreparedStatement ps=null;
		String query="UPDATE STUDENT SET NAME=?,PHONE=?, MAIL=?, BRANCH=?, LOC=?, PASSWORD=?,DATE=SYSDATE() WHERE ID=?";
		int i=0;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, s.getName());
			ps.setLong(2, s.getPhone());
			ps.setString(3, s.getMail());
			ps.setString(4, s.getBranch());
			ps.setString(5, s.getLoc());
			ps.setString(6, s.getPassword());
			ps.setInt(7,s.getId());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean deleteStudent(int id) {
		PreparedStatement ps=null;
		String query="DELETE FROM STUDENT WHERE ID=?";
		int i=0;
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, id);
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Student getStudent(String mail, String password) {
		
		PreparedStatement ps=null;
		Student s=null;
		String query="SELECT * FROM STUDENT WHERE MAIL=? AND PASSWORD=?";
		try {
			ps=con.prepareStatement(query);
			ps.setNString(1, mail);
			ps.setNString(2, password);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMail(rs.getString("mail"));
				s.setBranch(rs.getString("branch"));
				s.setLoc(rs.getString("loc"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public Student getStudent(long phone, String mail) {
		PreparedStatement ps=null;
		Student s=null;
		String query="SELECT * FROM STUDENT WHERE PHONE=? AND MAIL=?";
		try {
			ps=con.prepareStatement(query);
			ps.setLong(1, phone);
			ps.setString(2, mail);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				s=new Student(); 
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMail(rs.getString("mail"));
				s.setBranch(rs.getString("branch"));
				s.setLoc(rs.getString("loc"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public ArrayList<Student> getStudent(String name) {
		ArrayList<Student> sl = new ArrayList<>();
		Student s=null;
		String query="SELECT * FROM STUDENT WHERE NAME=?";
		PreparedStatement ps =null;
		try {
			ps= con.prepareStatement(query);
			ps.setString(1,name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMail(rs.getString("mail"));
				s.setBranch(rs.getString("branch"));
				s.setLoc(rs.getString("loc"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
				sl.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sl;
	}

	@Override
	public ArrayList<Student> getStudent() {
		ArrayList<Student> studentsList = new ArrayList<>(); //arraylist obj
		Student s=null; //s
		String query="SELECT * FROM STUDENT";
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMail(rs.getString("mail"));
				s.setBranch(rs.getString("branch"));
				s.setLoc(rs.getString("loc"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
				studentsList.add(s);
			
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return studentsList;
	}

}

