package com.xinqing.redis.func;

/**
 * 错误回调
 *
 * Created by xuan on 2018/3/23
 */
@FunctionalInterface
public interface ErrorCallback<T> {

    /**
     * 处理错误
     *
     * @param t Throwable
     * @return 错误情况处理返回结果
     */
    T onError(Throwable t);

}
