package xyz.xuwanjin.fragrance;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Article> articleList = new ArrayList<>();
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        for (int i = 0; i < 10; i++){
            Article article = new Article();
            article.setArticleName(i + "----");
            articleList.add(article);
        }

        ArticleAdapter articleAdapter = new ArticleAdapter(MainActivity.this,
                R.layout.article_list_content, articleList);
        ListView listView = (ListView) findViewById(R.id.article_list_view);
        listView.setAdapter(articleAdapter);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
