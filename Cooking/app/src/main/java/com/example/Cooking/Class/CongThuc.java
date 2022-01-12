package com.example.Cooking.Class;

public class CongThuc {
    private Long id;
    private String congThuc;
    private String maCT;
    private String monCT;

    public CongThuc(Long id, String congThuc, String maCT, String monCT) {
        this.id = id;
        this.congThuc = congThuc;
        this.maCT = maCT;
        this.monCT = monCT;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCongThuc() {
        return congThuc;
    }

    public void setCongThuc(String congThuc) {
        this.congThuc = congThuc;
    }

    public String getMaCT() {
        return maCT;
    }

    public void setMaCT(String maCT) {
        this.maCT = maCT;
    }

    public String getMonCT() {
        return monCT;
    }

    public void setMonCT(String monCT) {
        this.monCT = monCT;
    }
}
