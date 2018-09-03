package com.me.inner.util;

import com.me.inner.constant.CommonConstant;
import com.me.inner.dto.PaginationDTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Me on 2018/9/4.
 */
public class CommonUtil {

    private Logger logger = LoggerFactory.getLogger(CommonUtil.class);

    public static PaginationDTO packagePagination(HttpServletRequest request) {

        PaginationDTO pagination = new PaginationDTO();

        Integer curPage = 0;
        Integer limit = CommonConstant.Pagination.DEFAULT_LIMIT;
        Integer begin = 0;

        String curPageStr = request.getParameter(CommonConstant.Pagination.CURRENT_PAGE);
        if (StringUtils.isBlank(curPageStr)) {
            curPage = Integer.valueOf(curPageStr);
        }
        String limitStr = request.getParameter(CommonConstant.Pagination.LIMIT);
        if (StringUtils.isBlank(limitStr)) {
            limit = Integer.valueOf(limitStr);
        }

        begin = (curPage*limit) + 1;

        pagination.setCurPage(curPage);
        pagination.setLimit(limit);
        pagination.setBegin(begin);

        return pagination;
    }
}
