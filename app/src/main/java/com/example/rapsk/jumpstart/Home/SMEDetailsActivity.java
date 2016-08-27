package com.example.rapsk.jumpstart.Home;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;



import com.example.rapsk.jumpstart.Home.contants.Constants;
import com.example.rapsk.jumpstart.Home.controllers.SMEController;
import com.example.rapsk.jumpstart.Home.entities.Investor;
import com.example.rapsk.jumpstart.Home.entities.Location;
import com.example.rapsk.jumpstart.Home.entities.Milestones;
import com.example.rapsk.jumpstart.Home.entities.Project;
import com.example.rapsk.jumpstart.Models.SME;
import com.example.rapsk.jumpstart.R;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.Iterator;

public class SMEDetailsActivity extends AppCompatActivity {


    private TextView tvSummary,tvGenre;
    ArrayList<String> mSmes = new ArrayList<>();
    private static final String TAG = "MainActivity";


    private DatabaseReference mDatabase;
    private FirebaseDatabase dbRef;
    private DatabaseReference dbFirebase;
    DatabaseReference dbfirebase2;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private ArrayList<Project> project_list;

    SME sme = new SME();
    Project project = new Project();
    Location location = new Location();
    Milestones milestones = new Milestones();
    Investor investor = new Investor();
    int neededFund;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);


        dbRef = FirebaseDatabase.getInstance();
        dbRef.setPersistenceEnabled(true);
        dbFirebase = dbRef.getReference("Jumpstart/SME's");

        // check intent data passed
        Intent intent = getIntent();
        if (intent == null) {
            throw new RuntimeException("SMEDetailsActivity is expecting an int extra passed by Intent");
        }

        // checks if a movie is present
        int position = intent.getIntExtra(Constants.EXTRA_POSITION, -1);
        if (position == -1) {
            throw new IllegalArgumentException("position passed is invalid.");
        }

        SMEController controller = new SMEController();
        SME sme = controller.getSMEs().get(position);

        if (sme == null) {
            throw new NullPointerException("No movie found at the passed position.");
        }

        // find all views
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(sme.getCompany_name());
        }

        ImageView imgMovie = (ImageView) findViewById(R.id.imgMovie);
        final TextView tvName = (TextView) findViewById(R.id.tvName);
        final TextView tvSummary = (TextView) findViewById(R.id.tvSummary);

//        imgMovie.setImageResource(sme.getImageId());
//        tvGenre.setText(sme.getGenre());
//        tvSummary.setText(sme.getSummary());

        project_list = new ArrayList<>();
        Query dQuery = dbFirebase.orderByChild("company_name").equalTo("usjr");
        dQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> snapshotIterator = dataSnapshot.getChildren();
                Iterator<DataSnapshot> iterator = snapshotIterator.iterator();

                while (iterator.hasNext()) {
                    DataSnapshot snapshot = iterator.next();
                    SME sme = snapshot.getValue(SME.class);

                    project_list.add(new Project(1,"Innovation","Innovating Technologies","https://www.youtube.com/watch?v=4_SdDR5OU00",123456,"Technology",35,1000,milestones,0,12.01,10.01,1));
                    neededFund = project_list.get(0).getNeeded_fund();
                    int receivedFund = project_list.get(0).getReceived_funds();
                    String projectName = project_list.get(0).getName();
                    tvName.setText("Project Name: " + projectName );
                    tvSummary.setText(" Needed Fund: "+neededFund+ " Received Fund :" + receivedFund);


                }

            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}