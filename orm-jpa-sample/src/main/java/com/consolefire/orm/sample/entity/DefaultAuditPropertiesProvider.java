/**
 * Created at 29-Apr-2016 by sabuj.das
 */
package com.consolefire.orm.sample.entity;

import org.springframework.stereotype.Component;

import com.consolefire.orm.config.AuditPropertiesProvider;
import com.consolefire.orm.entity.AuditProperties;

/**
 * @author sabuj.das
 *
 */
@Component
public class DefaultAuditPropertiesProvider implements AuditPropertiesProvider {

    /* (non-Javadoc)
     * @see com.consolefire.orm.config.AuditPropertiesProvider#getAuditProperties()
     */
    @Override
    public AuditProperties getAuditProperties() {
        AuditProperties auditProperties = new AuditProperties();
        auditProperties.setCreatedBy("Jack");
        auditProperties.setUpdatedBy("Black");
        return auditProperties;
    }

}
