package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transaction;

import org.hibernate.Session;

import com.entities.Note;

import helper.FactoryProvider;

public class SaveNoteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public SaveNoteServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out = response.getWriter();
		
		System.out.println("this is do post..");
		try {
			
			 String title = request.getParameter("title");
			 String content = request.getParameter("content"); 
			 Note note = new Note(title,content,new Date());
			
			 
			 Session session = FactoryProvider.getFactory().openSession();
			 session.save(note);			  
			 
			
			 session.beginTransaction().commit();
			 
			 out.println("<h1 style='text-align:center;'> Notes Added Successfuly</h1>");
			 out.println("<h1 style='text-align:center;'><a href='ViewNotes.jsp'>View Notes</a></h1>");
			
			 response.setContentType("text/html");
			 
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
