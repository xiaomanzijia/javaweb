package com.lsgx.admin.mapper;

import java.util.List;

public interface BaseMapper<T>
{
    public int save(T data);
    
    public int delete(int id);

    public int update(T data);
    
    public int count(T data);
    
    public List<T> queryAll();

    public T queryById(int id);
    
    public T queryByLock(Integer id);
    
    public List<T> queryByParam(T param);
    
    public List<T> queryByCache(T param);
    
    /**
     * 上一条记录
     * @param id
     * @return
     * @author  Jfeng
     */
    public T queryPreviousRecord(Integer id);
    
    /**
     * 下一条记录
     * @param id
     * @return 
     * @author  Jfeng
     */
    public T queryNextRecord(Integer id);

}
