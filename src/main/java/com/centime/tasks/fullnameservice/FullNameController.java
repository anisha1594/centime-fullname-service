package com.centime.tasks.fullnameservice;

import com.centime.tasks.fullnameservice.model.FullName;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class FullNameController {

    private static final Logger log = LoggerFactory.getLogger(FullNameController.class);

    @Operation(summary = "Fetch the concatenated name elements as a string")
    @PostMapping(path = "/full-name")
    public ResponseEntity<String> createFullName(@RequestHeader("traceId") String traceId,
                                                 @Valid @RequestBody FullName fullName) {
        log.info("[traceId: {}] Request received: {}", traceId, fullName.toString());
        String response = fullName.getName() + " " + fullName.getSurName();
        log.info("[traceId: {}] Response: {}", traceId, response);
        return ResponseEntity.ok(response);
    }
}
