package com.shamil.insure.insure.Controller;

import com.shamil.insure.insure.Models.Agency;
import com.shamil.insure.insure.Services.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/agency")
public class AgencyController {
    @Autowired
    private AgencyService agencyService;

    @GetMapping()
    public ResponseEntity<List<Agency>> getAllAgencies() {
        return new ResponseEntity<>(agencyService.getAgencies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agency> getAgency(@PathVariable int id) {
        return new ResponseEntity<>(agencyService.getAgency(id), HttpStatus.OK);
    }

    @GetMapping("getAgencyByaID/{id}")
    public ResponseEntity<Agency> getAgencyByAID(@PathVariable String id) {
        return new ResponseEntity<>(agencyService.getAgencyByAID(id), HttpStatus.OK);
    }

    @GetMapping("/getCount")
    public ResponseEntity<Map<String, Integer>> getAgencyCount() {
        Map<String, Integer> m = new HashMap<>();
        m.put("count", agencyService.getAgencies().size());
        return new ResponseEntity<>(m, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Agency> addAgency(@RequestBody Agency agency) {
        return new ResponseEntity<>(agencyService.addAgency(agency), HttpStatus.CREATED);
    }
}
