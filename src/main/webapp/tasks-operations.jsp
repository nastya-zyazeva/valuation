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

        <title>Tasks operations page</title>
    </head>
    <body>
        <div class="container">
            <h3>Меню действий над задачами</h3>
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
            <form class="form-signin" method="GET" action="/valuation/webresources/tasks/create">
                <input name = "paramName" type="text" id="login" class="form-control" placeholder="название">
                <input name = "paramDescriprion" type="text" id="login" class="form-control" placeholder="описание">
                <input name = "paramHours" type="text" id="login" class="form-control" placeholder="часы">
                <input name = "paramMen" type="text" id="login" class="form-control" placeholder="люди">
                <input name = "paramBalance" type="text" id="login" class="form-control" placeholder="баланс">                
                <br>          

                <table>
                    <tr>
                        <td>

                            <button class="btn btn-info" type="submit">
                                <span class="glyphicon glyphicon-plus"></span> Создать новую задачу
                            </button>
                            </form>
                        </td>
                        <td>
                            &nbsp
                        </td>

                        <td>
                            <form action="projects-menu.jsp">
                                <button class="btn btn-info">
                                    <span class="glyphicon glyphicon-briefcase"></span> Вернуться в меню задач
                                </button>
                            </form>
                        </td>
                    </tr>
                </table>    

            </form>
        </div>
    </body>
</html>
