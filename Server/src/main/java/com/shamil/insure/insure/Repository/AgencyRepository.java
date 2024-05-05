package com.shamil.insure.insure.Repository;

import com.shamil.insure.insure.Models.Agency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgencyRepository extends JpaRepository<Agency,Integer> {

    Agency findByaID(String aID);
}
