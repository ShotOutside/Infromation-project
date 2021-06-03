package com.rj.bd.classes.service;

import com.rj.bd.classes.dao.ClassesDao;
import com.rj.bd.classes.entity.Classes;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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


    @Override
    public Map<String, Object> queryid(String cid) {
        return classesDao.queryid(cid);
    }


}
