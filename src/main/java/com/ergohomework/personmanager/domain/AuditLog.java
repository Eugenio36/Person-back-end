package com.ergohomework.personmanager.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class AuditLog {
    @Id
    @GeneratedValue()
    private long id;
    private String action;
    private LocalDateTime logTime;

    public AuditLog(String action, LocalDateTime logTime) {
        this.action = action;
        this.logTime = logTime;
    }

    public AuditLog() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDateTime getLogTime() {
        return logTime;
    }

    public void setLogTime(LocalDateTime logTime) {
        this.logTime = logTime;
    }
}
