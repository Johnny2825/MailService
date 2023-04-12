package ru.micro.mail.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import ru.micro.mail.kafka.message.MessageHeaderExtractor;
import ru.micro.mail.model.MailMessageDto;
import ru.micro.mail.service.MailService;

import java.util.UUID;
import java.util.function.Consumer;

import static java.util.Objects.isNull;

/**
 * @author Tarkhov Evgeniy
 */
@Service
@RequiredArgsConstructor
public class MessageSubscribeListener {

    private final MailService mailService;

    @Bean
    public Consumer<Message<MailMessageDto>> consumer() {
        return this::processingMessage;
    }

    private void processingMessage(Message<MailMessageDto> msg) {
        try {
            System.out.println("msg: " + msg);
            UUID uuid = MessageHeaderExtractor.getUuid(msg);
            if (isNull(uuid)) {
                System.out.println("Нету uuid");
                return;
            }
            mailService.sendMail(msg.getPayload());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
