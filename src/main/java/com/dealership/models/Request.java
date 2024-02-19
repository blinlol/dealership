package com.dealership.models;

import jakarta.persistence.*;

public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "configuration_id")
    private Configuration configuration;

    private int count; 
    private String client_name;
    private String client_phone;
    private String client_email;

    @Enumerated(EnumType.STRING)
    private RequestStatus status;

    
}
