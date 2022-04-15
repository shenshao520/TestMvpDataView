package com.aegis.testnewmvpdataview.utils;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.viewbinding.ViewBinding;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ViewBindingUtils {

    public static ViewBinding inflateWithGeneric(Context c, LayoutInflater inflater) {

        Type type = c.getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            try {
                Class clazz = (Class) ((ParameterizedType) type).getActualTypeArguments()[0];
                Method method = clazz.getMethod("inflate", LayoutInflater.class);
              return (ViewBinding) method.invoke(null, inflater);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;

    }


}
