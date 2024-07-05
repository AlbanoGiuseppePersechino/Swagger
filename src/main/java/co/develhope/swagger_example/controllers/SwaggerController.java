package co.develhope.swagger_example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/name")
@Tag(name = "Name Controller", description = "Controller per gestire i nomi")
public class SwaggerController {

    @GetMapping("/{name}")
    @Operation(summary = "Get Name", description = "Restituisce il nome fornito come parametro")
    public String getName(
            @Parameter(description = "Nome da restituire", required = true) @PathVariable String name) {
        return name;
    }

    @PostMapping("/reverse")
    @Operation(summary = "Reverse Name", description = "Restituisce il nome al contrario")
    public String reverseName(
            @Parameter(description = "Nome da invertire", required = true) @RequestParam String name) {
        return new StringBuilder(name).reverse().toString();
    }
}