package com.xdroid.architecture.data.local.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.xdroid.architecture.data.local.db.entity.ZhihuStory;

import java.util.List;

@Dao
public interface ZhihuDao {

    @Query("SELECT * FROM zhihustorys")
    List<ZhihuStory> loadAllZhihus();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertZhihuList(List<ZhihuStory> girls);
}
