package com.zyazeva.valuation.service;

import com.zyazeva.valuation.model.Project;
import java.util.List;


public interface ProjectService {
    
    void createProject(Project project);
    Project readProject(int projectId);
    void updateProject(Project project);
    void deleteProject(Project project);
    
    List getAllProjects();
    
}
