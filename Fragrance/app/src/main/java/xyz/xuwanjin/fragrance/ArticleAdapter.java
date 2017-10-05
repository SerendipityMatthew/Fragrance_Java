package xyz.xuwanjin.fragrance;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by xuwanjin on 10/4/17.
 */

public class ArticleAdapter extends ArrayAdapter<Article> {
    private int resourceId;
    public ArticleAdapter(@NonNull Context context, int resource, List<Article> articleList) {
        super(context, resource, articleList);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.articleImage = view.findViewById(R.id.article_image);
            viewHolder.articleSummary = view.findViewById(R.id.article_summary);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();
        }
        Article article = getItem(position);
//        viewHolder.articleImage.setImageResource(article.getArticleImage());
        viewHolder.articleSummary.setText(article.getArticleName());


        return view;
    }
    class ViewHolder{
        ImageView articleImage;
        TextView articleSummary;
    }
}
