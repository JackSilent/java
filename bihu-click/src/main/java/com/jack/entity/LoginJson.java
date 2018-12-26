package com.jack.entity;

public class LoginJson {

    public LoginJson() {
    }

    public LoginJson(String accessToken, String nonce, String userId, String memberId) {
        this.accessToken = accessToken;
        this.nonce = nonce;
        this.userId = userId;
        this.memberId = memberId;
    }

    private String accessToken;

    private String nonce;

    private String userId;

    private String memberId;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
}
