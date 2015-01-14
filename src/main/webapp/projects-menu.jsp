<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.zyazeva.valuation.model.Project"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.zyazeva.valuation.service.ProjectService"%>
<%@page import="com.zyazeva.valuation.model.User"%>
<%@page import="com.zyazeva.SpringFactory"%>
<%@page import="com.zyazeva.SessionBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="resources/css/bootstrap.min.css">
        <script src="resources/js/bootstrap.min.js"></script>
        <link href="resources/css/valuation.css" rel="stylesheet">
        <title>Projects menu Page</title>
    </head>
    <body>
        <div class="container">
            <h3>Меню проектов</h3>
            <br>
            <h4>
                <span class="glyphicon glyphicon-user"></span>
                <%
                    SessionBean sessionBean = (SessionBean) SpringFactory.getspringApplicationContext().getBean("sessionBean");
                    User user = sessionBean.getCurrentUser();
                    String login = "";
                    if (user != null) {
                        login = user.getName();

                        String admin = user.getAdmin();
                        login += " (" + admin + ")";
                    }

                %>
                <%=login%>

            </h4>
            <br>


            <table class="table table-striped">
                <tr>
                    <th>Номер</th>
                    <th>Название</th>
                    <th>Дата</th>
                    <th>Статус</th>
                </tr>
                <%
                    ProjectService projectService = (ProjectService) SpringFactory.getspringApplicationContext().getBean("projectService");
                    List<Project> projectsList = new ArrayList<>();
                    projectsList = projectService.getAllProjects();
                    List<Project> currentUserProjectsList = new ArrayList<>();
                    
                    for (int i = 0; i < projectsList.size(); i++) {
                        Project project = projectsList.get(i);
                        if (project.getUserId() == user.getId()){
                            currentUserProjectsList.add(project);
                        }
                    }
                    

                    for (int i = 0; i < currentUserProjectsList.size(); i++) {
                        Project project = currentUserProjectsList.get(i);
                        if (project != null) {
                            out.write("<tr>");
                            int projectId = project.getId();
                            out.write("<td>" + projectId + "</td>");

                            String projectName = project.getName();
                            out.write("<td>" + projectName + "</td>");

                            Date projectDate = project.getDate();
                            if (projectDate != null) {
                                SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
                                String date = sdf.format(projectDate);
                                out.write("<td>" + date + "</td>");
                            }

                            String projectStatus = project.getStatus();
                            out.write("<td>" + projectStatus + "</td>");

                            out.write("</tr>");
                        }

                        out.write("");
                    }
                %>

            </table>
            <br>

            <table> 
                <tr>
                    <td>
                        <form action="projects-operations.jsp">
                            <button class="btn btn-info" type="submit">
                                <span class="glyphicon glyphicon-folder-close"></span> Действия над проектами
                            </button>
                        </form>
                    </td>
                    <td>
                        &nbsp
                    </td>
                    <td>
                        <form action="main-menu.jsp">
                            <button class="btn btn-info" type="submit">
                                <span class="glyphicon glyphicon-home"></span> Вернуться в главное меню
                            </button>
                        </form>
                    </td>
                </tr>
            </table>

        </div>
    </body>
</html>
