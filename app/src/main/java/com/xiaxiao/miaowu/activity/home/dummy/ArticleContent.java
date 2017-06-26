package com.xiaxiao.miaowu.activity.home.dummy;

import com.xiaxiao.miaowu.bean.Article;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class ArticleContent {

    /**
     * An array of sample (dummy) items.
     */
//    public static final List<Article> ITEMS = new ArrayList<Article>();
    public Article article;
    public String[] contents;
    public String firstImg="";

    public void parseArticle() {
        contents = article.getContents().split("####");
        for (String s:contents) {
            if (firstImg.equals("")) {
                if (s.contains("http:")&&!s.contains(".gif")) {
                    firstImg=s;
                }
            }

        }
    }

    public ArticleContent(Article article) {
        this.article = article;
        parseArticle();
    }

    @Override
    public String toString() {
        return "ArticleContent{" +
                "contents=" + Arrays.toString(contents) +
                ", firstImg='" + firstImg + '\'' +
                '}';
    }

    /* *//**
     * A map of sample (dummy) items, by ID.
     *//*
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 250;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(Article item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyItem createDummyItem(int position) {
        return new DummyItem(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    *//**
     * A dummy item representing a piece of content.
     *//*
    public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;

        public DummyItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }*/
}
