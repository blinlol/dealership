package com.dealership.models;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RequestStatusConverter implements AttributeConverter<RequestStatus, String> {
    @Override
    public String convertToDatabaseColumn(RequestStatus status) {
        if (status == null) {
            return null;
        }
        return status.name();
    }
    
    @Override
    public RequestStatus convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        return RequestStatus.valueOf(value);
    }
}
