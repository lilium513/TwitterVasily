package com.liliumproject.android.twittervasily;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.twitter.sdk.android.core.services.StatusesService;
import com.twitter.sdk.android.tweetui.SearchTimeline;
import com.twitter.sdk.android.tweetui.TweetTimelineRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity  {
    TwitterLoginButton loginButton;
    TwitterSession session;
    TwitterAuthToken authToken;
    String token;
    String secret;
    TextView t;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Twitter.initialize(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final SearchTimeline searchTimeline = new SearchTimeline.Builder().languageCode("ja").query("iQON")
                .maxItemsPerRequest(1000).resultType(SearchTimeline.ResultType.RECENT)
                .build();
        final TweetTimelineRecyclerViewAdapter adapter =
                new TweetTimelineRecyclerViewAdapter.Builder(this)
                        .setTimeline(searchTimeline)
                        .setViewStyle(R.style.tw__TweetLightWithActionsStyle)
                        .build();



        recyclerView.setAdapter(adapter);

//        t= (TextView) findViewById(R.id.textView);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
////        loginButton = (TwitterLoginButton) findViewById(R.id.login_button);
////        loginButton.setCallback(new Callback<TwitterSession>() {
////            @Override
////            public void success(Result<TwitterSession> result) {
////                // Do something with result, which provides a TwitterSession for making API calls
////                session = TwitterCore.getInstance().getSessionManager().getActiveSession();
////                 authToken = session.getAuthToken();
////                 token = authToken.token;
////                 secret = authToken.secret;
////                t.setText("さくせす!");
////                TwitterApiClient twitterApiClient = TwitterCore.getInstance().getApiClient();
////                StatusesService statusesService = twitterApiClient.getStatusesService();
////            }
//
//            @Override
//            public void failure(TwitterException exception) {
//                // Do something on failure
//            }
//        });
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Pass the activity result to the login button.
        loginButton.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
