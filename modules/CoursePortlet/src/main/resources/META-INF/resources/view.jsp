<%@ include file="/init.jsp" %>
<%@ page import="java.io.*,java.util.*" %>
<% List<Course> courses=(List<Course>)renderRequest.getAttribute("courses");  %>
<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>


<liferay-portlet:renderURL var="newURL">
    <liferay-portlet:param name="mvcRenderCommandName" value="<%= ConstantsCommands.NEW_COURSE %>"/>
    <liferay-portlet:param name="backURL" value="<%=currentURL %>"/>
</liferay-portlet:renderURL>

<portlet:resourceURL id="cambiarCurso" var="cambiarCursoURL"/>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Course Portlet </title>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>

<script>
$(document).ready(function(){
setInterval(function(){
      $("#here").load(window.location.href + " #here" );
}, 1000);
});
</script>


<script>
$(document).ready(function(){
	$("#cambioBtn").click(function(){
		$.get("<%=cambiarCursoURL%>",function(data,status){
			var name= data._name;
			var desc= data._description;
			console.log(data)
			$("#name").text(name);
			$("#descp").text(desc);
		},"json");

	});
});
</script>

</head>

<body>
<p id="cambioBtn"> Cambiar al CursoID 2 </p>
<div class="prueba">
    <aui:form>
	    <b><liferay-ui:message key="course.caption"/></b>
	    <h2>LISTA DE LOS CURSOS éééé &Agrave; &Agrave; haber si aparece estos</h2>
	    <h3>Este portlet es un crud de cursos que he creado, esta codificado por utf-8 eso quiere decir que podemos
	    escribir tíldes y otros idiogramas sin tener problemas de mostración. </h3>
        <aui:button type="Nuevo Curso" name="" value="Nuevo Curso" href="<%= newURL %>" ></aui:button>

        <h2 id="name">Curso name </h2>
        <h2 id="descp">Descripción curso </h2>

        <table>
            <tr>
                <th>Nombre</th>
                <th>Descripción</th>
                <th>Action</th>
            </tr>
       <tbody>
       <%for(Course course:courses){ %>
            <tr>
                <td><%= course.getName() %> </td>
                <td><%= course.getDescription() %></td>
                <td>
                     <liferay-portlet:renderURL var="editURL">
                        <liferay-portlet:param name="mvcRenderCommandName" value="<%=ConstantsCommands.EDIT_COURSE %>"/>
                        <liferay-portlet:param name="backURL" value="<%= currentURL %>"/>
                        <liferay-portlet:param name="courseId" value="<%= String.valueOf(course.getCourseId()) %>"/>
                     </liferay-portlet:renderURL>

                     <liferay-portlet:actionURL var="deleteURL" name="<%=ConstantsCommands.DELETE_COURSE %>">
                        <liferay-portlet:param name="backURL" value="<%= currentURL %>"/>
                        <liferay-portlet:param name="courseId" value="<%= String.valueOf(course.getCourseId()) %>"/>
                     </liferay-portlet:actionURL>

                     <aui:button type="Edit" name="" value="Edit" href="${editURL }" ></aui:button>
                     <aui:button type="Delete" name="" value="Delete" href="${deleteURL }" ></aui:button>
                </td>
            </tr>
       <%} %>
       </tbody>
      </table>
</aui:form>
</div>

<div id="here">
<h2>Actualiza el tiempo por el mismo mediante Java</h2>
<%
   //response.setIntHeader("Refresh", 1);
   // get current Time
   Calendar calendar = new GregorianCalendar();
   String am_pm;
   int hour = calendar.get(Calendar.HOUR);
   int minute = calendar.get(Calendar.MINUTE);
   int second = calendar.get(Calendar.SECOND);
   if(calendar.get(Calendar.AM_PM) == 0)
      am_pm = "AM";
   else
      am_pm = "PM";
   String CT = hour+":"+ minute +":"+ second +" "+ am_pm;
   out.println("Time: " + CT + "\n");
%>
</div>

</body>
</html>


