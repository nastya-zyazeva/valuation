package com.zyazeva.valuation.controller.rest;

import com.zyazeva.SessionBean;
import com.zyazeva.SpringFactory;
import com.zyazeva.valuation.model.Link;
import com.zyazeva.valuation.model.Project;
import com.zyazeva.valuation.model.Stat;
import com.zyazeva.valuation.model.Task;
import com.zyazeva.valuation.model.User;
import com.zyazeva.valuation.service.LinkService;
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

@Path("links")
public class LinksController {

    @GET
    @Path("create")
    @Produces("text/html")
    public Response create(@QueryParam("paramProjectName") String projectName, @QueryParam("paramTaskName") String taskName) {
        java.net.URI location = null;

        try {
            SessionBean sessionBean = (SessionBean) SpringFactory.getspringApplicationContext().getBean("sessionBean");
            User currentUser = sessionBean.getCurrentUser();
            Integer currentUserId = currentUser.getId();

            Link link = new Link();
            link.setId(0);

            ProjectService projectService = (ProjectService) SpringFactory.getspringApplicationContext().getBean("projectService");
            Project project = projectService.getProjectByName(projectName);
            if (project != null){
                link.setProjectId(project.getId());
            }

            TaskService taskService = (TaskService) SpringFactory.getspringApplicationContext().getBean("taskService");
            Task task = taskService.getTasktByName(taskName);
            if (task != null){
                link.setTaskId(task.getId());
            }

            link.setUserId(currentUserId);

            LinkService linkService = (LinkService) SpringFactory.getspringApplicationContext().getBean("linkService");
            linkService.createLink(link);
            
            Stat stat = new Stat();
            stat.setId(0);
            stat.setDescription("User " + currentUser.getName() + " create a new link with id: " + link.getId());
            stat.setDate(new Date());
            
            StatService statService = (StatService) SpringFactory.getspringApplicationContext().getBean("statService");
            statService.createStat(stat);

            location = new java.net.URI("../links-menu.jsp");

        } catch (URISyntaxException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Response.temporaryRedirect(location).build();
    }

}
