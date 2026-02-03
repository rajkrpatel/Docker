package com.example.keyvalue.controller;

import com.example.keyvalue.model.KeyValue;
import com.example.keyvalue.repository.KeyValueRepository;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/store")
public class KeyValueController {

    private final KeyValueRepository repository;

    public KeyValueController(KeyValueRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Map<String, String> body) {
        String key = body.get("key");
        String value = body.get("value");

        if (key == null || key.isBlank() || value == null || value.isBlank()) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "Both \"key\" and \"value\" are required"));
        }

        if (repository.findByKey(key).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Key already exists"));
        }

        KeyValue keyValue = new KeyValue(key, value);
        repository.save(keyValue);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("message", "Key-Value pair stored successfully"));
    }

    @GetMapping("/{key}")
    public ResponseEntity<?> get(@PathVariable("key") String key) {
        return repository.findByKey(key)
                .map(kv -> ResponseEntity.ok(Map.of("key", kv.getKey(), "value", kv.getValue())))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("error", "Key not found")));
    }

    @PutMapping("/{key}")
    public ResponseEntity<?> update(@PathVariable("key") String key,
                                    @RequestBody Map<String, String> body) {
        String value = body.get("value");

        if (value == null || value.isBlank()) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "\"value\" is required"));
        }

        return repository.findByKey(key)
                .map(existing -> {
                    existing.setValue(value);
                    repository.save(existing);
                    return ResponseEntity.ok(Map.of(
                            "message", "Key-value pair updated successfully",
                            "key", existing.getKey(),
                            "value", existing.getValue()
                    ));
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("error", "Key not found")));
    }

    @DeleteMapping("/{key}")
    public ResponseEntity<?> delete(@PathVariable("key") @NotBlank String key) {
        return repository.findByKey(key)
                .map(existing -> {
                    repository.deleteByKey(key);
                    return ResponseEntity.ok(
                            Map.of("message", "Key-value pair deleted successfully")
                    );
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("error", "Key not found")));
    }
}

