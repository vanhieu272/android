package com.example.Cooking.Class;

public class ThongBao {
    private Long id;
    private String noiDung;
    private String user;
    private int status;
    private Long maMon;

    public ThongBao(Long id, String noiDung, String user, int status, Long maMon) {
        this.id = id;
        this.noiDung = noiDung;
        this.user = user;
        this.status = status;
        this.maMon = maMon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getMaMon() {
        return maMon;
    }

    public void setMaMon(Long maMon) {
        this.maMon = maMon;
    }
}
