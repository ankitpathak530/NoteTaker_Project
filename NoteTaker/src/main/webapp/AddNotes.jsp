<!doctype html>
<html lang="en">
  <head>
      <%@include file="All_js_css.jsp" %>
   
    <title>Add notes</title>
  </head>
  <body>
  
   <div class="container-fluid p-0 m-0">
      <%@include file="navbar.jsp" %>
   </div>
  
  
<div class="container">
    <h1>Add Note</h1>
  
   <!-- Form -->
    <form action="SaveNoteServlet" method="post">
	  <div class="form-group">
	    <label for="title">Note Title</label>
	    <input type="text" class="form-control" id="title" name="title" placeholder="Write short title." required>
	  </div>
	  <div class="form-group">
	    <label for="title">Note Content</label>
	    <textarea rows="5" cols="10" id="content" name="content" class="form-control" placeholder="Enter Content" required></textarea>
	  </div>
	  <div class="container text-center">
	      <button type="submit" class="btn btn-primary">Submit</button>
	  </div>
	 
  </form>
</div>
  
  </body>
</html>