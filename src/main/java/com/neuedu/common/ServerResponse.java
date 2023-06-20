package com.neuedu.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ServerResponse {

    private Integer status; // result status: 1 success; 2 failure
    private String message; // reminding message
    private Map<String, Object> data = new HashMap<>(); // returned data

    private ServerResponse(){

    }

//    success method
    public static ServerResponse success(String message){
        ServerResponse serverResponse = new ServerResponse();
        serverResponse.setStatus(Constants.SUCCESS);
        serverResponse.setMessage(message);
        return serverResponse;
    }

//    add data if success
    public ServerResponse addData(String key, Object value){
        this.data.put(key, value);
        return this;
    }

//    failure method
    public static ServerResponse failure(String message){
        ServerResponse serverResponse = new ServerResponse();
        serverResponse.setStatus(Constants.FAILURE);
        serverResponse.setMessage(message);
        return serverResponse;
    }
}
