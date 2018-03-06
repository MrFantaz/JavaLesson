package main.newsModel;

import java.util.Random;

public class NewsModel {
    private long date;
    private String text;
    private Random random = new Random();
    public NewsModel(){
        date=System.currentTimeMillis();
        text = "News number"+ random.nextInt(20);
    }
    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
