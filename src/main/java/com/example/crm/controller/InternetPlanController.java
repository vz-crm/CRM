package com.example.crm.controller;

import com.example.crm.model.InternetPlan;
import com.example.crm.service.InternetPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/internet-plans")
public class InternetPlanController {

    @Autowired
    private InternetPlanService internetPlanService;

    @GetMapping
    public List<InternetPlan> getAllPlans() {
        return internetPlanService.getAllPlans();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InternetPlan> getPlanById(@PathVariable Long id) {
        Optional<InternetPlan> plan = internetPlanService.getPlanById(id);
        return plan.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public InternetPlan createPlan(@RequestBody InternetPlan plan) {
        return internetPlanService.savePlan(plan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable Long id) {
        internetPlanService.deletePlan(id);
        return ResponseEntity.noContent().build();
    }
}
