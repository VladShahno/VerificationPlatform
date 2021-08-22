package com.nixsolutions.platform.facade;

interface BasicFacade<T> {

    void create(T t);

    void update(T t);

    void delete(Integer id);

    T find(Integer id);
}
