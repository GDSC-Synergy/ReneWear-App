package com.synergy.renewear.menu;

import com.synergy.renewear.R;

import java.util.ArrayList;

public class ArrayListMenu {
    public ArrayList<MenuModel> setListData(){
        ArrayList<MenuModel> arrayList = new ArrayList<>();
        arrayList.add(new MenuModel(R.drawable.media,"Thrift"));
        arrayList.add(new MenuModel(R.drawable.media,"Remake"));
        arrayList.add(new MenuModel(R.drawable.media,"Donate"));
        arrayList.add(new MenuModel(R.drawable.media,"Recycle"));

        return arrayList;
    }
}
