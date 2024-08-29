package com.crm;

import com.example.crm.model.MobilePlan;
import com.example.crm.service.MobilePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mobile-plans")
public class MobilePlanControllerTest {

    @Autowired
    private MobilePlanService mobilePlanService;

    @GetMapping
    public List<MobilePlan> getAllPlans() {
        return mobilePlanService.getAllPlans();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MobilePlan> getPlanById(@PathVariable Long id) {
        Optional<MobilePlan> plan = mobilePlanService.getPlanById(id);
        return plan.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public MobilePlan createPlan(@RequestBody MobilePlan plan) {
        return mobilePlanService.savePlan(plan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable Long id) {
        mobilePlanService.deletePlan(id);
        return ResponseEntity.noContent().build();
    }
}
