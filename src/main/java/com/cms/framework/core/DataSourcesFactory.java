package com.cms.framework.core;

import com.cms.framework.constants.CMSConstant;
import com.google.common.base.Preconditions;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;

/**
 * Utility class to get {@link DataSource} objects.
 * 
 * @author i80448
 * 
 */
public class DataSourcesFactory {


    public static DataSource getDataSource(String dsName) {
        checkArgument(!isNullOrEmpty(dsName),
                "data source alias can not be null.");
        if (CMSConstant.SUPER_DATABASE_ALIAS.equalsIgnoreCase(dsName)) {
            return new DriverManagerDataSource();
        }else
        return new DriverManagerDataSource();
    }


}
