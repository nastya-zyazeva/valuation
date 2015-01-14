<%@page import="com.zyazeva.valuation.model.User"%>
<%@page import="com.zyazeva.SessionBean"%>
<%@page import="com.zyazeva.SessionBean"%>
<%@page import="com.zyazeva.SpringFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="resources/css/bootstrap.min.css">
        <script src="resources/js/bootstrap.min.js"></script>
        <link href="resources/css/valuation.css" rel="stylesheet">

        <title>Main menu Page</title>
    </head>
    <body>
        <div class="container">
            <h3>Система оценки стоимости ИТ проекта</h3>
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
                    <th>Описание</th>
                    <th>Меню</th>
                <tr>
                    <td>Проекты текущего пользователя</td>
                    <td>
                        <form action="projects-menu.jsp">
                            <button class="btn btn-info btn-block" type="submit">
                                <span class="glyphicon glyphicon-folder-close" aria-hidden="true"></span> Меню проектов
                            </button> 
                        </form>
                    </td>
                </tr>
                <tr>
                    <td>Задачи проектов текущего пользователя</td>
                    <td>
                        <form action="tasks-menu.jsp">
                            <button class="btn btn-info btn-block" type="submit">
                                <span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span> Меню задач
                            </button> 
                        </form>
                    </td>
                </tr>
                <tr>
                    <td>Назначения текущего пользователя</td>
                    <td>
                        <form action="links-menu.jsp">
                            <button class="btn btn-info btn-block" type="submit">
                                <span class="glyphicon glyphicon-link" aria-hidden="true"></span> Меню назначений
                            </button> 
                        </form>
                    </td>
                </tr>
                <tr>
                    <td>Общая статистика по работе системы</td>
                    <td>
                        <form action="stats-menu.jsp">
                            <button class="btn btn-info btn-block" type="submit">
                                <span class="glyphicon glyphicon-link" aria-hidden="true"></span> Меню статистики
                            </button> 
                        </form>
                    </td>
                </tr>                

                <%
                    if (user != null) {
                        if (user.getAdmin().equals("admin")) {
                            out.write("<tr>");
                            out.write("<td>Пользователи системы</td>");
                            out.write("<td>");
                            out.write("<form action=\"user-menu.jsp\">");
                            out.write("<button class=\"btn btn-warning btn-block\">");
                            out.write("<span class=\"glyphicon glyphicon-user\" aria-hidden=\"true\"></span> Меню пользователей");
                            out.write("</button>");
                            out.write("</form>");
                            out.write("</td>");
                            out.write("</tr>");
                        }
                    }
                %>

            </table>

            <form class="form-signin" method="GET" action="/valuation/webresources/logout">
                <button class="btn btn-info" type="submit">
                    <span class="glyphicon glyphicon-off"></span> Выход
                </button>
            </form>
        </div>

    </body>
</html>
