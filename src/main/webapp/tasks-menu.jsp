<%@page import="java.util.ArrayList"%>
<%@page import="com.zyazeva.valuation.model.Task"%>
<%@page import="java.util.List"%>
<%@page import="com.zyazeva.valuation.service.TaskService"%>
<%@page import="com.zyazeva.SpringFactory"%>
<%@page import="com.zyazeva.valuation.model.User"%>
<%@page import="com.zyazeva.SessionBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="resources/css/bootstrap.min.css">
        <script src="resources/js/bootstrap.min.js"></script>
        <link href="resources/css/valuation.css" rel="stylesheet">
        <title>Tasks menu Page</title>
    </head>
    <body>
        <div class="container">
            <h3>Меню задач для проектов</h3>
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
                    <th>Описание</th>
                    <th>Часы</th>
                    <th>Люди</th>
                    <th>Баланс</th>
                </tr>
                <%
                    TaskService taskService = (TaskService) SpringFactory.getspringApplicationContext().getBean("taskService");
                    List<Task> tasksList = new ArrayList<>();
                    tasksList = taskService.getAllTasks();
                    List<Task> currentUserTasksList = new ArrayList<>();

                    for (int i = 0; i < tasksList.size(); i++) {
                        Task task = tasksList.get(i);
                        if (task.getUserId() == user.getId()) {
                            currentUserTasksList.add(task);
                        }
                    }

                    for (int i = 0; i < currentUserTasksList.size(); i++) {
                        Task task = currentUserTasksList.get(i);
                        if (task != null) {
                            out.write("<tr>");
                            int taskId = task.getId();
                            out.write("<td>" + taskId + "</td>");

                            String taskName = task.getName();
                            out.write("<td>" + taskName + "</td>");
                            
                            String taskDescription = task.getDescription();
                            out.write("<td>" + taskDescription + "</td>");

                            String taskHours = task.getHours() + "";
                            out.write("<td>" + taskHours + "</td>");
                            
                            String taskMen = task.getMen() + "";
                            out.write("<td>" + taskMen + "</td>");
                            
                            String taskBalance = task.getBalance() + "";
                            out.write("<td>" + taskBalance + "</td>");                            

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
                        <form action="tasks-operations.jsp">
                            <button class="btn btn-info" type="submit">
                                <span class="glyphicon glyphicon-briefcase"></span> Действия над задачами
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
