package com.example.texassolutions.repository;

import com.example.texassolutions.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    @Query(value = "SELECT *FROM APPLICATION", nativeQuery = true)
    List<Application> getApplications();

    @Query(value = "SELECT *FROM APPLICATION WHERE APPLICATION.APPLICATION_ID = :id", nativeQuery = true)
    Application getApplicationById(int id);

}
