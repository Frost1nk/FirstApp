package com.production.firstapp.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.production.firstapp.models.Model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ContentViewModel extends AndroidViewModel {

    private MutableLiveData<List<Model>> mutableLiveData = new MutableLiveData<>();
    private String mItemFile;

    public ContentViewModel(@NonNull Application application,String itemFile) {
        super(application);
        this.mItemFile = itemFile;
    }

    private void reloadData(){
        List<Model> models = new ArrayList<>();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("type","Content");
            jsonObject.put("name","Content");
            jsonObject.put("imageLink","https://f.vividscreen.info/soft/6cf540841c8ce488bcfea9b5cda77626/Saint-Isaacs-Cathedral-in-Saint-Petersburg-wide-i.jpg");
        } catch (JSONException e){
            e.printStackTrace();
        }
        models.add(new Model(jsonObject));
        models.add(new Model(jsonObject));
        models.add(new Model(jsonObject));
        models.add(new Model(jsonObject));
        models.add(new Model(jsonObject));
        models.add(new Model(jsonObject));
        models.add(new Model(jsonObject));
        models.add(new Model(jsonObject));
        models.add(new Model(jsonObject));
        models.add(new Model(jsonObject));

        mutableLiveData.postValue(models);
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
