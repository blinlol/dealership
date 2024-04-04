package com.dealership.models;

import jakarta.persistence.*;
import java.time.*;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;
import org.hibernate.type.SqlTypes;

import io.hypersistence.utils.hibernate.type.basic.PostgreSQLEnumType;

@Entity
@Table(name = "request")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "configuration_id")
    private Configuration configuration;

    private int count; 
    @Column(name="client_name")
    private String clientName;
    @Column(name="client_phone")
    private String clientPhone;
    @Column(name="client_email")
    private String clientEmail;

    // @Enumerated(EnumType.STRING)
    // @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Convert(converter = RequestStatusConverter.class)
    private RequestStatus status;

    @Column(name="creation_date")
    private LocalDateTime creationDate;

    public Request(){}

    public Request(
            Configuration configuration, 
            int count, 
            String clientName, 
            String clientPhone, 
            String clientEmail, 
            RequestStatus status) {
        this.configuration = configuration;
        this.count = count;
        this.clientName = clientName;
        this.clientPhone = clientPhone;
        this.clientEmail = clientEmail;
        this.status = status;
        this.creationDate = LocalDateTime.now();
    }

    public Request(
            Configuration configuration, 
            int count, 
            String client_name, 
            String client_phone, 
            String client_email, 
            RequestStatus status, 
            LocalDateTime creationDate) {
        this.configuration = configuration;
        this.count = count;
        this.clientName = client_name;
        this.clientPhone = client_phone;
        this.clientEmail = client_email;
        this.status = status;
        this.creationDate = creationDate;
    }

    public int getId(){
        return id;
    }

    public Configuration getConfiguration(){
        return configuration;
    }
    public void setConfiguration(Configuration configuration){
        this.configuration = configuration;
    }

    public int getCount(){
        return count;
    }
    public void setCount(int count){
        this.count = count;
    }

    public String getClientName(){
        return clientName;
    }
    public void setClientName(String clientName){
        this.clientName = clientName;
    }

    public String getClientPhone(){
        return clientPhone;
    }
    public void setClientPhone(String clientPhone){
        this.clientPhone = clientPhone;
    }

    public String getClientEmail(){
        return clientEmail;
    }
    public void setClientEmail(String clientEmail){
        this.clientEmail = clientEmail;
    }

    public RequestStatus getStatus(){
        return status;
    }
    public void setStatus(RequestStatus status){
        this.status = status;
    }

    public LocalDateTime getCreationDate(){
        return creationDate;
    }
    public void setCreationDate(LocalDateTime creationDate){
        this.creationDate = creationDate;
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return id == request.id;
    }
}
