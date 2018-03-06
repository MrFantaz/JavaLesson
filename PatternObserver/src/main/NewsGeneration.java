package main;

import main.newsModel.NewsModel;

import java.util.LinkedList;
import java.util.List;

public class NewsGeneration extends Thread {
    private volatile boolean stats=true;
    private List<NewsListener> list = new LinkedList<>();
    private static NewsGeneration instance;
    private static long time = System.currentTimeMillis();
    private NewsGeneration(){
      start();
    }
    public static NewsGeneration getInstance(){
        synchronized (NewsGeneration.class){
        if(instance ==null){
            instance= new NewsGeneration();
        }
        return instance;}
    }
    public void addListener(NewsListener newsListener){
        list.add(newsListener);
    }
    public void removeListener(NewsListener newsListener){
        list.remove(newsListener);
    }
   public void stopSelf(){
        stats=false;
   }
    @Override
    public void run() {
      while (stats){
          if(time<=System.currentTimeMillis()+1000) {
              NewsModel newsModel = new NewsModel();
              for (NewsListener l:list) {

              }
          }
      }
    }

    public interface NewsListener{
        void onNewsReceived(NewsModel newsModel);

    }
}
