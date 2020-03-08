package com.production.firstapp.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.production.firstapp.models.Model;

import java.util.List;

public class ContentViewModel extends AndroidViewModel {

    private MutableLiveData<List<Model>> mutableLiveData = new MutableLiveData<>();
    private String mItemFile;

    public ContentViewModel(@NonNull Application application,String itemFile) {
        super(application);
        mItemFile = itemFile;
    }

    private void reloadData(){

    }

    public LiveData<List<Model>> getItems(){
        if(mutableLiveData.getValue() == null){
            reloadData();
        }
        return mutableLiveData;
    }


    /**
     * фабрика для создания ViewModel
     */

    public static class ContentViewModelFactory extends ViewModelProvider.NewInstanceFactory{
        private Application mApplication;
        private String itemsFile;

        public ContentViewModelFactory(Application application,String itemsFile){
            mApplication = application;
            this.itemsFile = itemsFile;
        }

        @Override
        public <T extends ViewModel> T create(Class<T> modelClass){
            return (T) new ContentViewModel(mApplication,itemsFile);
        }
    }

}
