package ru.neoflex.audit.service.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import ru.neoflex.audit.persist.model.AuditAction;

@Component
@RequiredArgsConstructor
public class JacksonUtilServiceImpl implements JacksonUtilService {
    private final ObjectMapper objectMapper;

    @Override
    @SneakyThrows
    public AuditAction convertToAuditAction(String message) {
        return objectMapper.readValue(message, AuditAction.class);
    }
}
