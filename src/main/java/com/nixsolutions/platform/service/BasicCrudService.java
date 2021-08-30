package com.nixsolutions.platform.service;

import org.springframework.data.domain.Page;

import java.util.Map;

interface BasicCrudService<T> {

    void create(T t);

    void update(T t);

    void delete(Integer id);

    T find(Integer id);

}
