package com.ssm.service;

import com.ssm.pojo.Items;
import com.ssm.pojo.QueryVo;

import java.util.List;

public interface ItemService {

    public List<Items> selectList();

    public Items selectbyid(Integer id);

    public void update(Items items);

    public void delete(QueryVo vo);
}
