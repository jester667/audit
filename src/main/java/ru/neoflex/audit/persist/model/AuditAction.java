package ru.neoflex.audit.persist.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditAction implements Serializable {
    private UUID uuid;
    private String type;
    private String service;
    private String message;
}
