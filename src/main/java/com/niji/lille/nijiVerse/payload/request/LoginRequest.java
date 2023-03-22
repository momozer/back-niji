package com.niji.lille.nijiVerse.payload.request;

public class LoginRequest {

    private String username;


    private String motPasse;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }
}
