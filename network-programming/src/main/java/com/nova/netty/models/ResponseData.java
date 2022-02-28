package com.nova.netty.models;

import lombok.Getter;
import lombok.Setter;

public class ResponseData {

    @Getter
    @Setter
    private int intValue;

    @Override
    public String toString() {
        return "ResponseData{" +
                "intValue=" + intValue +
                '}';
    }
}
