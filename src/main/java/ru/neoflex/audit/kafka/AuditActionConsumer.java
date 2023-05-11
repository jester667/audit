package ru.neoflex.audit.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.neoflex.audit.service.AuditService;
import ru.neoflex.audit.service.common.JacksonUtilService;

@Component
@RequiredArgsConstructor
public class AuditActionConsumer {
    private final JacksonUtilService jacksonUtilService;
    private final AuditService auditService;

    @KafkaListener(topics = "${spring.kafka.topic.audit}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeAuditAction(String message) {
        var auditAction = jacksonUtilService.convertToAuditAction(message);
        auditService.pushToRedis(auditAction);
    }
}
