package com.example.aplikasifremilt;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class FremiltData {
    Context context;
    List<FremiltModel> fremiltModels = new ArrayList<>();
    MainView view;
    public FremiltData(MainView view, Context context){
        this.view=view;
        this.context=context;
    }

    public void setData(){
        FremiltModel destinasi;
        destinasi= new FremiltModel("Thai Black Coffee" , R.drawable.bc, "Rp.6.000");
        fremiltModels.add(destinasi);
        destinasi= new FremiltModel("Thai Black Tea" ,R.drawable.black, "Rp. 6.000");
        fremiltModels.add(destinasi);
        destinasi= new FremiltModel("Thai Cocoa" , R.drawable.cocoa, "Rp. 10.000");
        fremiltModels.add(destinasi);
        destinasi= new FremiltModel("Thai Coffee" , R.drawable.coffee, "Rp. 9.000");
        fremiltModels.add(destinasi);
        destinasi= new FremiltModel("Thai Green tea" ,R.drawable.green, "Rp. 10.000");
        fremiltModels.add(destinasi);
        destinasi= new FremiltModel("Thai Coffee Late", R.drawable.latte, "Rp.10.000");
        fremiltModels.add(destinasi);
        destinasi= new FremiltModel("Thai Tea Original", R.drawable.ori,"Rp. 9.000");
        fremiltModels.add(destinasi);
        destinasi= new FremiltModel("Thai Pure Green Tea", R.drawable.pure, "Rp.7.000");
        fremiltModels.add(destinasi);
        view.onSuccess(fremiltModels);
    }
}
