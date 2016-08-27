package com.cms.framework.core;

import com.cms.cmscomponent.datasource.DBTemplates;
import com.cms.framework.constants.CMSConstant;
import org.hibernate.engine.spi.QueryParameters;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by i82298 on 6/5/2016.
 */
public class BasicDAO {

    /**
     * holds query to be executed
     */
    protected String sqlQuery = "";

    /**
     * holds the number of records in result set for main query
     */
    protected Integer recordCount;

    /**
     * DataSetParameters contains all the parameters for constructing the query
     */

    /**
     * JdbcTemplate does all low level SQL work (getting connection, creating
     * statement and executing the query)
     */
    protected SimpleJdbcTemplate simpleTemplate;

    private static SimpleJdbcTemplate super_db = DBTemplates
            .createTemplate(CMSConstant.SUPER_DATABASE_ALIAS);

    /**
     * Constructor with DataSouce. Useful for implementation which do not
     * require DataSetParameter. This usually connects to HEUSER or HELOG.
     *
     *
     * @param dataSource
     *            dataSoruceName
     */
    public BasicDAO(String dataSource) {
        if (CMSConstant.SUPER_DATABASE_ALIAS
                .equals(dataSource)) {
            this.simpleTemplate = super_db;
        } else {
            this.simpleTemplate = DBTemplates.createTemplate(dataSource);
        }
    }

    public BasicDAO(QueryParameters dataSetParam) {
//        this(dataSetParam.getDataSourceName());
//        this.dataSetParam = dataSetParam;
    }

    /**
     * DataSource of named alias.
     *
     * @param alias
     * @return
     */
    public static DataSource getDataSource(String alias) {
        return DataSourcesFactory.getDataSource(alias);
    }



}
