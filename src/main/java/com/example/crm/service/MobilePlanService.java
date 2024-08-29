package com.example.crm.service;

import com.example.crm.model.MobilePlan;
import com.example.crm.repository.MobilePlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MobilePlanService {

    @Autowired
    private MobilePlanRepository mobilePlanRepository;

    public List<MobilePlan> getAllPlans() {
        return mobilePlanRepository.findAll();
    }

    public Optional<MobilePlan> getPlanById(Long id) {
        return mobilePlanRepository.findById(id);
    }

    public MobilePlan savePlan(MobilePlan plan) {
        return mobilePlanRepository.save(plan);
    }

    public void deletePlan(Long id) {
        mobilePlanRepository.deleteById(id);
    }
}
