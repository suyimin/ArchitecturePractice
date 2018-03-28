package com.xdroid.architecture.data.local.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.xdroid.architecture.data.local.db.entity.Girl;

import java.util.List;

@Dao
public interface GirlDao {

    @Query("SELECT * FROM girls")
    List<Girl> loadAllGirls();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertGirls(List<Girl> girls);

    @Query("SELECT * FROM girls WHERE _id = :id")
    LiveData<Girl> loadGirl(String id);

    @Query("SELECT * FROM girls WHERE _id = :id")
    Girl loadGirlSync(String id);
}
