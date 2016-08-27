package com.example.rapsk.jumpstart.Models;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.rapsk.jumpstart.Adapter.ViewPagerAdapter;
import com.example.rapsk.jumpstart.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends Activity implements NavigationView.OnNavigationItemSelectedListener{

    private TextView mFirst,mStatus,mDetails;
    private EditText mId,mCompanyName,mProjectName,mProjectName2,mUrl,mDesc,mEmail,mEmailField,mPasswordField ;
    private EditText mInvestorId,mFname,mLname,mInvestorEmail;
    private ListView mListView;
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


    ViewPager vPager;
    PagerAdapter adapter;
    String[] smeName;
    String[] smeNeedFund;
    String[] smeFundReceived;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);


        smeName = new String[]{"San Miguel","USJ-R","Miguelitos"};
        smeNeedFund = new String[]{"1500","2000","1700"};
        smeFundReceived = new String[]{"100","500","800"};
        vPager = (ViewPager) findViewById(R.id.pager);
        adapter = new ViewPagerAdapter(MainActivity.this,smeName,smeFundReceived,smeNeedFund);
        vPager.setAdapter(adapter);
//        dbRef = FirebaseDatabase.getInstance();
//        dbRef.setPersistenceEnabled(true);
//        dbFirebase = dbRef.getReference("Jumpstart/SME's");
//////        dbfirebase2 = dbRef.getReference("Investors");
//        mFirst = (TextView) findViewById(R.id.first);
//        mId = (EditText) findViewById(R.id.smeId);
//        mCompanyName = (EditText) findViewById(R.id.companyName);
//        mEmail = (EditText) findViewById(R.id.emailAddress);
//        mListView = (ListView) findViewById(R.id.list_item);
//
//
//        project_list = new ArrayList<>();
//        Query dQuery = dbFirebase.orderByChild("company_name").equalTo("usjr");
//        dQuery.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                Iterable <DataSnapshot> snapshotIterator = dataSnapshot.getChildren();
//                Iterator <DataSnapshot> iterator = snapshotIterator.iterator();
//
//                while (iterator.hasNext()){
//                    DataSnapshot snapshot = iterator.next();
//                    SME sme = snapshot.getValue(SME.class);
//
//                        project_list.add(new Project(1,"Innovation","Innovating Technologies","https://www.youtube.com/watch?v=4_SdDR5OU00",123456,"Technology",35,1000,milestones,0,12.01,10.01,1));
//                        neededFund = project_list.get(0).getNeeded_fund();
//                        int receivedFund = project_list.get(0).getReceived_funds();
//                        String projectName = project_list.get(0).getName();
//                        mFirst.setText("Project Name: " + projectName + " Needed Fund: "+neededFund+ " Received Fund :" + receivedFund);
//
//
//                }
//
//
//                GridView adapter = new GridView(MainActivity.this,R.layout.grid_layout, project_list);
//                mListView.setAdapter(adapter);
//
//            }
//
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//                String id = mId.getText().toString();
//                String smeName = mCompanyName.getText().toString();
//                String ads_url = "https://www.youtube.com/watch?v=4_SdDR5OU00";
//                String email = mEmail.getText().toString();
//                String desc = "Innovate and Transform";
//                String key = dbFirebase.push().getKey();
//                Location location  = new Location(192.16810,191.0291,"Basak");
//                Milestones milestones = new Milestones(1,"https://www.youtube.com/watch?v=4_SdDR5OU00","https://www.youtube.com/watch?v=4_SdDR5OU00","Started Building...");
//
//                SME sme = new SME(id,smeName,ads_url,email,project_list,desc,location);
//
//                dbFirebase.child(key).setValue(sme);
//
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

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        return false;
    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.createAccount:
//                createAccount(mEmailField.getText().toString(), mPasswordField.getText().toString());
//                break;
//            case R.id.email:
//                signIn(mEmailField.getText().toString(), mPasswordField.getText().toString());
//                break;
//            case R.id.signOut:
//                signOut();
//                break;
//        }
//    }
}
