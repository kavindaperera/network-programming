package com.nova.netty.models;

import lombok.Getter;
import lombok.Setter;

public class RequestData {

    @Getter
    @Setter
    private int intValue;

    @Getter
    @Setter
    private String stringValue;

    @Override
    public String toString() {
        return "RequestData{" +
                "intValue=" + intValue +
                ", stringValue='" + stringValue + '\'' +
                '}';
    }
}
