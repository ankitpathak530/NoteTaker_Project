<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.Query" %>
<%@page import="helper.FactoryProvider" %>
<%@page import="com.entities.Note" %>
<%@page import="java.util.List" %>


<!doctype html>
<html lang="en">
<head>
      <%@include file="All_js_css.jsp" %>
   
      <title>View notes</title>
</head>
<body>
  
   <div class="container-fluid p-0 m-0">
      <%@include file="navbar.jsp" %>
   </div>
  
  
	<div class="container">
	    <h1>All Notes</h1>
	</div>
	
   <div class="row">  
   <div class="col-12">
	<% 
	   Session session1 = FactoryProvider.getFactory().openSession();
	
	   Query q = session1.createQuery("from Note");
	   List<Note> list = q.list();
	   
	   for(Note n:list){
		  %>
		  
	    
		  <div class="card mt-3 ml-5">	
		  <img class="card-img-top mx-auto mt-2" style="max-width:100px" src="Image/notes.png">
			  <div class="card-body">
			    <p class="card-title" style="font-weight:bolder;"><%= n.getTitle() %></p>
			    <p class="card-text"  style="font-variant:small-caps;"><%= n.getContent() %></p>
			    
			    <div class="text-center">
			           
			        <form action="UpdateNoteServlet" method="post">
			           <input  name="note_id" value="<%= n.getId() %>" type="hidden">
			           <button  class="btn text-white btn-primary">Update</button>
			       </form>
			       <form action="DeleteNoteServlet" method="post">
			           <input  name="note_id" value="<%= n.getId() %>" type="hidden">
			           <button class="btn text-white bg-danger">Delete</button>
			       </form>
			       
			       
			    </div>
			  </div>
			</div>
	
		  <%
	   }
	   
	   
	   session1.close();
	%>  
  </div>
  </div>
</body>
</html>