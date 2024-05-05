package com.shamil.insure.insure.Controller;

import com.shamil.insure.insure.Models.ResultAnalysis;
import com.shamil.insure.insure.Services.ResultAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class ResultAnalysisController {

    @Autowired
    private ResultAnalysisService resultAnalysisService;

    @GetMapping("result_analysis/")
    public ResponseEntity<?> getAllResults() {
        return new ResponseEntity<>(resultAnalysisService.getAllResults(), HttpStatus.OK);
    }

    @PostMapping("result_analysis/")
    public ResponseEntity<?> adResult(@RequestBody ResultAnalysis resultAnalysis) {
        return new ResponseEntity<>(resultAnalysisService.addResult(resultAnalysis), HttpStatus.CREATED);
    }

    @GetMapping("getFunctionCallCount/")
    public ResponseEntity<?> getFunctionCallCount() {
        return new ResponseEntity<>(resultAnalysisService.getFunctionCallCount(), HttpStatus.OK);
    }

    @GetMapping("getCostOfFunctions/")
    public ResponseEntity<?> getCostOfFunctions() {
        return new ResponseEntity<>(resultAnalysisService.getCostOfFunctions(), HttpStatus.OK);
    }


    @GetMapping("getTimeTakenByFunctions/")
    public ResponseEntity<?> getTimeTakenByFunctions() {
        return new ResponseEntity<>(resultAnalysisService.getTimeTakenByFunctions(), HttpStatus.OK);
    }

    @GetMapping("getGasUsedByFunctions/")
    public ResponseEntity<?> getGasUsedByFunctions() {
        return new ResponseEntity<>(resultAnalysisService.getGasUsedByFunctions(), HttpStatus.OK);
    }
}
