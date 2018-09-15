package com.me.inner.constant;

/**
 * Created by Me on 2018/9/4.
 */
public class CommonConstant {

    /**
     * 分页请求
     */
    public interface Pagination {
        String CURRENT_PAGE = "curPage";
        String LIMIT = "limit";
        Integer DEFAULT_LIMIT = 10;
    }

    /**
     * Yes or No
     */
    public interface YES_NO {
        String YES = "Y";
        String NO = "N";
    }

    /**
     * X-Frame-Options: DENY, SAMEORIGIN, ALLOW-FROM
     */
    public interface FrameOption {
        String DENY = "DENY";
        String SAMEORIGIN = "SAMEORIGIN";
        String ALLOW_FROM = "ALLOW-FROM";
    }

    /**
     * Active: A, I
     */
    public interface IN_ACTIVE {
        String ACTIVE = "A";
        String IN_ACTIVE = "I";
    }
}
