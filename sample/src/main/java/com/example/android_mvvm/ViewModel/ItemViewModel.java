package com.example.android_mvvm.ViewModel;

import android.view.View;

import com.example.android_mvvm.ReadOnlyField;
import com.example.android_mvvm.model.Item;

import rx.functions.Func1;
import rx.subjects.BehaviorSubject;

/**
 * Created by shashank on 11/7/16.
 */
public class ItemViewModel {

    public final Item item;
    public final BehaviorSubject<Integer> selectedQuantity;
    public final ReadOnlyField<Boolean> subtractQuantityVisibility;


    public ItemViewModel(Item item) {
        this.item = item;

        //can be created from source
        selectedQuantity = BehaviorSubject.create(0);

        subtractQuantityVisibility = new ReadOnlyField<>(selectedQuantity.map(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer quantity) {
                return quantity<=0;
            }
        }));
    }

    public void onAddClick(View view) {
        selectedQuantity.onNext(selectedQuantity.getValue()+1);
    }

    public void onSubtractClick(View view) {
        int newValue =  selectedQuantity.getValue();
        if(newValue >0) {
            newValue--;
        }
        selectedQuantity.onNext(newValue);
    }
}
