package ru.vyaacheslav.suhov.imeit.News;


public class RowTapEvent {
    private News newsRow;

    public RowTapEvent(News newsRow) {
        this.newsRow = newsRow;
    }

    public News getTestRow() {
        return newsRow;
    }
}
