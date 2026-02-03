package com.example.keyvalue.model;

import jakarta.persistence.*;

@Entity
@Table(name = "KEY_VALUES")
public class KeyValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "KEY_COLUMN", unique = true, nullable = false, length = 255)
    private String key;

    @Column(name = "VALUE_COLUMN", nullable = false, length = 4000)
    private String value;

    public KeyValue() {
    }

    public KeyValue(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

