package com.example.Cooking.Class;

public class AnhCongThuc {
    private Long id;
    private String anh;
    private String maCT;

    public AnhCongThuc(Long id, String anh, String maCT) {
        this.id = id;
        this.anh = anh;
        this.maCT = maCT;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getMaCT() {
        return maCT;
    }

    public void setMaCT(String maCT) {
        this.maCT = maCT;
    }
}
