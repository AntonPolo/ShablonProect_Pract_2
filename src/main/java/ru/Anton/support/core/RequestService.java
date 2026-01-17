package ru.Anton.support.core;

import ru.Anton.support.core.audit.AuditLogger;
import ru.Anton.support.core.notification.NotificationService;
import ru.Anton.support.core.repository.RequestSource;

public class RequestService {
    private final RequestSource source;
    //private final NotificationService notifier;
    //private final AuditLogger logger;

    public RequestService(RequestSource repository) {
        this.source = repository;
        //this.notifier = notifier;
        //this.logger = logger;
    }

    public String process(String studentId, String topic, String text, String channel, boolean urgent) {
        if (source.exists(studentId, topic)) {
            return "Already exists";
        }
        // Имитация сохранения
        return "Request accepted";
    }
}
