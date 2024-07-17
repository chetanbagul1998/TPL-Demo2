
package com.example.demo.service;

//import java.time.LocalDate;    
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DashboardChartData;
import com.example.demo.dto.DashboardCounters;
import com.example.demo.dto.DashboardData;
import com.example.demo.entity.Project;
import com.example.demo.repository.ProjectRepository;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
//    added
    public DashboardCounters getDashboardCounters() {
        long totalProjects = projectRepository.count();
        long closedProjects = projectRepository.countByStatus("Closed");
        long runningProjects = projectRepository.countByStatus("Running");
        long cancelledProjects = projectRepository.countByStatus("Cancelled");

        // Example logic for closure delay
//          long closureDelay = projectRepository.countByStatusAndEndDateBefore("Running", LocalDate.now());
        long closureDelay = projectRepository.countByStatusAndEndDateBefore("Running", new Date());


        return new DashboardCounters(totalProjects, closedProjects, runningProjects, closureDelay, cancelledProjects);
    }
//    public DashboardCounters getDashboardCounters() {
//        long totalProjects = projectRepository.countBy();
//        long closedProjects = projectRepository.countByStatus("Closed");
//        long runningProjects = projectRepository.countByStatus("Running");
//        long cancelledProjects = projectRepository.countByStatus("Cancelled");
//
//        // Example logic for closure delay
//        long closureDelay = projectRepository.countByStatusAndEndDateBefore("Running", LocalDate.now());
//
//        return new DashboardCounters(totalProjects, closedProjects, runningProjects, closureDelay, cancelledProjects);
//    }

    public DashboardData getDashboardData() {
        long totalProjects = projectRepository.countBy();
        long closedProjects = projectRepository.countByStatus("Closed");
        long runningProjects = projectRepository.countByStatus("Running");
        long cancelledProjects = projectRepository.countByStatus("Cancelled");

        return new DashboardData(totalProjects, closedProjects, runningProjects, cancelledProjects);
    }
    
 // Method to fetch chart data 
    public static DashboardChartData getDashboardChartData() {
        int[] totalData = {15, 7, 9, 15, 5, 10}; // Example data, replace with  logic
        int[] closedData = {14, 6, 8, 15, 5, 9}; // Example data, replace with  logic

        return new DashboardChartData(totalData, closedData);
    }

    public long getTotalProjectsCount() {
        return projectRepository.countTotalProjects();
    }

    public long getClosedProjectsCount() {
        return projectRepository.countClosedProjects();
    }

    public long getRunningProjectsCount() {
        return projectRepository.countRunningProjects();
    }

    public long getCancelledProjectsCount() {
        return projectRepository.countCancelledProjects();
    }
    
    public Project updateProjectStatus(Long projectId, String status) {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new RuntimeException("Project not found"));
        project.setStatus(status);
        return projectRepository.save(project);
    }
}








//package com.example.demo.service;
//
//import com.example.demo.dto.DashboardData;  
//import com.example.demo.entity.Project;
//import com.example.demo.repository.ProjectRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ProjectService {
//
//    @Autowired
//    private ProjectRepository projectRepository;
//
//    public Project saveProject(Project project) {
//        return projectRepository.save(project);
//    }
//
//    public List<Project> getAllProjects() {
//        return projectRepository.findAll();
//    }
//
//    public Project getProjectById(Long id) {
//        return projectRepository.findById(id).orElse(null);
//    }
//
//    public void deleteProject(Long id) {
//        projectRepository.deleteById(id);
//    }
//
//    public DashboardData getDashboardData() {
//        List<Project> projects = projectRepository.findAll();
//        int totalProjects = projects.size();
//        int completedProjects = (int) projects.stream().filter(p -> p.getStatus().equalsIgnoreCase("completed")).count();
//        int ongoingProjects = (int) projects.stream().filter(p -> p.getStatus().equalsIgnoreCase("ongoing")).count();
//        int pendingProjects = (int) projects.stream().filter(p -> p.getStatus().equalsIgnoreCase("pending")).count();
//
//        return new DashboardData(totalProjects, completedProjects, ongoingProjects, pendingProjects);
//    }
//}






//package com.example.demo.service;
//
//import com.example.demo.entity.Project;
//import com.example.demo.repository.ProjectRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ProjectService {
//
//    @Autowired
//    private ProjectRepository projectRepository;
//
//    public long getTotalProjectsCount() {
//        return projectRepository.getTotalProjectsCount();
//    }
//
//    public long getClosedProjectsCount() {
//        return projectRepository.getClosedProjectsCount();
//    }
//
//    public long getRunningProjectsCount() {
//        return projectRepository.getRunningProjectsCount();
//    }
//
//    public long getRunningProjectsWithEndDateBeforeTodayCount() {
//        return projectRepository.getRunningProjectsWithEndDateBeforeTodayCount();
//    }
//
//    public long getCancelledProjectsCount() {
//        return projectRepository.getCancelledProjectsCount();
//    }
//}














//import com.example.demo.dto.DashboardData;
//import com.example.demo.entity.Project;
//import com.example.demo.repository.ProjectRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.logging.Logger;
//
//@Service
//public class ProjectService {
//
//    private static final Logger LOGGER = Logger.getLogger(ProjectService.class.getName());
//
//    @Autowired
//    private ProjectRepository projectRepository;
//
//    public Project saveProject(Project project) {
//        LOGGER.info("Saving project: " + project.getProject_name());
//        return projectRepository.save(project);
//    }
//
//    public List<Project> getAllProjects() {
//        return projectRepository.findAll();
//    }
//
//    public Project getProjectById(Long id) {
//        return projectRepository.findById(id).orElse(null);
//    }
//
//    public void deleteProject(Long id) {
//        projectRepository.deleteById(id);
//    }
//
//    public DashboardData getDashboardData() {
//        List<Project> projects = projectRepository.findAll();
//        int totalProjects = projects.size();
//        int completedProjects = (int) projects.stream().filter(p -> "completed".equalsIgnoreCase(p.getStatus())).count();
//        int ongoingProjects = (int) projects.stream().filter(p -> "ongoing".equalsIgnoreCase(p.getStatus())).count();
//        int pendingProjects = (int) projects.stream().filter(p -> "pending".equalsIgnoreCase(p.getStatus())).count();
//
//        return new DashboardData(totalProjects, completedProjects, ongoingProjects, pendingProjects);
//    }
//}








//package com.example.demo.service;
//
//import com.example.demo.entity.Project;  
//import com.example.demo.repository.ProjectRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ProjectService {
//
//    @Autowired
//    private ProjectRepository projectRepository;
//
//    public Project saveProject(Project project) {
//        return projectRepository.save(project);
//    }
//
//    public List<Project> getAllProjects() {
//        return projectRepository.findAll();
//    }
//
//    public Project getProjectById(Long id) {
//        return projectRepository.findById(id).orElse(null);
//    }
//
//    public void deleteProject(Long id) {
//        projectRepository.deleteById(id);
//    }
//
//    // Implement this method based on your dashboard data requirements
//    public DashboardData getDashboardData() {
//        // Your logic to retrieve dashboard data
//    }
//}




//package com.example.demo.service;
//
//import com.example.demo.entity.Project;  
//import com.example.demo.repository.ProjectRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ProjectService {
//
//    @Autowired
//    private ProjectRepository projectRepository;
//
//    public Project saveProject(Project project) {
//        return projectRepository.save(project);
//    }
//
//    public List<Project> getAllProjects() {
//        return projectRepository.findAll();
//    }
//
//    public Project getProjectById(Long id) {
//        return projectRepository.findById(id).orElse(null);
//    }
//
//    public void deleteProject(Long id) {
//        projectRepository.deleteById(id);
//    }
//}
