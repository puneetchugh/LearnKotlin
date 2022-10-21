package com.example.learningkotlin.sectionFour.chapter19;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MainClassJava {

    final String TAG = MainClassJava.class.getSimpleName();

    @NonNull
    String firstName;

    @Nullable
    String lastName;

    @NonNull
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NonNull
    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void printClass19() {
        String returnValue = Utils.getClassName();
        Log.e(TAG, "Inside printClass19(), class name is " + returnValue);
    }

    public void usingExtensionMethod() {
        String lastTwoChars = Utils.lastTwoChars("PuneetChugh");
        Log.e(TAG, "Inside usingExtensionMethod(), last two chars for PuneetChugh " + lastTwoChars);
    }

    public void accessingJvmFields() {

        Address newAddress = new Address("Street line 1", "street line 2", "city", "state", "89898");
        //Since all the properties are declared as JvmFields
        //newAddress.setAddress() is error
    }
}
