package com.limo.service;

import java.util.List;

/**
 * @author lib97
 */
public interface UserService {
    List selectAll();

    String selectByPrimaryKey(int id);
}
