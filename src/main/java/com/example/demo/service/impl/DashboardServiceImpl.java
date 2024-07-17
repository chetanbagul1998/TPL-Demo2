package com.example.demo.service.impl;

//import com.example.demo.dto.DashboardChartData;  


import com.example.demo.model.CounterResponse; 
import com.example.demo.repository.ProjectRepository;
import com.example.demo.service.DashboardService;

import java.time.LocalDate;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public CounterResponse getCounters() {
        int totalProjects = (int) projectRepository.countBy();
        int closedProjects = (int) projectRepository.countByStatus("Closed");                    // calculate other counters as needed
        int runningProjects = (int) projectRepository.countByStatus("Running");
        int cancelledProjects = (int) projectRepository.countByStatus("Cancelled");

        

        return new CounterResponse(totalProjects, closedProjects, runningProjects, cancelledProjects);
    }
    
    @Override
    public int getClosureDelayCounter() {
        LocalDate currentDate = LocalDate.now();
        return projectRepository.countByStatusAndEndDateBefore("Running", currentDate);
    }

//    @Override
//    public int getClosureDelayCounter() {
//        // Implement logic to fetch closure delay counter if needed
//        return 0; // Placeholder; replace with actual implementation
//    }
    
    
}

