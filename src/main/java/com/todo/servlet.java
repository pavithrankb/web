package com.todo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class servlet
 */
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      connectDB c=new connectDB();
  



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  response.setContentType("text/html");
		PrintWriter out = null;
      
        RequestDispatcher rd = request.getRequestDispatcher("todolist.html");
        rd.include(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  response.setContentType("text/html");
		PrintWriter out= null;
        out=response.getWriter();
        String x=request.getParameter("todo");
        String y=request.getParameter("btn");
        if(y.equals("add")) {
        	c.additem(x);
        	ResultSet rs=c.viewlist();
        	try {
				while(rs.next()) {
					out.println("<h4>"+rs.getString(1)+"</h4>");
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	
        }
        else if(y.equals("remove")){
        	
        	c.removeitem(x);
        	ResultSet rs=c.viewlist();
        	try {
				while(rs.next()) {
					out.println("<h4>"+rs.getString(1)+"</h4>");
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        }
        else {
        	ResultSet rs=c.viewlist();
        	try {
				while(rs.next()) {
					out.println("<h4>"+rs.getString(1)+"</h4>");
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        }
        
     
    	
        out.println("go to main page <a href=todolist.html> clickhere </a>");
        
        
		
	}

}
