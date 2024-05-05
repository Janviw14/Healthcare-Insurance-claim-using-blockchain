package com.shamil.insure.insure.Services;

import com.shamil.insure.insure.Models.ResultAnalysis;
import com.shamil.insure.insure.Repository.ResultAnalysisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class ResultAnalysisService {
    @Autowired
    private ResultAnalysisRepository resultAnalysisRepository;

    public List<ResultAnalysis> getAllResults() {
        return resultAnalysisRepository.findAll();
    }

    public ResultAnalysis addResult(ResultAnalysis ra) {
        return resultAnalysisRepository.save(ra);
    }

    public List<Map<String, String>> getFunctionCallCount() {
        List<String> ra = resultAnalysisRepository.findDistinctfName();

        List<Map<String, String>> data = new ArrayList<>();

        ra.forEach(fName -> {
            int count = (int) resultAnalysisRepository.countFName(fName);
            Map<String, String> m = new HashMap<>();

            m.put("fnName", fName);
            m.put("count", String.valueOf(count));

            data.add(m);
        });

        return data;
    }

    public List<Map<String, String>> getCostOfFunctions() {
        List<String> ra = resultAnalysisRepository.findDistinctfName();

        List<Map<String, String>> data = new ArrayList<>();

        ra.forEach(fName -> {
            List<ResultAnalysis> resultAnalysisList = resultAnalysisRepository.findByfnName(fName);
            Map<String, String> m = new HashMap<>();
            AtomicReference<Float> cost = new AtomicReference<>((float) 0);
            resultAnalysisList.forEach(r -> cost.updateAndGet(v -> v + Float.parseFloat(r.getTotalCost()
                                                                                         .split("ETH")[0].trim())));
            m.put("fnName", fName);
            m.put("cost", String.valueOf(cost.get()));

            data.add(m);
        });
        return data;
    }

    public List<Map<String, String>> getTimeTakenByFunctions() {
        List<String> ra = resultAnalysisRepository.findDistinctfName();

        List<Map<String, String>> data = new ArrayList<>();

        ra.forEach(fName -> {
            List<ResultAnalysis> resultAnalysisList = resultAnalysisRepository.findByfnName(fName);
            Map<String, String> m = new HashMap<>();
            AtomicReference<Float> cost = new AtomicReference<>((float) 0);
            resultAnalysisList.forEach(r -> cost.updateAndGet(v -> v + Float.parseFloat(r.getTimeTaken()
                                                                                         .split("s")[0].trim())));
            m.put("fnName", fName);
            m.put("timeTaken", String.valueOf(cost.get()));

            data.add(m);
        });
        return data;
    }


    public List<Map<String, String>> getGasUsedByFunctions() {
        List<String> ra = resultAnalysisRepository.findDistinctfName();

        List<Map<String, String>> data = new ArrayList<>();

        ra.forEach(fName -> {
            List<ResultAnalysis> resultAnalysisList = resultAnalysisRepository.findByfnName(fName);
            Map<String, String> m = new HashMap<>();
            AtomicReference<Float> cost = new AtomicReference<>((float) 0);
            resultAnalysisList.forEach(r -> cost.updateAndGet(v -> v + Float.parseFloat(r.getGasUsed())));

            m.put("fnName", fName);
            m.put("gasUsed", String.valueOf(cost.get()));

            data.add(m);
        });
        return data;
    }

}
