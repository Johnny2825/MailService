package ru.micro.mail.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.micro.mail.model.RegistrationData;

/**
 * @author Tarkhov Evgeniy
 */
@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void sendMail(String message) {
        System.out.println("Get message from kafka: " + message);
        try {
            RegistrationData registrationData = mapper.readValue(message, RegistrationData.class);
            System.out.println(registrationData);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
