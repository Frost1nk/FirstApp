package com.production.firstapp.utils;

import static com.production.firstapp.adapters.AdapterRecycleView.APP_VIEW_TYPE;
import static com.production.firstapp.adapters.AdapterRecycleView.CONTENT_VIEW_TYPE;

public class ContentUtils {
    public static final String APP = "App";
    public static final String CONTENT = "Content";

    public static int getViewType(String type){
        switch (type){
            case APP:
                return APP_VIEW_TYPE;
            case CONTENT:
                return CONTENT_VIEW_TYPE;
        }
        return 0;
    }
}
