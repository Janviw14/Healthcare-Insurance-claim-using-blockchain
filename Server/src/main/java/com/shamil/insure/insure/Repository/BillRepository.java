package com.shamil.insure.insure.Repository;

import com.shamil.insure.insure.Models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Integer> {
    Bill findByrNum(String r);
}
