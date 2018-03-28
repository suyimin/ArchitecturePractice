package com.xdroid.architecture.data.remote.model;

import com.xdroid.architecture.data.local.db.entity.Girl;

import java.util.List;

public class GirlData {

    public final boolean error;

    public final List<Girl> results;

    public GirlData(boolean error, List<Girl> results) {
        this.error = error;
        this.results = results;
    }
}
