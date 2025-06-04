package com.example.kds.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class ClientKey {
    @Id
    @Column(name = "key_id")
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    UUID keyId;

    @Column(name = "public_key_name")
    String publicKeyName;

    @Column(name = "key_version")
    String keyVersion;

    @Column(name = "is_deleted")
    boolean isDeleted;
}
