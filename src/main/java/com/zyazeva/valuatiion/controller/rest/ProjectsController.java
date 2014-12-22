package com.zyazeva.valuatiion.controller.rest;

import com.zyazeva.SessionBean;
import com.zyazeva.SpringFactory;
import com.zyazeva.valuation.model.Project;
import com.zyazeva.valuation.model.User;
import com.zyazeva.valuation.service.ProjectService;
import com.zyazeva.valuation.service.UserService;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("projects")
public class ProjectsController {

    @GET
    @Path("create")
    @Produces("text/html")
    public Response create(@QueryParam("paramName") String name) {
        java.net.URI location = null;

        try {
            SessionBean sessionBean = (SessionBean) SpringFactory.getspringApplicationContext().getBean("sessionBean");
            User currentUser = sessionBean.getCurrentUser();

            Project project = new Project();
            project.setId(0);
            project.setName(name);
            project.setDate(new Date());
            project.setStatus("active");
            project.setUserId(currentUser.getId());

            ProjectService projectService = (ProjectService) SpringFactory.getspringApplicationContext().getBean("projectService");
            projectService.createProject(project);

            location = new java.net.URI("../projects-menu.jsp");

        } catch (URISyntaxException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Response.temporaryRedirect(location).build();
    }

}
