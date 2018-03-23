package com.xinqing.mongo.dao;

import com.xinqing.mongo.entity.Entity;
import com.xinqing.mongo.vo.PageVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

/**
 * base dao
 *
 * Created by xuan on 2018/3/22
 */
public interface BaseDao<T extends Entity> {

    /**
     * 根据id查询记录
     *
     * @param id 记录id
     * @return T
     */
    T findById(String id);

    /**
     * 批量获取记录
     *
     * @param ids 记录id集合
     * @return List<T>
     */
    List<T> findByIds(List<String> ids);

    /**
     * 查询一条记录
     *
     * @param query Query
     * @return T
     */
    T findOne(Query query);

    /**
     * 查询多条记录
     *
     * @param query Query
     * @return List<T>
     */
    List<T> find(Query query);

    /**
     * 统计记录条数
     *
     * @param query Query
     * @return Long
     */
    Long count(Query query);

    /**
     * 插入记录
     *
     * @param entity T
     */
    void insert(T entity);

    /**
     * 插入或更新记录
     *
     * @param entity T
     */
    void save(T entity);

    /**
     * 更新所有满足条件的记录
     *
     * @param query Query
     * @param update Update
     */
    void update(Query query, Update update);

    /**
     * 根据id删除记录
     *
     * @param id 记录id
     */
    void deleteById(String id);

    /**
     * 批量删除记录
     *
     * @param ids 记录集合
     */
    void deleteByIds(List<String> ids);

    /**
     * 删除记录
     *
     * @param query Query
     */
    void delete(Query query);

    /**
     * 分页获取数据，_id降序获取数据
     *
     * @param criteria 查询条件
     * @param endId 最后一条记录(不包括)
     * @param limit 每页获取数目
     * @return PageVO<T>
     */
    PageVO<T> page(Criteria criteria, String endId, Integer limit);

    /**
     * 分页获取数据
     *
     * @param criteria 查询条件
     * @param sort 排序
     * @param endId 最后一条记录(不包括)
     * @param limit 每页获取数目
     * @return PageVO<T>
     */
    PageVO<T> page(Criteria criteria, Sort sort, String endId, Integer limit);

    /**
     * 分页获取数据
     *
     * @param criteria 查询条件
     * @param pageable 分页信息
     * @return Page<T>
     */
    Page<T> page(Criteria criteria, Pageable pageable);
}
