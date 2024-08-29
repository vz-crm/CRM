	package com.example.crm.controller;
	
	import com.example.crm.model.Complaint;
	import com.example.crm.service.ComplaintService;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;
	
	import java.util.List;
	
	@RestController
	@RequestMapping("/complaints")
	public class ComplaintController {
	
	    @Autowired
	    private ComplaintService complaintService;
	
	    @GetMapping
	    public List<Complaint> getAllComplaints() {
	        return complaintService.getAllComplaints();
	    }
	
	    @GetMapping("/{id}")
	    public ResponseEntity<Complaint> getComplaintById(@PathVariable Long id) {
	        Complaint complaint = complaintService.getComplaintById(id);
	        if (complaint != null) {
	            return ResponseEntity.ok(complaint);
	        }
	        return ResponseEntity.notFound().build();
	    }
	
	    @PostMapping
	    public ResponseEntity<Complaint> createComplaint(@RequestBody Complaint complaint) {
	        Complaint savedComplaint = complaintService.saveComplaint(complaint);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedComplaint);
	    }
	
	    @PutMapping("/{id}")
	    public ResponseEntity<Complaint> updateComplaint(@PathVariable Long id, @RequestBody Complaint complaint) {
	        Complaint existingComplaint = complaintService.getComplaintById(id);
	        if (existingComplaint != null) {
	            complaint.setId(id);
	            Complaint updatedComplaint = complaintService.saveComplaint(complaint);
	            return ResponseEntity.ok(updatedComplaint);
	        }
	        return ResponseEntity.notFound().build();
	    }
	
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteComplaint(@PathVariable Long id) {
	        complaintService.deleteComplaint(id);
	        return ResponseEntity.noContent().build();
	    }
	}
