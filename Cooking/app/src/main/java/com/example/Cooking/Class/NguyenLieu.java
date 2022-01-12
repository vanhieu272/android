package com.example.Cooking.Class;

public class NguyenLieu {

    private Long id;
    private String ten;
    private String dinhLuong;
    private String maMon;

    public NguyenLieu(Long id, String ten, String dinhLuong, String maMon) {
        this.id = id;
        this.ten = ten;
        this.dinhLuong = dinhLuong;
        this.maMon = maMon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDinhLuong() {
        return dinhLuong;
    }

    public void setDinhLuong(String dinhLuong) {
        this.dinhLuong = dinhLuong;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }
}
