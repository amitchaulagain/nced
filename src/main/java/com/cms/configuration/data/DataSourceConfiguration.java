package com.cms.configuration.data;

import org.springframework.context.annotation.Configuration;

/**
 * Created by Nirmal on 3/22/2016.
 */
//@Configuration
public class DataSourceConfiguration {

 /*   @Value("${datasource.oracle.url}")
    private String oracle_url;

    @Value("${datasource.oracle.user}")
    private String oracle_user;

    @Value("${datasource.oracle.password}")
    private String oracle_password;

    @Value("${datasource.hsqldb.url}")
    private String hsqldb_url;

    @Value("${datasource.hsqldb.user}")
    private String hsqldb_user;

    @Value("${datasource.hsqldb.password}")
    private String hsqldb_password;

    @Bean
    @Profile("hsqldb")
    public DataSource getHsqldbDataSource() {
        return new DriverManagerDataSource(hsqldb_url, hsqldb_user, hsqldb_password);
    }

    @Bean
    @Profile("oracle")
    public DataSource getOracleDataSource() {
        return new DriverManagerDataSource(oracle_url, oracle_user, oracle_password);
    }

    @Bean
    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

*/
}
