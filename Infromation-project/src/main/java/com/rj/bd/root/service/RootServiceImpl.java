package com.rj.bd.root.service;

import com.rj.bd.root.dao.RootDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RootServiceImpl implements IRootService{
    @Autowired
    public RootDao rootDao;
}
