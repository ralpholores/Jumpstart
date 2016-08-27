package com.example.rapsk.jumpstart.Home.controllers;


import android.app.DownloadManager;
import android.widget.GridView;
import android.widget.TextView;

import com.example.rapsk.jumpstart.Models.Investor;
import com.example.rapsk.jumpstart.Models.Location;
import com.example.rapsk.jumpstart.Models.Milestones;
import com.example.rapsk.jumpstart.Models.Project;
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
import java.util.List;

/**
 * Created by gvg on 8/8/2016.
 */
public class SMEController {


    private TextView tvName,tvGenre;
    private DatabaseReference mDatabase;
    private FirebaseDatabase dbRef;
    private DatabaseReference dbFirebase;
    DatabaseReference dbfirebase2;

    private List<SME> mSMEs;
    private ArrayList<Project> project_list;

    SME sme = new SME();
    Project project = new Project();
    Location location = new Location();
    Milestones milestones = new Milestones();
    Investor investor = new Investor();
    int neededFund;

    public SMEController() {
        // create all the SMEs here
//        mSMEs = new ArrayList<>();
//        mSMEs.add(new SME("Banana", "Veggies", "Mamaligyaay og lami na prutas kini.", R.drawable.banana));
//        mSMEs.add(new SME("Cigarette", "Addictive", "Gusto ka matay? kami bahala nimo pero palamian namo imong kamatyon ", R.drawable.cigarette));
//        mSMEs.add(new SME("Eat", "Yum", "Way mahay bsta kaon.", R.drawable.eat));
//        mSMEs.add(new SME("Foods", "Need", "Mamatay jd ka kung d kam kaon", R.drawable.foods));
//        mSMEs.add(new SME("Laundry", "Clothes", "Bench Penshopee American Eagle", R.drawable.laundry));
////        mSMEs.add(new SME("X-Men: Apocalypse", "Action", "With the emergence of the world's first mutant, Apocalypse, the X-Men must unite to defeat his extinction level plan.", R.drawable.movie06));
//        mSMEs.add(new SME("Eat", "Yum", "Way mahay bsta kaon.", R.drawable.eat));
//        mSMEs.add(new SME("Banana", "Veggies", "Mamaligyaay og lami na prutas kini.", R.drawable.banana));


        project_list = new ArrayList<>();
        Query dQuery = dbFirebase.orderByChild("company_name").equalTo("usjr");
        dQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> snapshotIterator = dataSnapshot.getChildren();
                Iterator<DataSnapshot> iterator = snapshotIterator.iterator();

                while (iterator.hasNext()){
                    DataSnapshot snapshot = iterator.next();
                    SME sme = snapshot.getValue(SME.class);

                    project_list.add(new Project(1,"Innovation","Innovating Technologies","https://www.youtube.com/watch?v=4_SdDR5OU00",123456,"Technology",35,1000,milestones,0,12.01,10.01,1));
                    String projectName = project_list.get(0).getName();
                    String projectCategory = project_list.get(0).getDescription();
                    tvName.setText("Project Name: " + projectName );
                    tvGenre.setText("Genre: "+ projectCategory);



                }

//
//                GridView adapter = new GridView(SMEController.this,R.layout.recyc, project_list);
//                mListView.setAdapter(adapter);

            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }



    public List<SME> getSMEs() {
        return mSMEs;

    }
}
