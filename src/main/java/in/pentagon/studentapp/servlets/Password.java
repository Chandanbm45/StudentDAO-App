package in.pentagon.studentapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDAOImpl;
import in.pentagon.studentapp.dto.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/password")
public class Password extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDAO sdao = new StudentDAOImpl();
		PrintWriter out = resp.getWriter();

		Student s = sdao.getStudent(Long.parseLong(req.getParameter("phone")), req.getParameter("mail"));

		if (s != null) {
			if (req.getParameter("password").equals(req.getParameter("confirm"))) {
				s.setPassword(req.getParameter("password"));
				boolean res=sdao.updateStudent(s);
				if (sdao.updateStudent(s)) {
					//out.println("<h1>Password Reset Successful!</h1>");
					req.setAttribute("success", "Password updated successfully!");
					RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
					rd.forward(req, resp);
					
				} else {
					//out.println("<h1>Failed to Reset Password!</h1>");
					req.setAttribute("error", "Failed to Reset Password!");
					RequestDispatcher rd=req.getRequestDispatcher("password.jsp");
					rd.forward(req, resp);
				}
			} else {
				//out.println("<h1>Password Mismatch!</h1>");
				req.setAttribute("error", "Password Mismatch!");
				RequestDispatcher rd=req.getRequestDispatcher("password.jsp");
				rd.forward(req, resp);
			}
		} else {
			//out.print("<h1>Invalid User details!</h1>");
			req.setAttribute("error", "Invalid user details!");
			RequestDispatcher rd=req.getRequestDispatcher("password.jsp");
			rd.forward(req, resp);
		}
	}
}

