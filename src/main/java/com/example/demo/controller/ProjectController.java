package com.example.demo.controller;
import com.example.demo.dto.DashboardCounters;   
import com.example.demo.dto.DashboardData;    
import com.example.demo.entity.Project;
import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//
import java.util.List;
////@CrossOrigin(origins = "*")
////@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

//    added
    @PostMapping("/projects")
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        Project createdProject = projectService.saveProject(project);
        return new ResponseEntity<Project>(createdProject, HttpStatus.CREATED);
    }

   
    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getProjects() {
        List<Project> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/dashboard")
    public ResponseEntity<DashboardData> getDashboardData() {
        DashboardData data = projectService.getDashboardData();
        return ResponseEntity.ok(data);
    }
    
    @GetMapping("/counters")
    public DashboardCounters getDashboardCounters() {
        return projectService.getDashboardCounters();
    }
    
    @PutMapping("/projects/{id}")
    public ResponseEntity<Project> updateProjectStatus(@PathVariable Long id, @RequestBody Project project) {
        Project updatedProject = projectService.updateProjectStatus(id, project.getStatus());
        return ResponseEntity.ok(updatedProject);
    }
}








//package com.example.demo.controller; 
////
//package com.example.demo.controller;
//
//import com.example.demo.dto.DashboardCounters;
//import com.example.demo.service.ProjectService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api")
//public class ProjectController {
//
//    @Autowired
//    private ProjectService projectService;
//
//    @GetMapping("/dashboard/counters")
//    public ResponseEntity<DashboardCounters> getDashboardCounters() {
//        long totalProjects = projectService.getTotalProjectsCount();
//        long closedProjects = projectService.getClosedProjectsCount();
//        long runningProjects = projectService.getRunningProjectsCount();
//        long runningProjectsWithEndDateBeforeToday = projectService.getRunningProjectsWithEndDateBeforeTodayCount();
//        long cancelledProjects = projectService.getCancelledProjectsCount();
//
//        DashboardCounters counters = new DashboardCounters(totalProjects, closedProjects, runningProjects,
//                runningProjectsWithEndDateBeforeToday, cancelledProjects);
//
//        return ResponseEntity.ok(counters);
//    }
//}













//package com.example.demo.controller;
//
//import com.example.demo.dto.DashboardData;
//import com.example.demo.entity.Project;
//import com.example.demo.service.ProjectService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class ProjectController {
//
//    @Autowired
//    private ProjectService projectService;
//
//    @PostMapping("/projects")
//    public ResponseEntity<Project> createProject(@RequestBody Project project) {
//        Project savedProject = projectService.saveProject(project);
//        return ResponseEntity.ok(savedProject);
//    }
//
//    @GetMapping("/projects")
//    public ResponseEntity<List<Project>> getProjects() {
//        List<Project> projects = projectService.getAllProjects();
//        return ResponseEntity.ok(projects);
//    }
//
//    @GetMapping("/dashboard")
//    public ResponseEntity<DashboardData> getDashboardData() {
//        DashboardData data = projectService.getDashboardData();
//        return ResponseEntity.ok(data);
//    }
//}








//import com.example.demo.dto.DashboardData;
//import com.example.demo.entity.Project;
//import com.example.demo.service.ProjectService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/projects")
//public class ProjectController {
//
//    @Autowired
//    private ProjectService projectService;
//
//    @GetMapping
//    public List<Project> getAllProjects() {
//        return projectService.getAllProjects();
//    }
//
//    @PostMapping
//    public ResponseEntity<Project> createProject(@RequestBody Project project) {
//        Project createdProject = projectService.createProject(project);
//        return ResponseEntity.ok(createdProject);
//    }
//
//    @PutMapping("/{id}/start")
//    public ResponseEntity<Project> startProject(@PathVariable Long id) {
//        Project startedProject = projectService.updateProjectStatus(id, "Running");
//        return ResponseEntity.ok(startedProject);
//    }
//
//    // Add similar mappings for other status updates (close, cancel)
//
//    // Other methods for updating, deleting, etc.
//}








//package com.example.demo.controller;
//
//import com.example.demo.entity.Project;
//import com.example.demo.service.ProjectService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class ProjectController {
//
//    @Autowired
//    private ProjectService projectService;
//
//    @PostMapping("/projects")
//    public ResponseEntity<Project> createProject(@RequestBody Project project) {
//        Project savedProject = projectService.saveProject(project);
//        return ResponseEntity.ok(savedProject);
//    }
//
//    @GetMapping("/projects")
//    public ResponseEntity<List<Project>> getProjects() {
//        List<Project> projects = projectService.getAllProjects();
//        return ResponseEntity.ok(projects);
//    }
//
//    @GetMapping("/dashboard")
//    public ResponseEntity<DashboardData> getDashboardData() {
//        DashboardData data = projectService.getDashboardData();
//        return ResponseEntity.ok(data);
//    }
//}


//package com.example.demo.controller;
//
//import com.example.demo.entity.Project;  
//import com.example.demo.service.ProjectService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/projects")
//public class ProjectController {
//
//    @Autowired
//    private ProjectService projectService;
//
//    @PostMapping
//    public ResponseEntity<Project> createProject(@RequestBody Project project) {
//        Project savedProject = projectService.saveProject(project);
//        return ResponseEntity.ok(savedProject);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Project>> getAllProjects() {
//        List<Project> projects = projectService.getAllProjects();
//        return ResponseEntity.ok(projects);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
//        Project project = projectService.getProjectById(id);
//        if (project != null) {
//            return ResponseEntity.ok(project);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
//        projectService.deleteProject(id);
//        return ResponseEntity.noContent().build();
//    }
//}
