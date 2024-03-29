package ru.micro.mail.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author Tarkhov Evgeniy
 */
@Data
@Builder
public class MailMessageDto {

    private String address;
    private String message;
}
