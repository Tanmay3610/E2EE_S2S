package com.example.kds.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity(name="client_info")
public class ClientInfo {
    @Id
    @Column(name = "client_info_id")
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    UUID client_info_id;

    @Column(name = "client_id")
    String clientId;

    @Column(name = "client_type")
    String clientType;

    @Column(name = "is_deleted")
    boolean isDeleted;
}
