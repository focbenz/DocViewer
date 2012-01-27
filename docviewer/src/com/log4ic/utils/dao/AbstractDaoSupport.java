package com.log4ic.utils.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 张立鑫 IntelligentCode
 * @date: 12-1-23
 * @time: 上午2:39
 */
public abstract class AbstractDaoSupport {
    protected DataSource getDataSource(String dataSourceName) throws NamingException {
        Context initContext = new InitialContext();
        if (initContext == null) {
            throw new NamingException();
        }
        return (DataSource) initContext.lookup("java:comp/env/jdbc/" + dataSourceName);
    }

    protected Connection getConnection(String dataSourceName) throws SQLException, NamingException {
        DataSource dataSource = this.getDataSource(dataSourceName);
        if (dataSource == null) {
            return null;
        }
        return dataSource.getConnection();
    }
}
