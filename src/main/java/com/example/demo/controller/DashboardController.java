package com.example.demo.controller;

import com.example.demo.dto.DashboardChartData; 
import com.example.demo.dto.DashboardCounters;
//import com.example.demo.model.CounterResponse; 
//import com.example.demo.service.DashboardService;
import com.example.demo.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
//    private DashboardService dashboardService;
    private ProjectService projectService;
    
    @GetMapping("/counters")
    public DashboardCounters getDashboardCounters() {
        return projectService.getDashboardCounters();
    }

//    @GetMapping("/counters")
//    public CounterResponse getCounters() {
//        return dashboardService.getCounters();
//    }

//    @GetMapping("/closure-delay")
//    public int getClosureDelayCounter() {
//        return dashboardService.getClosureDelayCounter();
//    }
    
    @GetMapping("/chart-data")
    public DashboardChartData getChartData() {
        return ProjectService.getDashboardChartData();
    }
    
    
}
