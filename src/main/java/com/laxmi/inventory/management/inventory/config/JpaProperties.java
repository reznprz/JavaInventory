package com.laxmi.inventory.management.inventory.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.jpa")
public class JpaProperties {

    private boolean showSql;
    private HibernateProperties properties = new HibernateProperties();

    public static class HibernateProperties {
        private String dialect;
        private String ddlAuto;

        // Getters and setters
        public String getDialect() {
            return dialect;
        }

        public void setDialect(String dialect) {
            this.dialect = dialect;
        }

        public String getDdlAuto() {
            return ddlAuto;
        }

        public void setDdlAuto(String ddlAuto) {
            this.ddlAuto = ddlAuto;
        }
    }

    // Getters and setters
    public boolean isShowSql() {
        return showSql;
    }

    public void setShowSql(boolean showSql) {
        this.showSql = showSql;
    }

    public HibernateProperties getProperties() {
        return properties;
    }

    public void setProperties(HibernateProperties properties) {
        this.properties = properties;
    }
}
