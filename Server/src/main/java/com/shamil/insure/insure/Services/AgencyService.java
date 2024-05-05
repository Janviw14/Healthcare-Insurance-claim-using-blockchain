package com.shamil.insure.insure.Services;

import com.shamil.insure.insure.Models.Agency;
import com.shamil.insure.insure.Repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AgencyService {
    @Autowired
    private AgencyRepository agencyRepository;

    public List<Agency> getAgencies() {
        return agencyRepository.findAll();
    }

    public Agency getAgency(int id) {
        return agencyRepository.findById(id).orElse(null);
    }

    public Agency getAgencyByAID(String aID) {
        return agencyRepository.findByaID(aID);
    }

    public Agency addAgency(Agency agency) {
        agencyRepository.save(agency);
        return agency;
    }
}
