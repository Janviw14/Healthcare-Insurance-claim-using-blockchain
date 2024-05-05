package com.shamil.insure.insure.Repository;

import com.shamil.insure.insure.Models.ResultAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResultAnalysisRepository extends JpaRepository<ResultAnalysis, Integer> {

    @Query("SELECT DISTINCT fnName FROM ResultAnalysis")
    List<String> findDistinctfName();

    @Query("SELECT COUNT(*) FROM ResultAnalysis WHERE fnName = ?1")
    long countFName(String fName);

    List<ResultAnalysis> findByfnName(String fName);


}
