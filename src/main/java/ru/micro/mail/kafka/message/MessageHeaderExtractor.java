package ru.micro.mail.kafka.message;

import org.springframework.messaging.Message;

import java.util.UUID;

import static java.util.Objects.isNull;
import static ru.micro.mail.model.Constant.Kafka.MESSAGE_GUID_HEADER;

/**
 * @author Tarkhov Evgeniy
 */
public class MessageHeaderExtractor {

    private MessageHeaderExtractor(){
    }

    public static UUID getUuid(final Message<? extends Object> msg) {
        if (isNull(msg)) return null;
        final Object ob = msg.getHeaders().get(MESSAGE_GUID_HEADER);
        if (isNull(ob)) return null;
        if (ob instanceof UUID uuid) return uuid;
        return tryParseUuidOrGetNull(ob.toString());
    }

    private static UUID tryParseUuidOrGetNull(final String value){
        try {
            return UUID.fromString(value);
        } catch (Exception ignored){
            //ignore
        }
        return null;
    }

}
