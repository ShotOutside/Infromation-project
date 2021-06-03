package com.rj.bd.classes.service;

import com.rj.bd.classes.config.SolrUpdataJob;
import com.rj.bd.classes.dao.ClassesDao;
import org.apache.solr.client.solrj.SolrServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author ShiJie
 * @desc
 * @time 2021-05-31-16:50
 */

@Service
public class ClassesImpl implements IClassesService{

    @Autowired
    public ClassesDao classesDao;

    @Autowired
    public SolrUpdataJob solrUpdataJob;


    @Override
    public Map<String, Object> queryid(String cid) {
        return classesDao.queryid(cid);
    }
}
