package com.spring.mybatis.service.impl;

import com.spring.mybatis.mapper.ResourcesMapper;
import com.spring.mybatis.model.Resources;
import com.spring.mybatis.service.ResourcesService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jiayongming on 2017/4/21.
 */
public class ResourcesServiceImpl implements ResourcesService{

    @Resource
    private ResourcesMapper resourcesMapper ;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return resourcesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Resources record) {
        return resourcesMapper.insert(record);
    }

    @Override
    public Resources selectByPrimaryKey(Integer id) {
        return resourcesMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Resources> selectAll() {
        return resourcesMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Resources record) {
        return resourcesMapper.updateByPrimaryKey(record);
    }
}
