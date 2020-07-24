package com.centime.tasks.fullnameservice;

import com.centime.tasks.fullnameservice.model.FullName;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class FullNameController {

    @Operation(summary = "Fetch the concatenated name elements as a string")
    @PostMapping(path = "/full-name")
    public ResponseEntity<String> createFullName(@Valid @RequestBody FullName fullName) {
        return ResponseEntity.ok(fullName.getName() + " " + fullName.getSurName());
    }
}
