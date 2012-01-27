package com.log4ic.utils.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Map;

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

    protected int executeUpdate(String dataSourceName, String sql, Map<Integer, Object> params) throws SQLException, NamingException {
        Connection conn = this.getConnection(dataSourceName);
        if (conn == null) {
            throw new SQLException();
        }
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            if (params != null) {
                for (Integer index : params.keySet()) {
                    stmt.setObject(index, params.get(index));
                }
            }
            int result = stmt.executeUpdate();
            conn.commit();
            return result;
        } catch (Exception e) {
            conn.rollback();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            conn.close();
        }
        return 0;
    }

    protected ResultSet executeQuery(String dataSourceName, String sql, Map<Integer, Object> params) throws SQLException, NamingException {
        Connection conn = this.getConnection(dataSourceName);
        if (conn == null) {
            throw new SQLException();
        }
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            if (params != null) {
                for (Integer index : params.keySet()) {
                    stmt.setObject(index, params.get(index));
                }
            }
            return stmt.executeQuery();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            conn.close();
        }
    }

    public boolean hasTable(String dataSourceName, String name) {
        //判断某一个表是否存在
        boolean result = false;
        try {
            DatabaseMetaData meta = this.getConnection(dataSourceName).getMetaData();
            ResultSet set = meta.getTables(null, null, name, null);
            while (set.next()) {
                result = true;
            }
        } catch (Exception eHasTable) {
            System.err.println(eHasTable);
            eHasTable.printStackTrace();
        }
        return result;
    }
}
