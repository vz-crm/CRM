package com.example.crm.service;

import com.example.crm.model.InternetPlan;
import com.example.crm.repository.InternetPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InternetPlanService {

    @Autowired
    private InternetPlanRepository internetPlanRepository;

    public List<InternetPlan> getAllPlans() {
        return internetPlanRepository.findAll();
    }

    public Optional<InternetPlan> getPlanById(Long id) {
        return internetPlanRepository.findById(id);
    }

    public InternetPlan savePlan(InternetPlan plan) {
        return internetPlanRepository.save(plan);
    }

    public void deletePlan(Long id) {
        internetPlanRepository.deleteById(id);
    }
}
