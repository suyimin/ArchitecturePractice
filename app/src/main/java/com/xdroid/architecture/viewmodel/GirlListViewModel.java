package com.xdroid.architecture.viewmodel;

import android.app.Application;
import android.arch.core.util.Function;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.xdroid.architecture.MyApplication;
import com.xdroid.architecture.data.DataRepository;
import com.xdroid.architecture.data.local.db.entity.Girl;
import com.xdroid.architecture.utils.Util;

import java.util.List;

public class GirlListViewModel extends AndroidViewModel {

    private final MutableLiveData<Integer> mGirlPageIndex = new MutableLiveData<>();

    private final LiveData<List<Girl>> mGirls;

    private DataRepository mGirlsDataRepository = null;

    private GirlListViewModel(Application application, DataRepository girlsDataRepository) {
        super(application);
        mGirlsDataRepository = girlsDataRepository;
        mGirls = Transformations.switchMap(mGirlPageIndex, new Function<Integer, LiveData<List<Girl>>>() {
            @Override
            public LiveData<List<Girl>> apply(Integer input) {
                return mGirlsDataRepository.getGirlList(input);
            }
        });
    }

    public LiveData<List<Girl>> getGilrsLiveData() {
        return mGirls;
    }

    public void refreshGrilsData() {
        mGirlPageIndex.setValue(1);
    }

    public void loadNextPageGirls() {
        if (!Util.isNetworkConnected(MyApplication.getInstance())) {
            return;
        }
        mGirlPageIndex.setValue((mGirlPageIndex.getValue() == null ? 1 : mGirlPageIndex.getValue() + 1));
    }

    public LiveData<Boolean> getLoadMoreState() {
        return mGirlsDataRepository.isLoadingGirlList();
    }

    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private final Application mApplication;

        private final DataRepository mGirlsDataRepository;

        public Factory(@NonNull Application application, DataRepository girlsDataRepository) {
            mApplication = application;
            mGirlsDataRepository = girlsDataRepository;
        }

        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            return (T) new GirlListViewModel(mApplication, mGirlsDataRepository);
        }
    }
}
