package com.log4ic.dao.impl;

import com.log4ic.dao.IDocumentRelationDao;
import com.log4ic.entity.DocumentRelation;
import com.log4ic.utils.dao.DocviewerDaoSupport;
import javolution.util.FastMap;

import javax.naming.NamingException;
import java.sql.*;
import java.util.Map;

/**
 * @author 张立鑫 IntelligentCode
 * @date: 12-1-23
 * @time: 上午2:37
 */
public class DocumentRelationDao extends DocviewerDaoSupport implements IDocumentRelationDao {
    public void save(DocumentRelation relation) throws NamingException, SQLException {

        Map<Integer, Object> params = new FastMap<Integer, Object>();
        params.put(0, relation.getFileName());
        params.put(1, relation.getLocation());
        this.executeUpdate("insert into documentrelation(filename,location) values (?,?)", params);

    }

    public ResultSet getAllRelation() throws NamingException, SQLException {
        return this.executeQuery("select * from documentrelation");
    }

    public DocumentRelation getRelation(int id) throws NamingException, SQLException {
        Map<Integer, Object> params = new FastMap<Integer, Object>();
        ResultSet resultSet = this.executeQuery("select * from documentrelation whewe id=?", params);
        if (resultSet.first()) {
            DocumentRelation relation = new DocumentRelation();
            relation.setFileName(resultSet.getString("filename"));
            relation.setLocation(resultSet.getString("location"));
            relation.setId(resultSet.getInt("id"));
            return relation;
        }
        return null;
    }
}
