package dev.yangsijun.rehello.application.domain.vo;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationCreateTest {

    @Test
    void idIsnullThrowsNPE() {
        assertThrows(NullPointerException.class,
                () -> ApplicationCreate.builder().id(UUID.randomUUID()).build());
    }

    @Test
    void allFieldNotNull() {
        var application = ApplicationCreate.builder()
                .id(UUID.randomUUID())
                .any(":")
                .any1("abc")
                .build();
    }

}
