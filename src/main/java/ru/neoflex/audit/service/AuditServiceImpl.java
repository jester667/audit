package ru.neoflex.audit.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.stereotype.Component;
import ru.neoflex.audit.persist.model.AuditAction;

@Component
@RequiredArgsConstructor
public class AuditServiceImpl implements AuditService {
    private final RedisOperations<String, AuditAction> redisOperations;

    @Override
    public void pushToRedis(AuditAction auditAction) {
        redisOperations.opsForValue()
                .set(auditAction.getUuid().toString(), auditAction);
    }
}
