package com.rj.bd.root.service;

import java.util.Map;

public interface IRootService {
    Map<String, Object> login(String code, String rname);
}
