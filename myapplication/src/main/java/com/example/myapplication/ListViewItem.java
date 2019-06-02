package com.example.myapplication;

import android.media.Image;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class ListViewItem {
    private String title;
    private String uploader;
    private LocalDateTime date;
    private int icon;

    public String getTitle() {
        return title;
    }

    public String getUploader() {
        return uploader;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public int getIcon() {
        return icon;
    }

    public ListViewItem(String title, String uploader, LocalDateTime date, int icon) {
        this.title = title;
        this.uploader = uploader;
        this.date = date;
        this.icon = icon;
    }
}
