package com.zyazeva.valuation.test;

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
import com.zyazeva.valuation.service.UserService;
import java.util.Date;
import static org.junit.Assert.fail;

import org.junit.Test;

public class AppTest {

    @Test
    public void testUsers() {
        System.out.println("Working Directory = "
                + System.getProperty("user.dir"));

        // User service test!
        System.out.println("User service test.");

        UserService userService = (UserService) SpringFactory.getspringApplicationContext().getBean("userService");

        User user = new User();
        user.setId(0);
        user.setLogin("hibernateUser");
        String userName = "Hibernate test user";
        user.setName(userName);
        user.setPassword("hibernate");
        user.setRegistrationDate(new Date());

        userService.createUser(user);
        int userId = user.getId();
        System.out.println("create user done. User id: " + userId);

        user = userService.readUser(userId);
        if (!user.getName().equals(userName)) {
            fail("User name from create and read operations are not equals!!!");
        } else {
            System.out.println("Read user done!");
        }

        userName = "new Name";
        user.setName(userName);
        userService.updateUser(user);
        userId = user.getId();
        user = userService.readUser(userId);
        if (!user.getName().equals(userName)) {
            fail("User name from update and read operations are not equals!!!");
        } else {
            System.out.println("Update user done!");
        }

        String userLogin = user.getLogin();
        User tempUser = userService.getUserByLogin(userLogin);
        System.out.println("Test userService.getUserByLogin: " + tempUser.getName());

        userService.deleteUser(user);
        System.out.println("Delete user done!");

        // Project service test. -----------------------------------------------       
        System.out.println("Project service test.");
        ProjectService projectService = (ProjectService) SpringFactory.getspringApplicationContext().getBean("projectService");
        Project project = new Project();
        project.setId(0);
        project.setName("Project site for caffee");
        project.setStatus("active");

        projectService.createProject(project);
        System.out.println("create project done. Project id: " + project.getId());

        projectService.deleteProject(project);
        System.out.println("Delete project done!");

        // Task service test. -----------------------------------------------       
        System.out.println("Task service test.");
        TaskService taskService = (TaskService) SpringFactory.getspringApplicationContext().getBean("taskService");
        Task task = new Task();
        task.setId(0);
        task.setName("Early development");
        task.setDescription("Begining of the project development.");
        task.setHours(100);
        task.setMen(3);
        task.setBalance(30000);
        task.setUserId(0);

        taskService.createTask(task);
        System.out.println("Create task done. Task id: " + task.getId());

        taskService.deleteTask(task);
        System.out.println("Delete task done!");
        
        // Link service test. -----------------------------------------------       
        System.out.println("Link service test.");
        LinkService linkService = (LinkService) SpringFactory.getspringApplicationContext().getBean("linkService");
        Link link = new Link();
        link.setId(0);
        link.setProjectId(0);
        link.setTaskId(0);
        link.setUserId(0);
        

        linkService.createLink(link);
        System.out.println("Create link done. Link id: " + project.getId());

        linkService.deleteLink(link);
        System.out.println("Delete task done!");
        
        // Stat service test. -----------------------------------------------       
        System.out.println("Link service test.");
        StatService statService = (StatService) SpringFactory.getspringApplicationContext().getBean("statService");
        Stat stat = new Stat();
        stat.setId(0);
        stat.setDate(new Date());
        stat.setDescription("First stat record!");

        statService.createStat(stat);
        System.out.println("Create stat done. Stat id: " + stat.getId());

        statService.deleteStat(stat);
        System.out.println("Delete stat done!");
        
    }
}
