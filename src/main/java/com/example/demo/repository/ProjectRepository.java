package com.example.demo.repository;

import java.sql.Date;    
//import java.time.LocalDate;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    long countBy();  // Total projects count

    long countByStatus(String status);  // Count projects by status (e.g., Closed, Running, Cancelled)
    
    // Custom query methods
    @Query("SELECT COUNT(p) FROM Project p")
    long countTotalProjects();

    @Query("SELECT COUNT(p) FROM Project p WHERE p.status = 'Closed'")
    long countClosedProjects();

    @Query("SELECT COUNT(p) FROM Project p WHERE p.status = 'Running'")
    long countRunningProjects();

    @Query("SELECT COUNT(p) FROM Project p WHERE p.status = 'Cancelled'")
    long countCancelledProjects();
    
//    @Query("SELECT COUNT(p) FROM Project p WHERE p.status = :status AND p.endDate < :currentDate")
//    long countByStatusAndEndDateBefore(@Param("status") String status, @Param("currentDate") LocalDate currentDate);
    
    @Query("SELECT COUNT(p) FROM Project p WHERE p.status = :status AND p.endDate < :currentDate")
    long countByStatusAndEndDateBefore(@Param("status") String status, @Param("currentDate") java.util.Date date);
    
    @Query("SELECT COUNT(p) FROM Project p WHERE p.status = :status AND p.endDate < :currentDate")
    int countByStatusAndEndDateBefore(String status, LocalDate currentDate);
    
    @Query("SELECT p.dept, COUNT(p) FROM Project p GROUP BY p.dept")
    List<Object[]> countTotalProjectsByDepartment();

    @Query("SELECT p.dept, COUNT(p) FROM Project p WHERE p.status = 'Closed' GROUP BY p.dept")
    List<Object[]> countClosedProjectsByDepartment();
    
    long countByStatusAndEndDateBefore(String status, Date endDate);

}






//import com.example.demo.entity.Project;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface ProjectRepository extends JpaRepository<Project, Long> {
//
//    @Query("SELECT COUNT(p) FROM Project p")
//    long getTotalProjectsCount();
//
//    @Query("SELECT COUNT(p) FROM Project p WHERE p.status = 'Closed'")
//    long getClosedProjectsCount();
//
//    @Query("SELECT COUNT(p) FROM Project p WHERE p.status = 'Running'")
//    long getRunningProjectsCount();
//
//    @Query("SELECT COUNT(p) FROM Project p WHERE p.status = 'Running' AND p.endDate < CURRENT_DATE")
//    long getRunningProjectsWithEndDateBeforeTodayCount();
//
//    @Query("SELECT COUNT(p) FROM Project p WHERE p.status = 'Cancelled'")
//    long getCancelledProjectsCount();
//
//}





//package com.example.demo.repository;
//
//import com.example.demo.entity.Project;      
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface ProjectRepository extends JpaRepository<Project, Long> {
//}
