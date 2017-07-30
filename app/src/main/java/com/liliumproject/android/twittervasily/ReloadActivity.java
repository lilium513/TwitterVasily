package com.liliumproject.android.twittervasily;

import android.os.AsyncTask;

import com.twitter.sdk.android.tweetui.SearchTimeline;
import com.twitter.sdk.android.tweetui.TweetTimelineRecyclerViewAdapter;

/**
 * Created by kt on 2017/07/30.
 */

public class ReloadActivity extends AsyncTask<SearchTimeline,Integer,TweetTimelineRecyclerViewAdapter>{




    @Override
    protected TweetTimelineRecyclerViewAdapter doInBackground(SearchTimeline... searchTimelines) {
        return null;
    }
}
