package ru.neoflex.audit.service;

import ru.neoflex.audit.persist.model.AuditAction;

public interface AuditService {
    void pushToRedis(AuditAction auditAction);
}
