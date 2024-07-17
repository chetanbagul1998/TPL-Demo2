package com.example.demo.repository;

import javax.persistence.EntityManager;  
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class ProjectRepositoryImpl implements ProjectRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public long countTotalProjects() {
        String jpql = "SELECT COUNT(p) FROM Project p";
        Query query = entityManager.createQuery(jpql);
        return (long) query.getSingleResult();
    }

    @Override
    public long countClosedProjects() {
        String jpql = "SELECT COUNT(p) FROM Project p WHERE p.status = 'Closed'";
        Query query = entityManager.createQuery(jpql);
        return (long) query.getSingleResult();
    }

    @Override
    public long countRunningProjects() {
        String jpql = "SELECT COUNT(p) FROM Project p WHERE p.status = 'Running'";
        Query query = entityManager.createQuery(jpql);
        return (long) query.getSingleResult();
    }

    @Override
    public long countCancelledProjects() {
        String jpql = "SELECT COUNT(p) FROM Project p WHERE p.status = 'Cancelled'";
        Query query = entityManager.createQuery(jpql);
        return (long) query.getSingleResult();
    }

}





//package com.example.demo.repository;
//
//import javax.persistence.EntityManager; 
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//
//public class ProjectRepositoryImpl implements ProjectRepositoryCustom {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    public ProjectRepositoryImpl() {
//        // Default constructor
//    }
//
//
//    @Override
//    public long countTotalProjects() {
//        String jpql = "SELECT COUNT(p) FROM Project p";
//        Query query = entityManager.createQuery(jpql);
//        return (long) query.getSingleResult();
//    }
//
//    @Override
//    public long countClosedProjects() {
//        String jpql = "SELECT COUNT(p) FROM Project p WHERE p.status = 'Closed'";
//        Query query = entityManager.createQuery(jpql);
//        return (long) query.getSingleResult();
//    }
//
//    @Override
//    public long countRunningProjects() {
//        String jpql = "SELECT COUNT(p) FROM Project p WHERE p.status = 'Running'";
//        Query query = entityManager.createQuery(jpql);
//        return (long) query.getSingleResult();
//    }
//
//    @Override
//    public long countCancelledProjects() {
//        String jpql = "SELECT COUNT(p) FROM Project p WHERE p.status = 'Cancelled'";
//        Query query = entityManager.createQuery(jpql);
//        return (long) query.getSingleResult();
//    }
//
//}
