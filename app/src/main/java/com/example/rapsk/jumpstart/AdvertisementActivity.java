package com.example.rapsk.jumpstart;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rapsk.jumpstart.Adapter.ViewPagerAdapter;
import com.example.rapsk.jumpstart.Models.Investor;
import com.example.rapsk.jumpstart.Models.Location;
import com.example.rapsk.jumpstart.Models.MainActivity;
import com.example.rapsk.jumpstart.Models.Milestones;
import com.example.rapsk.jumpstart.Models.Project;
import com.example.rapsk.jumpstart.Models.SME;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.apache.http.cookie.SM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by cicct on 8/25/2016.
 */
public class AdvertisementActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private TextView mSMEName,mSMEDesc,mNeededFund,mReceivedFund,mProjectProg;
    private ProgressBar mPrgProject;
    public static final String API_KEY = "AIzaSyDkvVOvdSVoFSQBzkDdvmpH9yKbDzyBF7Y";
    public static final String VIDEO_ID = "acqGJy-c9N4";
    public static final String TAG = AdvertisementActivity.class.getSimpleName();

    private FirebaseDatabase dbRef;
    private DatabaseReference dbFirebase;


    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private ArrayList<Project> project_list;

    List<SME> smeList = new ArrayList<>();
    ViewPager viewPager;
    PagerAdapter adapter;
    String[] smeNames = new String[smeList.size()];
    int[] smeNeededFund,smeReceivedFund;

    SME sme = new SME();
    Project project = new Project();
    Location location = new Location();
    Milestones milestones = new Milestones();
    Investor investor = new Investor();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youtubeapi_activity);
        mSMEDesc = (TextView) findViewById(R.id.smeDesc);
        mSMEName = (TextView) findViewById(R.id.smeName);
        mReceivedFund = (TextView) findViewById(R.id.receivedFund);
        mNeededFund = (TextView) findViewById(R.id.neededFund);
        mPrgProject = (ProgressBar) findViewById(R.id.prgProject);
        mProjectProg = (TextView) findViewById(R.id.prgLabel);
        dbRef = FirebaseDatabase.getInstance();
//        dbRef.setPersistenceEnabled(true);
        dbFirebase = dbRef.getReference("Jumpstart/SME's");
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);
        youTubePlayerView.initialize(API_KEY,this);


        dbFirebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                smeList = new ArrayList<>();
                Iterable<DataSnapshot> snapshotIterable = dataSnapshot.getChildren();
                Iterator<DataSnapshot> iterator = snapshotIterable.iterator();

                while(iterator.hasNext()){
                    SME sme = iterator.next().getValue(SME.class);
                    smeList.add(sme);
                }
                System.out.println(""+smeList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
//                viewPager = (ViewPager) findViewById(R.id.pager);
//                adapter = new ViewPagerAdapter(AdvertisementActivity.this,smeNames,smeNeededFund,smeReceivedFund);
//                viewPager.setAdapter(adapter);


    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
       youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        youTubePlayer.setPlaybackEventListener(playbackEventListener);

        if(!wasRestored){
            youTubePlayer.getDurationMillis();
            youTubePlayer.loadVideo(VIDEO_ID);
        }
    }
//
////    @Override
////    protected void onStart() {
////        super.onStart();
////        project_list = new ArrayList<>();
////        String key = dbFirebase.push().getKey();
////        location = new Location(192.15,192.31,"Basak");
////        project_list.add(new Project(1,"Cookies","Cookies so delicious","https://www.youtube.com/watch?v=4_SdDR5OU00",123456,"Pastries",35,1000,milestones,0,12.01,10.01,1));
////        project_list.add(new Project(2,"Bread","Bread affordable","https://www.youtube.com/watch?v=4_SdDR5OU00",5000,"Pastries",5,500,milestones,0,12.01,10.01,1));
////        SME sme = new SME("1","McDonalds","https://www.youtube.com/watch?v=4_SdDR5OU00","oloresralph@gmail.com",project_list,"Eat more!",location);
////        dbFirebase.child(key).setValue(sme);
////    }
//
    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
         Toast.makeText(this, "Failed to Initialize!", Toast.LENGTH_SHORT).show();
    }

    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {

        @Override
        public void onBuffering(boolean arg0) {
        }

        @Override
        public void onPaused() {
        }

        @Override
        public void onPlaying() {
        }

        @Override
        public void onSeekTo(int arg0) {
        }

        @Override
        public void onStopped() {
        }

    };

    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {

        @Override
        public void onAdStarted() {
        }

        @Override
        public void onError(YouTubePlayer.ErrorReason arg0) {
        }

        @Override
        public void onLoaded(String arg0) {
        }

        @Override
        public void onLoading() {
        }

        @Override
        public void onVideoEnded() {
        }

        @Override
        public void onVideoStarted() {
        }
    };

}
