package org.springframework.boot.exam.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.exam.model.Manage;
import org.springframework.boot.exam.service.ManageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/manage")
@RequiredArgsConstructor
public class ManageController {
    private final ManageService manageService;

    @PostMapping
    public ResponseEntity<?> add (@RequestBody Manage manage){
        return ResponseEntity.ok(manageService.add(manage));
    }

}
