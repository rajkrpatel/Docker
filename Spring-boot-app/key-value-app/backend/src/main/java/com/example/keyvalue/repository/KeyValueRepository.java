package com.example.keyvalue.repository;

import com.example.keyvalue.model.KeyValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KeyValueRepository extends JpaRepository<KeyValue, Long> {

    Optional<KeyValue> findByKey(String key);

    void deleteByKey(String key);
}

