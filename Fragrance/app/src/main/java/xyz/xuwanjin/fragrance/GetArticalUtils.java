package xyz.xuwanjin.fragrance;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by xuwanjin on 10/8/17.
 */

public class GetArticalUtils {
    public static final String NETWORK_GET = "";
    public static final String TEST_ARTICLE_URL= "https://www.theatlantic.com/technology/archive/2017/09/saving-the-world-from-code/540393/";
    public static void getArticleFromWeb(String articleURl) {
        URL url;
        HttpURLConnection httpURLConnection = null;
        try {
            url = new URL(articleURl);
            try {
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setConnectTimeout(3000);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setReadTimeout(3000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("GET");
                int resultCode = httpURLConnection.getResponseCode();
                System.out.println(resultCode + "qqqq");
                if (resultCode == HttpsURLConnection.HTTP_OK) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String str = null;
                    StringBuffer stringBuffer = new StringBuffer();
                    while ((str = bufferedReader.readLine()) != null) {
                        stringBuffer.append(str);
                    }
                    System.out.println(stringBuffer.toString()+"wwwww");
                    inputStream.close();
                    bufferedReader.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }

    public static void main(String[] args){
        getArticleFromWeb(TEST_ARTICLE_URL);
    }
}
