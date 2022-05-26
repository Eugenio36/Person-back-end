package com.ergohomework.personmanager.service;

import com.ergohomework.personmanager.domain.AuditLog;
import com.ergohomework.personmanager.repository.AuditLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuditLogService {

    private final AuditLogRepository auditLogRepository;

    public AuditLogService(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    public void addLog(String action) {
        AuditLog log = new AuditLog(action, LocalDateTime.now());
        auditLogRepository.save(log);
    }

}
