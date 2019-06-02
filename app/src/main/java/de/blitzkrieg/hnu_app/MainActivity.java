package de.blitzkrieg.hnu_app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webView);
        webView.loadUrl("https://www.hs-neu-ulm.de/");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new MyWebViewClient());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    private class MyWebViewClient extends WebViewClient {
        //@Override
        /*public boolean shouldOverrideUrlLoading(WebView view, String url){
            if(Uri.parse(url).getHost().equals("https://www.hs-neu-ulm.de/") ||Uri.parse(url).getHost().equals("https://www.hs-neu-ulm.de/root-elemente/topnavigation/login/intranet/") || Uri.parse(url).getHost().equals("https://intranet.hs-neu-ulm.de/")){
                // This is my Website, so do not override; let my WebView load the page
                return false;
            }
            // Otherwise, the link is not for a page on my site, so launch another Activity that handle URLs
            String action;
            Uri uri;
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
            return true;
        }*/
    }

}

