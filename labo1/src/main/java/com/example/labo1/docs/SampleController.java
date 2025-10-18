package com.example.labo1.docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Sample Controller", description = "Example API to demonstrate Swagger documentation")
public class SampleController {

    @GetMapping("/hello")
    @Operation(summary = "Say Hello", description = "Returns a simple greeting message")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful greeting"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public String sayHello() {
        return "Hello from Swagger!";
    }
}
