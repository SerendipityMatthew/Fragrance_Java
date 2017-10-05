package xyz.xuwanjin.fragrance;

/**
 * Created by xuwanjin on 10/4/17.
 */

public class Article {
    private String articleName;
    private String articleUrl;
    private String articleImage;

    @Override
    public String toString() {
        return "Article{" +
                "articleName='" + articleName + '\'' +
                ", articleUrl='" + articleUrl + '\'' +
                ", articleImage='" + articleImage + '\'' +
                '}';
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    public String getArticleImage() {
        return articleImage;
    }

    public void setArticleImage(String articleImage) {
        this.articleImage = articleImage;
    }
}
