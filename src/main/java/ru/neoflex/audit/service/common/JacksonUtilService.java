package ru.neoflex.audit.service.common;

import ru.neoflex.audit.persist.model.AuditAction;

public interface JacksonUtilService {
    AuditAction convertToAuditAction(String message);
}
