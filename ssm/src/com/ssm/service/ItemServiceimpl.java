package com.ssm.service;

import com.ssm.mapper.ItemsMapper;
import com.ssm.pojo.Items;
import com.ssm.pojo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceimpl implements ItemService {
    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<Items> selectList() {
        return itemsMapper.selectByExampleWithBLOBs(null);
    }

    @Override
    public Items selectbyid(Integer id) {
        return itemsMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Items items) {
       /* items.setCreatetime(new Date());*/
         itemsMapper.updateByPrimaryKeyWithBLOBs(items);
    }

    @Override
    public void delete(QueryVo vo){
        itemsMapper.deletetest(vo);
    }
}
