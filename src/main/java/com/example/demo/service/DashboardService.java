package com.example.demo.service;

import com.example.demo.model.CounterResponse;

public interface DashboardService {

    CounterResponse getCounters();

    int getClosureDelayCounter();
}
