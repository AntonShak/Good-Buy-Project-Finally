package com.shakov.goodbuyproject.mapper;

public interface Mapper <F, T> {

    T map(F from);

    default T map(F fromobject, T toObject) {
        return toObject;
    }

}
