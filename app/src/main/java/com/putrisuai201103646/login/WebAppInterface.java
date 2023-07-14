package com.putrisuai201103646.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.webkit.JavascriptInterface;

public class WebAppInterface {
    private Activity activity;
    private Context context;

    public WebAppInterface(Context context, Activity activity)
    {
        context = context;
        activity = activity;
    }

    @JavascriptInterface
    public void showSms()
    {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
        context.startActivity(intent);
    }
}
