package ru.vyaacheslav.suhov.imeit.News;

 class News {
    private String title;
    private String summary;
    private String imageUrl;

     String getImageUrl() {
        return imageUrl;
    }

     void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

     String getSummary() {
        return summary;
    }

     void setSummary(String summary) {
        this.summary = summary;
    }
}
