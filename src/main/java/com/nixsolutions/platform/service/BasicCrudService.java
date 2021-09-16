package com.nixsolutions.platform.service;

interface BasicCrudService<T> {

    void create(T t);

    void update(T t);

    void delete(Integer id);

    T find(Integer id);
}
