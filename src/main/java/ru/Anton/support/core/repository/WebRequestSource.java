package ru.Anton.support.core.repository;

import ru.Anton.support.core.Request;

public class WebRequestSource implements RequestSource{

    @Override
    public boolean exists(String studentId, String topic) {
        return false;
    }

    @Override
    public int save(Request request) {
        return 0;
    }
}
