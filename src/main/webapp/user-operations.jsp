<%@page import="com.zyazeva.valuation.model.User"%>
<%@page import="com.zyazeva.SpringFactory"%>
<%@page import="com.zyazeva.SessionBean"%>
<%@page import="com.zyazeva.SessionBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="resources/css/bootstrap.min.css">
        <script src="resources/js/bootstrap.min.js"></script>
        <link href="resources/css/valuation.css" rel="stylesheet">

        <title>Users operations page</title>
    </head>
    <body>
        <div class="container">
            <h3>Меню операций с пользователями</h3>
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
            <form class="form-signin" method="GET" action="/valuation/webresources/users/create">
            <input name = "paramLogin" type="text" id="login" class="form-control" placeholder="логин">   
            <br>
            <input name = "paramName" type="text" id="name" class="form-control" placeholder="имя">                          
            <br>
            <input name = "paramPassword" type="text" id="password" class="form-control" placeholder="пароль">
            <br>
            <input name = "paramRole" type="text" id="role" class="form-control" placeholder="роль">
            <br>
            <br>
            
            <table>
                <tr>
                    <td>
                        
                            <button class="btn btn-info" type="submit">
                                <span class="glyphicon glyphicon-user"></span> Создать нового пользователя
                            </button>
                        </form>
                    </td>
                    <td>
                        &nbsp
                    </td>

                    <td>
                        <form action="user-menu.jsp">
                            <button class="btn btn-info">
                                <span class="glyphicon glyphicon-user"></span> В меню пользователей
                            </button>
                            </form>
                    </td>
                </tr>
            </table>    

        </form>
    </div>
</body>
</html>
