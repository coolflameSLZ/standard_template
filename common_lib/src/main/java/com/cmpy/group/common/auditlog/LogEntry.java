package com.cmpy.group.common.auditlog;

import com.github.structlog4j.IToLog;
import lombok.Data;

/**
 * 拓展格式化日志,structlog4j
 */
@Data
public class LogEntry implements IToLog {

    private String currentUserId;
    private String companyId;
    private String teamId;
    private String authorization;
    private String targetType;
    private String targetId;
    private String originalContents;
    private String updatedContents;

    @Override
    public Object[] toLog() {
        return new Object[]{
                "auditlog", "true",
                "currentUserId", currentUserId,
                "companyId", companyId,
                "teamId", teamId,
                "authorization", authorization,
                "targetType", targetType,
                "targetId", targetId,
                "originalContents", originalContents,
                "updatedContents", updatedContents
        };
    }
}
