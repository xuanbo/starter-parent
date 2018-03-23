package com.xinqing.mongo.util;

import org.springframework.data.domain.Sort;

/**
 * mongo工具类
 *
 * Created by xuan on 2018/3/22
 */
public final class MongoUtil {

    private MongoUtil() {
    }

    public static Sort getCreateAtDescSort() {
        return new Sort(new Sort.Order(Sort.Direction.DESC, "createAt"));
    }

    public static Sort getIdDescSort() {
        return new Sort(new Sort.Order(Sort.Direction.DESC, "_id"));
    }

}
