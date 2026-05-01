package com.example.texassolutions.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class IdempotencyKey {

    @Id
    private String IdempotentKey;
    private String response;
    private LocalDateTime expiryDate;

    public String getIdempotentKey() {
        return IdempotentKey;
    }

    public void setIdempotentKey(String idempotentKey) {
        IdempotentKey = idempotentKey;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }



    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }


}
