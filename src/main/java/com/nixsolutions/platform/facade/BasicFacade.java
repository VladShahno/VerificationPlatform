package com.nixsolutions.platform.facade;

import com.nixsolutions.platform.web.data.PageData;
import org.springframework.web.context.request.WebRequest;

interface BasicFacade<T> {

    void create(T t);

    void update(T t);

    void delete(Integer id);

    T find(Integer id);

    PageData<T> find(WebRequest request);
}
