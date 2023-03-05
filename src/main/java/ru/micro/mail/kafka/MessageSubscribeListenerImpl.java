package ru.micro.mail.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.micro.mail.service.MailService;

/**
 * @author Tarkhov Evgeniy
 */
@Service
@RequiredArgsConstructor
public class MessageSubscribeListenerImpl implements MessageSubscribeListener {

    private final MailService mailService;

    @Override
    @KafkaListener(topics = "mail-command", groupId = "group_id")
    public void read(String message) {
        mailService.sendMail(message);
    }
}
