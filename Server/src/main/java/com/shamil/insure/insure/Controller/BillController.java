package com.shamil.insure.insure.Controller;

import com.shamil.insure.insure.Models.Bill;
import com.shamil.insure.insure.Services.BillService;
import com.shamil.insure.insure.Utils.GenerateID;
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
@RequestMapping("/api/bill")
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping()
    public ResponseEntity<List<Bill>> getAllBills() {
        return new ResponseEntity<>(billService.getAllBills(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bill> addBill(@RequestBody Bill bill) {
        return new ResponseEntity<>(billService.addBill(bill), HttpStatus.CREATED);
    }

    @GetMapping("/generateReNum")
    public ResponseEntity<Map<String, String>> genReNum() {
        Map<String, String> m = new HashMap<>();
        GenerateID g = new GenerateID();
        String R = "";
        do {
            R = g.generateReNum();
            m.put("data", R);
        } while (billService.getBillByRNum(R) != null);

        return new ResponseEntity<>(m, HttpStatus.OK);
    }

    @GetMapping("/getBillsByUser/{id}")
    public ResponseEntity<List<Bill>> getBillsBySuer(@PathVariable String id) {
        return new ResponseEntity<>(billService.getBillsByUser(id), HttpStatus.OK);
    }
}
