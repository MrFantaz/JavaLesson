package main;

import main.newsModel.NewsModel;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        NewsGeneration.getInstance().addListener(new FirstListener());
        NewsGeneration.getInstance().addListener(new NewsGeneration.NewsListener() {
            @Override
            public void onNewsReceived(NewsModel newsModel) {
                System.out.println(this.getClass().getSimpleName()+" "+newsModel.getText());
            }
        });

       while ((!sc.nextLine().equalsIgnoreCase("stop"))){
            NewsGeneration.getInstance().stopSelf();
       }

    }
    static class FirstListener implements NewsGeneration.NewsListener{

        @Override
        public void onNewsReceived(NewsModel newsModel) {
            System.out.println(this.getClass().getSimpleName()+" "+newsModel.getText());
        }
    }
}
