package com.katsubo.service;

public abstract class ServiceFactory {
    public static Service getInstance(ServiceType serviceType){
        switch (serviceType){
            case TEXT_SERVICE:
                return TextService.getInstance();
                default:
                    throw new IllegalArgumentException("No such type of service!");
        }
    }
}
