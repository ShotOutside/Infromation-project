package com.rj.bd.classes.config;


import com.rj.bd.classes.dao.ClassesDao;
import com.rj.bd.classes.entity.Classes;

import org.apache.ibatis.annotations.Mapper;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;



public class   SolrUpdataJob {
    @Autowired
    ClassesDao classesDao;

    @Autowired
    SolrServer solrServer;

    public void updataSolr() throws IOException, SolrServerException {
        //配置任务调度更新Solr
        List<Classes> classess = classesDao.queryAll();
        System.out.println(classess);
        //将查询的数据加到索引库
        SolrInputDocument document = null;
        for (Classes classes : classess) {
            document = new SolrInputDocument();
            document.addField("cid", classes.getCid());
            document.addField("cname", classes.getCname());
            solrServer.add(document);
        }
        solrServer.commit();
    }
}
