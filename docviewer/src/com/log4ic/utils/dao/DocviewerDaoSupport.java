package com.log4ic.utils.dao;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * @author 张立鑫 IntelligentCode
 * @date: 12-1-23
 * @time: 上午2:48
 */
public abstract class DocviewerDaoSupport extends AbstractDaoSupport {
    private static final String DEFAULT_DATA_SOURCE = "docviewerDB";

    protected DataSource getDocviewerDataSource() throws NamingException {
        return super.getDataSource(DEFAULT_DATA_SOURCE);
    }

    protected Connection getDocviewerConnection() throws NamingException, SQLException {
        return super.getConnection(DEFAULT_DATA_SOURCE);
    }

    protected int executeUpdate(String sql, Map<Integer, Object> params) throws SQLException, NamingException {
        return super.executeUpdate(DEFAULT_DATA_SOURCE, sql, params);
    }

    protected int executeUpdate(String sql) throws SQLException, NamingException {
        return super.executeUpdate(DEFAULT_DATA_SOURCE, sql, null);
    }

    protected ResultSet executeQuery(String sql, Map<Integer, Object> params) throws SQLException, NamingException {
        return super.executeQuery(DEFAULT_DATA_SOURCE, sql, params);
    }

    protected ResultSet executeQuery(String sql) throws SQLException, NamingException {
        return super.executeQuery(DEFAULT_DATA_SOURCE, sql, null);
    }

    public boolean hasTable(String name) {
        return super.hasTable(DEFAULT_DATA_SOURCE, name);
    }
}
