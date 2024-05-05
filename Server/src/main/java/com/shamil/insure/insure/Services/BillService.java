package com.shamil.insure.insure.Services;

import com.shamil.insure.insure.Models.Bill;
import com.shamil.insure.insure.Repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BillService {
    @Autowired
    private BillRepository billRepository;

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public Bill addBill(Bill bill) {
        return billRepository.save(bill);
    }

    public Bill getBillByRNum(String r) {
        return billRepository.findByrNum(r);
    }

    public List<Bill> getBillsByUser(String id) {
        List<Bill> allBills = getAllBills();
        List<Bill> Bills = new ArrayList<>();
        allBills.forEach(b -> {
            if (b.patient.pID.equals(id)) {
                Bills.add(b);
            }
        });
        return Bills;
    }


}
