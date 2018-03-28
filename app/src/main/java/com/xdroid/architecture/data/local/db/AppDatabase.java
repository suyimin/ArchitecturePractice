package com.xdroid.architecture.data.local.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.xdroid.architecture.data.local.db.dao.GirlDao;
import com.xdroid.architecture.data.local.db.dao.ZhihuDao;
import com.xdroid.architecture.data.local.db.entity.Girl;
import com.xdroid.architecture.data.local.db.entity.ZhihuStory;

@Database(entities = {Girl.class, ZhihuStory.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract GirlDao girlDao();

    public abstract ZhihuDao zhihuDao();
}
