package ru.vyaacheslav.suhov.imeit.News;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

class ImeitNews implements Runnable {

    Document doc;
    List<News> newsList;


    ImeitNews(List<News> newsList) {
        this.newsList = newsList;
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

        Elements uls = doc.select("div.nm_post");

    for (Element element:uls){
    String imageUrl=  element.select("div.nm_post_image").first().select("img").first().absUrl("src");
    String title=  element.select("h3.nm_post_title").first().text();
    String summary=  element.select("div.nm_post_content").first().text();
    String newsUrl=  element.select("h3.nm_post_title").first().select("a").attr("abs:href");

    News news=new News();
    news.setImageUrl(imageUrl);
    news.setSummary(summary);
    news.setTitle(title);
    news.setNewsUrl(newsUrl);

    newsList.add(news);

}


return newsList;

    }
}
