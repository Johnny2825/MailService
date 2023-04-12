package ru.micro.mail.service;

import ru.micro.mail.model.MailMessageDto;

/**
 * @author Tarkhov Evgeniy
 */
public interface MailService {

    void sendMail(MailMessageDto mailMessageDto);
}
