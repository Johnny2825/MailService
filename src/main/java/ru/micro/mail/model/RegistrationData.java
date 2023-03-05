package ru.micro.mail.model;

import lombok.Data;

/**
 * @author Tarkhov Evgeniy
 */
@Data
public class RegistrationData {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
