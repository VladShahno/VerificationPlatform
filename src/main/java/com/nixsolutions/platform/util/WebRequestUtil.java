package com.nixsolutions.platform.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WebRequestUtil {

    public static final String PAGE_PARAM = "page";
    public static final String SIZE_PARAM = "size";
    public static final String SORT_PARAM = "sort";
    public static final String ORDER_PARAM = "order";
    public static final String DEFAULT_SORT_PARAM_VALUE = "created";
    public static final String DEFAULT_ORDER_PARAM_VALUE = "desc";
    public static final int DEFAULT_PAGE_PARAM_VALUE = 1;
    public static final int DEFAULT_SIZE_PARAM_VALUE = 10;

    public static Map<String, String> getParametersMap(WebRequest request) {
        String page = request.getParameter(PAGE_PARAM) != null ? request.getParameter(PAGE_PARAM) : String.
                valueOf(DEFAULT_PAGE_PARAM_VALUE);
        String size = request.getParameter(SIZE_PARAM) != null ? request.getParameter(SIZE_PARAM) : String.
                valueOf(DEFAULT_SIZE_PARAM_VALUE);
        String sort = StringUtils.isNotBlank(request.getParameter(SORT_PARAM)) ? Objects.
                requireNonNull(request.getParameter(SORT_PARAM)) : DEFAULT_SORT_PARAM_VALUE;
        String order = StringUtils.isNotBlank(request.getParameter(ORDER_PARAM)) ? Objects.
                requireNonNull(request.getParameter(ORDER_PARAM)) : DEFAULT_ORDER_PARAM_VALUE;
        Map<String, String> dataTableMap = new HashMap<>();
        dataTableMap.put(PAGE_PARAM, page);
        dataTableMap.put(SIZE_PARAM, size);
        dataTableMap.put(SORT_PARAM, sort);
        dataTableMap.put(ORDER_PARAM, order);
        return dataTableMap;
    }
}
