package ru.Anton.support.core.repository;

import ru.Anton.support.core.Request;

public interface RequestSource {
    boolean exists(String studentId, String topic);
    int save(Request request);
}
