package com.putrisuai201103646.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.text.DecimalFormat;

import cz.msebera.android.httpclient.Header;

public class ForexMainActivity extends AppCompatActivity {
    private ProgressBar loadingProgressBar;
    private SwipeRefreshLayout swipeRefreshLayout1;
    private TextView idrTextView, usdTextView, aedTextView, afnTextView, allTextView, amdTextView, angTextView, aoaTextView, arsTextView, audTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forex_main);

        swipeRefreshLayout1 = (SwipeRefreshLayout)findViewById(R.id.swipeRefreshLayout1);
        idrTextView = (TextView)findViewById(R.id.idrTextView);
        usdTextView = (TextView)findViewById(R.id.usdTextView);
        aedTextView = (TextView)findViewById(R.id.aedTextView);
        afnTextView = (TextView)findViewById(R.id.afnTextView);
        allTextView = (TextView)findViewById(R.id.allTextView);
        amdTextView = (TextView)findViewById(R.id.amdTextView);
        angTextView = (TextView)findViewById(R.id.angTextView);
        aoaTextView = (TextView)findViewById(R.id.aoaTextView);
        arsTextView = (TextView)findViewById(R.id.arsTextView);
        audTextView = (TextView)findViewById(R.id.audTextView);
        loadingProgressBar = (ProgressBar)findViewById(R.id.loadingProgressBar);

        initSwipeRefreshLayout();
        initForex();
    }

    private void initSwipeRefreshLayout() {
        swipeRefreshLayout1.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initForex();

                swipeRefreshLayout1.setRefreshing(false);

            }
        });
    }

    public String formatNumber(double number, String format) {
        DecimalFormat decimalFormat = new DecimalFormat(format);
        return decimalFormat.format(number);
    }

    private void initForex() {
        loadingProgressBar.setVisibility(TextView.VISIBLE);

        String url = "https://openexchangerates.org/api/latest.json?app_id=7638f4803e3c421eb43e6061b621a1d3";

        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        asyncHttpClient.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Log.d("*ps*", new String(responseBody));

                Gson gson = new Gson();
                ForexRootModel rootModel = gson.fromJson(new String(responseBody), ForexRootModel.class);
                ForexRatesModel ratesModel = rootModel.getRatesModel();

                double idr = ratesModel.getIDR();
                double usd = ratesModel.getIDR() / ratesModel.getUSD();
                double aed = ratesModel.getIDR() / ratesModel.getAED();
                double afn = ratesModel.getIDR() / ratesModel.getAFN();
                double all = ratesModel.getIDR() / ratesModel.getALL();
                double amd = ratesModel.getIDR() / ratesModel.getAMD();
                double ang = ratesModel.getIDR() / ratesModel.getANG();
                double aoa = ratesModel.getIDR() / ratesModel.getAOA();
                double ars = ratesModel.getIDR() / ratesModel.getARS();
                double aud = ratesModel.getIDR() / ratesModel.getAUD();

                idrTextView.setText(formatNumber(idr, "###,##0.##"));
                usdTextView.setText(formatNumber(usd, "###,##0.##"));
                aedTextView.setText(formatNumber(aed, "###,##0.##"));
                afnTextView.setText(formatNumber(afn, "###,##0.##"));
                allTextView.setText(formatNumber(all, "###,##0.##"));
                amdTextView.setText(formatNumber(amd, "###,##0.##"));
                angTextView.setText(formatNumber(ang, "###,##0.##"));
                aoaTextView.setText(formatNumber(aoa, "###,##0.##"));
                arsTextView.setText(formatNumber(ars, "###,##0.##"));
                audTextView.setText(formatNumber(aud, "###,##0.##"));

                loadingProgressBar.setVisibility(TextView.INVISIBLE);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();

                loadingProgressBar.setVisibility(TextView.INVISIBLE);

            }
        });
    }
}