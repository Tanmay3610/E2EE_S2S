package com.example.kds.controller;

import com.example.kds.services.ApiCompositionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/v1/api/composition")
public class ApiCompositionController {
    private final ApiCompositionService apiCompositionService;

    ApiCompositionController(ApiCompositionService apiCompositionService) {
        this.apiCompositionService = apiCompositionService;
    }

    @GetMapping("/test")
    public ResponseEntity<String> apiComposition() throws ExecutionException, InterruptedException {
        String res = apiCompositionService.compositionTesting();
        return ResponseEntity.ok(res);
    }
}
