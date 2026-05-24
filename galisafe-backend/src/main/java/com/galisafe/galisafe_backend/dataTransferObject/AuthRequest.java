package com.galisafe.galisafe_backend.dataTransferObject;

import lombok.Data;

@Data
public class AuthRequest {
    private String Name ;
    private String Email;
    private String Phone;
    private String Password;

}
