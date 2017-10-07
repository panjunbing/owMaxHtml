package com.owmax.service;

import com.owmax.model.Data;

import java.util.List;

public interface DataService extends BaseService<Data>{

    public List queryDataByUserID(int userID);

    public  Data queryHeroDataByUserID(int userID,String hero);
}
