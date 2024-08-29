package com.example.crm.controller;

import com.example.crm.model.ServiceRequest;
import com.example.crm.service.ServiceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/service-requests")
public class ServiceRequestController {

    @Autowired
    private ServiceRequestService serviceRequestService;

    @GetMapping
    public List<ServiceRequest> getAllServiceRequests() {
        return serviceRequestService.getAllServiceRequests();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceRequest> getServiceRequestById(@PathVariable Long id) {
        ServiceRequest serviceRequest = serviceRequestService.getServiceRequestById(id);
        if (serviceRequest != null) {
            return ResponseEntity.ok(serviceRequest);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ServiceRequest> createServiceRequest(@RequestBody ServiceRequest serviceRequest) {
        ServiceRequest savedServiceRequest = serviceRequestService.saveServiceRequest(serviceRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedServiceRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceRequest> updateServiceRequest(@PathVariable Long id, @RequestBody ServiceRequest serviceRequest) {
        ServiceRequest existingServiceRequest = serviceRequestService.getServiceRequestById(id);
        if (existingServiceRequest != null) {
            serviceRequest.setId(id);
            ServiceRequest updatedServiceRequest = serviceRequestService.saveServiceRequest(serviceRequest);
            return ResponseEntity.ok(updatedServiceRequest);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceRequest(@PathVariable Long id) {
        serviceRequestService.deleteServiceRequest(id);
        return ResponseEntity.noContent().build();
    }
}
