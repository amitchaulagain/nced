package com.cms.cmscomponent.datasource;

import com.cms.framework.core.DataSourcesFactory;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import javax.sql.DataSource;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by i82298 on 6/5/2016.
 */
public class DBTemplates {

    public static SimpleJdbcTemplate createTemplate(String alias) {
        checkNotNull(alias, "Alias argument can not be null.");

        DataSource ds = DataSourcesFactory.getDataSource(alias);
        return new SimpleJdbcTemplate(ds);
    }
}
