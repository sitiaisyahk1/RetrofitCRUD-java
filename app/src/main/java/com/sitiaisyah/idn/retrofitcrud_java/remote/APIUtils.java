package com.sitiaisyah.idn.retrofitcrud_java.remote;

public class APIUtils {

    private APIUtils(){

    }

    public static final String API_URL = "http://192.168.1.9/MarketPlacess/index.php/";

    public static ProductService getProductService(){
        return RetrofitClient.getClient(API_URL).create(ProductService.class);
    }
}
