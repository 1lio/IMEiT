package ru.vyaacheslav.suhov.imeit.News;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class ImeitNews implements Runnable {

    Document doc;
    List<News> newsList;


    public ImeitNews(List<News> newsList) {
        System.out.println("creating thread kurdpress");
        this.newsList=newsList;
    }

    private void connectToSite(){


        try {
            doc = Jsoup.connect("http://imet.elsu.ru/").timeout(20000).get();
        } catch (IOException e) {
            e.printStackTrace();


        }

    }



    public void run() {
        System.out.println("run thread kurdoress");
        connectToSite();
        extractNews();

    }


    private List<News> extractNews(){

        // div with class=masthead
    //    Elements divs = doc.select("div.itemsHolder");
        Elements uls = doc.select("div.nm_post");
       // System.out.println("divs="+divs.size());
        System.out.println("uls="+uls.size());
      //  Elements spans = divs.select("span.flL curP mR5 mL5 alC oHid dBlk");
        //System.out.println("span="+ spans.size());

for (Element element:uls){
 //   Element ul = element.select("ul.dNon").first();

    String imageUrl=  element.select("div.nm_post_image").first().select("img").first().absUrl("src");
  String title=  element.select("h3.nm_post_title").first().text();
  String summary=  element.select("div.nm_post_content").first().text();
 /*   String newsUrl=  element.select("a.href").first().text();*/

    System.out.println("in kurdpress thread");
    System.out.println('\n'+" in kurdpress title:"+title);
    System.out.println('\n'+" in kurdpress image url:"+imageUrl);
    System.out.println('\n'+"in kurdpress summary:"+summary);


    News news=new News();
    news.setImageUrl(imageUrl);
    news.setSummary(summary);
    news.setTitle(title);
    /*news.setNewsUrl(newsUrl);*/

    newsList.add(news);



}


return newsList;


    }
}
