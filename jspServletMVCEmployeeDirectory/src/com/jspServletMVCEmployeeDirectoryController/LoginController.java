package com.jspServletMVCEmployeeDirectoryController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspServlet.DAO.LoginDAO;
import com.jspServlet.DAO.LoginDAOImpl;
import com.jspServlet.entity.Login;

/**
 * Servlet implementation class loginConrtoller
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	LoginDAO loginDAO=null;

	public LoginController() {
		loginDAO=new LoginDAOImpl();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Login login=new Login();
		
		login.setEmail(request.getParameter("email"));
		login.setPassword(request.getParameter("password"));
		
		String status=loginDAO.authentiacte(login);
		
		if(status.equals("true")) {
			session.setAttribute("email",login.getEmail());
			response.sendRedirect("EmployeeController?action=LIST");		//passing to the controller threfor no dispatcher
		}
		else if(status.equals("false")) {
			response.sendRedirect("index.jsp?action=false");
		}
		else {															//i.e error
			response.sendRedirect("index.jsp?action=error");
		}
	}

}

