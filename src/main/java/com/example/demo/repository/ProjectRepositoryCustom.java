package com.example.demo.repository;

public interface ProjectRepositoryCustom {

    long countTotalProjects();

    long countClosedProjects();

    long countRunningProjects();

    long countCancelledProjects();

}
