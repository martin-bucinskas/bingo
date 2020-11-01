package com.martinsdomain.bingo.discord;

import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class MessageHandlerRegistry {

    private final Map<String, MessageHandler> registrations;

    public MessageHandlerRegistry() {
        registrations = new HashMap<>();
    }

    public void registerHandlers() {
        Reflections reflections = new Reflections();
        Set<Class<?>> handlers = reflections.getTypesAnnotatedWith(MessageHandlerRegistration.class);
        Map<String, MessageHandler> initialisedRegistrations = handlers
            .stream()
            .collect(
                Collectors.toMap(
                    registry -> {
                        String handlerName = registry.getAnnotation(MessageHandlerRegistration.class).name();
                        log.info("Registering new '{}' message handler", handlerName);
                        return handlerName;
                    },
                    this::createInstance));

        registrations.putAll(initialisedRegistrations);
    }

    private MessageHandler createInstance(Class<?> messageHandlerClass) {
        try {
            return (MessageHandler) messageHandlerClass.getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException exception) {
            log.error("Failed to register handler '{}'", messageHandlerClass.getCanonicalName());
            return null;
        }
    }

    public Map<String, MessageHandler> getRegistrations() {
        return registrations;
    }
}
