package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.entities.Note;

import helper.FactoryProvider;

/**
 * Servlet implementation class DeleteNoteServlet
 */
public class DeleteNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("This is doGet method stub");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("This is doPost method stub od delte");
		int noteId = Integer.parseInt(request.getParameter("note_id").trim());
		
		Session session = FactoryProvider.getFactory().openSession();
		
		Note note = session.get(Note.class,noteId);
		session.delete(note);
		session.beginTransaction().commit();
		session.close();
		response.sendRedirect("ViewNotes.jsp");
	}

}
