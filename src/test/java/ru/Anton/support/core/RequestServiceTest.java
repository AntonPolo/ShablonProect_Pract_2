package ru.Anton.support.core;

import org.junit.jupiter.api.Test;
import ru.Anton.support.core.repository.RequestSource;

import static org.junit.jupiter.api.Assertions.*;

public class RequestServiceTest {

    // === Успешная обработка ===
    @Test
    public void testNewPasswordRequest_returnsPasswordMessage() {
        RequestSource mock = new RequestSource() {
            @Override public boolean exists(String s, String t) { return false; }
            @Override public int save(Request r) { return 1; }
        };
        RequestService service = new RequestService(mock);
        assertEquals("Reset instruction sent",
                service.process("S1", "password reset", "text", "email", false));
    }

    @Test
    public void testNewScheduleRequest_returnsScheduleMessage() {
        RequestSource mock = new RequestSource() {
            @Override public boolean exists(String s, String t) { return false; }
            @Override public int save(Request r) { return 1; }
        };
        RequestService service = new RequestService(mock);
        assertEquals("We will check schedule",
                service.process("S1", "exam schedule", "text", "email", false));
    }

    // === Дубликаты ===
    @Test
    public void testDuplicatePasswordRequest_returnsAlreadyExists() {
        RequestSource mock = new RequestSource() {
            @Override public boolean exists(String s, String t) { return true; }
            @Override public int save(Request r) { return 0; }
        };
        RequestService service = new RequestService(mock);
        assertEquals("Already exists",
                service.process("S1", "password reset", "text", "email", false));
    }

    @Test
    public void testDuplicateScheduleRequest_returnsAlreadyExists() {
        RequestSource mock = new RequestSource() {
            @Override public boolean exists(String s, String t) { return true; }
            @Override public int save(Request r) { return 0; }
        };
        RequestService service = new RequestService(mock);
        assertEquals("Already exists",
                service.process("S1", "exam schedule", "text", "email", false));
    }
}
