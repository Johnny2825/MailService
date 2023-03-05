package ru.micro.mail.kafka;

/**
 * @author Tarkhov Evgeniy
 */
public interface MessageSubscribeListener {

    void read(String message);
}
