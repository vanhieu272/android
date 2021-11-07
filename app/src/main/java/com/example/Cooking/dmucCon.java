package com.example.Cooking;

public class dmucCon {
    private int hinh;
    private String tenMon;
    private String nguoiDang;
    private String luotXem;
    private String luotThich;

    public dmucCon(int hinh, String tenMon, String nguoiDang, String luotXem, String luotThich) {
        this.hinh = hinh;
        this.tenMon = tenMon;
        this.nguoiDang = nguoiDang;
        this.luotXem = luotXem;
        this.luotThich = luotThich;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getNguoiDang() {
        return nguoiDang;
    }

    public void setNguoiDang(String nguoiDang) {
        this.nguoiDang = nguoiDang;
    }

    public String getLuotXem() {
        return luotXem;
    }

    public void setLuotXem(String luotXem) {
        this.luotXem = luotXem;
    }

    public String getLuotThich() {
        return luotThich;
    }

    public void setLuotThich(String luotThich) {
        this.luotThich = luotThich;
    }
}
