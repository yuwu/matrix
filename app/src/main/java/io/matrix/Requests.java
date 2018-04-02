package io.matrix;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Requests {

    private OkHttpClient getDefaultOkHttpClient(){
        OkHttpClient.Builder build = new OkHttpClient.Builder();
                build.connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();

        final CookieJar cookieJar = new CookieJar() {
            @Override
            public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {

            }

            @Override
            public List<Cookie> loadForRequest(HttpUrl url) {
                return null;
            }
        };

        build.cookieJar(cookieJar);

        return build.build();
    }

    private Response get(String url){
        OkHttpClient client = getDefaultOkHttpClient();
        Request requestPost = new Request.Builder()
                .url(url)
                .get()
                .build();
        try {
            return client.newCall(requestPost).execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public Response login(String name, String pwd, String csrf){
        Response site = get("http://www.niuniuzai.com/user/account/login");



        OkHttpClient client = getDefaultOkHttpClient();
        FormBody.Builder body = new FormBody.Builder();
        body.add("name", name)
                .add("password", pwd)
                .add("csrf_doniuren", csrf);
        Request requestPost = new Request.Builder()
                .url("http://www.niuniuzai.com/user/account/login")
                .post(body.build())
                .build();
        try {
            return client.newCall(requestPost).execute();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
