//package com.adweb.adweb.utils;
//
//import java.io.IOException;
//import java.net.URI;
//import java.net.URL;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.client.HttpRequestRetryHandler;
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.client.methods.*;
//import org.apache.http.config.SocketConfig;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
//import org.apache.http.protocol.HttpContext;
//import org.apache.http.impl.client.cache.CacheConfig;
//import org.apache.http.impl.client.cache.CachingHttpClients;
//import org.apache.http.util.EntityUtils;
//
//public class ApiHttp {
//    private static CloseableHttpClient mHttpClient;
//
//    private static final String DEFAULT_UA =
//            "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36";
//
//    static {
//        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
//        cm.setMaxTotal(200);
//        cm.setDefaultMaxPerRoute(20);
//        RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(10000).setConnectTimeout(10000)
//                .setSocketTimeout(10000).build();
//        SocketConfig socketConfig = SocketConfig.custom().setSoKeepAlive(true).build();
//        CacheConfig cacheConfig = CacheConfig.custom().setMaxCacheEntries(1000).setMaxObjectSize(8192).build();
//        HttpClientBuilder builder = CachingHttpClients.custom().setCacheConfig(cacheConfig)
//                .setRetryHandler(new HttpRequestRetryHandler() {
//                    public boolean retryRequest(IOException arg0, int executionCount, HttpContext arg2) {
//                        return executionCount < 3;
//                    }
//                }).setConnectionManager(cm).setDefaultSocketConfig(socketConfig).setDefaultRequestConfig(config)
//                .setUserAgent(DEFAULT_UA);
//        mHttpClient = builder.build();
////		mHttpClient = HttpClientBuilder.create().build();
//    }
//
//
//    public static String doGet(String url){
//        try {
//            URL urlEntity = new URL(url);
//            URI uri = new URI(urlEntity.getProtocol(), urlEntity.getHost(), urlEntity.getPath(), urlEntity.getQuery(), null);
//
//            HttpGet get = new HttpGet(uri);
//
//            CloseableHttpResponse response = null;
//            try {
//                response = mHttpClient.execute(get);
//            } catch (Exception e) {
//                e.printStackTrace();
//                return "";
//            }
//
//            HttpEntity entity = null;
//            try {
//                entity = response.getEntity();
//                String ret = entity != null ? EntityUtils.toString(entity, "utf-8") : null;
//
//                return ret;
//            } finally {
//                if (response != null) {
//                    response.close();
//                }
//                try {
//                    EntityUtils.consume(entity);
//                } catch (Exception e) {
//
//                }
//            }
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//        return "";
//    }
//}
