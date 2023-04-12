package ru.micro.mail.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.micro.mail.model.MailMessageDto;

/**
 * @author Tarkhov Evgeniy
 */
@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void sendMail(MailMessageDto mailMessageDto) {
        System.out.println("Get message from kafka: " + mailMessageDto);
    }
}
