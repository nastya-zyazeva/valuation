package com.zyazeva.valuation.controller.rest;

import com.zyazeva.SessionBean;
import com.zyazeva.SpringFactory;
import com.zyazeva.valuation.model.Project;
import com.zyazeva.valuation.model.Stat;
import com.zyazeva.valuation.model.Task;
import com.zyazeva.valuation.model.User;
import com.zyazeva.valuation.service.ProjectService;
import com.zyazeva.valuation.service.StatService;
import com.zyazeva.valuation.service.TaskService;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("tasks")
public class TasksController {
    
 @GET
    @Path("create")
    @Produces("text/html")
    public Response create(@QueryParam("paramName") String name, @QueryParam("paramDescriprion") String description, @QueryParam("paramHours") Integer hours, @QueryParam("paramMen") Integer men, @QueryParam("paramBalance") Integer balance) {
        java.net.URI location = null;

        try {
            SessionBean sessionBean = (SessionBean) SpringFactory.getspringApplicationContext().getBean("sessionBean");
            User currentUser = sessionBean.getCurrentUser();
            Integer currentUserId = currentUser.getId();
            
            Task task = new Task();
            task.setId(0);
            task.setName(name);
            task.setDescription(description);
            task.setHours(hours);
            task.setMen(men);
            task.setBalance(balance);
            task.setUserId(currentUserId);
            
            TaskService taskService = (TaskService) SpringFactory.getspringApplicationContext().getBean("taskService");
            taskService.createTask(task);
            
            Stat stat = new Stat();
            stat.setId(0);
            stat.setDescription("User " + currentUser.getName() + " create a new task with id: " + task.getId());
            stat.setDate(new Date());
            
            StatService statService = (StatService) SpringFactory.getspringApplicationContext().getBean("statService");
            statService.createStat(stat);

            location = new java.net.URI("../tasks-menu.jsp");

        } catch (URISyntaxException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Response.temporaryRedirect(location).build();
    }
    
}
