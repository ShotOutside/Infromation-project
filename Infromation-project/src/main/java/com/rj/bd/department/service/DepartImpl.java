package com.rj.bd.department.service;

import com.rj.bd.department.dao.DepartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ShiJie
 * @desc
 * @time 2021-05-31-16:47
 */
@Service
public class DepartImpl implements IDepartService{
    @Autowired
    public DepartDao departDao;
}
