package com.hadicha.zeonshop.mapper;

import com.hadicha.zeonshop.dto.NewsRequest;
import com.hadicha.zeonshop.dto.NewsResponse;
import com.hadicha.zeonshop.entity.News;
import org.springframework.stereotype.Component;

@Component
public class NewsMapper extends AbstractMapper<News, NewsResponse> {

    public NewsMapper() {
        super(News.class,NewsResponse.class);
    }
    public News save(NewsRequest request){
        News news=new News();
        news.setNews(request.getNews());
        news.setTeam(request.getTeam());
        return news;
    }
}
