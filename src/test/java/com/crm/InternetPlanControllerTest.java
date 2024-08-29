package com.crm;

import com.example.crm.controller.InternetPlanController;
import com.example.crm.model.InternetPlan;
import com.example.crm.service.InternetPlanService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Optional;

@WebMvcTest(InternetPlanController.class)
public class InternetPlanControllerTest {

    @InjectMocks
    private InternetPlanController internetPlanController;

    @Mock
    private InternetPlanService internetPlanService;

    private MockMvc mockMvc;

    @Test
    public void testGetAllPlans() throws Exception {
        mockMvc.perform(get("/api/internet-plans"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetPlanById() throws Exception {
        Long id = 1L;
        InternetPlan plan = new InternetPlan();
        plan.setId(id);
        when(internetPlanService.getPlanById(id)).thenReturn(Optional.of(plan));

        mockMvc.perform(get("/api/internet-plans/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id));
    }

    @Test
    public void testCreatePlan() throws Exception {
        InternetPlan plan = new InternetPlan();
        plan.setName("Basic Internet Plan");
        plan.setPrice(" ");
      
        mockMvc.perform(post("/api/internet-plans")
                        .contentType("application/json")
                        .content("{\"name\": \"Basic Internet Plan\", \"price\": 10.0, \"speed\": 50.0}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeletePlan() throws Exception {
        Long id = 1L;

        mockMvc.perform(delete("/api/internet-plans/" + id))
                .andExpect(status().isNoContent());
    }
}
