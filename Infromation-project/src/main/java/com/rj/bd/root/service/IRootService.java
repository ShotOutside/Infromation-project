package com.rj.bd.root.service;

import com.rj.bd.root.entity.Root;

import java.util.Map;

public interface IRootService {

    Root loginByRname(String rname);

    String selectEmail(String rname);
}
