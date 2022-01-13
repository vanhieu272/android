package com.example.Cooking.Class;

import java.util.ArrayList;
import java.util.List;

public class HistoryFind {
    private Long id;
    private String noiDung;
    private String userName;

    public HistoryFind(String noiDung, String userName) {
        this.noiDung = noiDung;
        this.userName = userName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
