package com.niji.lille.nijiVerse.webSocket;

public class ParkingResponse {
    String content;
    public ParkingResponse(){

    }

    public String getContent(){
        return content;
    }

    public ParkingResponse (String content){
        this.content = content;
    }

}
