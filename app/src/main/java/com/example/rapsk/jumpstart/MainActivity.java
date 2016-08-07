package com.example.rapsk.jumpstart;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.api.model.StringList;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity{

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

    SME sme = new SME();
    Project project = new Project();
    Location location = new Location();
    Milestones milestones = new Milestones();
    Investor investor = new Investor();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        dbRef = FirebaseDatabase.getInstance();
        dbRef.setPersistenceEnabled(true);
        dbFirebase = dbRef.getReference("Jumpstart/SME's");
        dbfirebase2 = dbRef.getReference("Jumpstart/Investors");
//        mFirst = (TextView) findViewById(R.id.first);
        mId = (EditText) findViewById(R.id.smeId);
        mCompanyName = (EditText) findViewById(R.id.companyName);
        mEmail = (EditText) findViewById(R.id.emailAddress);
        mInvestorId = (EditText) findViewById(R.id.investorID);
        mFname = (EditText) findViewById(R.id.investorFirstname);
        mLname = (EditText) findViewById(R.id.investorLastname);
        mInvestorEmail = (EditText) findViewById(R.id.investorEmail);
//        mListView = (ListView) findViewById(R.id.ListView);
//
//        mEmailField = (EditText) findViewById(R.id.email);
//        mPasswordField = (EditText) findViewById(R.id.password);
//        mStatus = (TextView) findViewById(R.id.status);
//        mDetails = (TextView) findViewById(R.id.detail);
//        mAuth = FirebaseAuth.getInstance();
//        findViewById(R.id.signIn).setOnClickListener(this);
//        findViewById(R.id.createAccount).setOnClickListener(this);
//        mAuthListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                FirebaseUser user = firebaseAuth.getCurrentUser();
//                if(user != null){
//                    //User is signed in.
//                    Log.d("TAG", "onAuthstateChanged: sign_in: " + user.getUid());
//                }
//                else{
//                    Log.d("TAG", "onAuthstateChanged: signed_out");
//                }
//            }
//            updateUI(user);
//        };




//        Map<String, Investor> investors = new HashMap<String, Investor>();
//        investors.put("Investors", new Investor(1,"Ralph","Olores","oloresralph@gmail.com","USJ-R BASAK"));
//        mRef.child("Investors").setValue(investors);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
//                String id = mId.getText().toString();
//                String smeName = mCompanyName.getText().toString();
//                String project1 = mProjectName.getText().toString();
//                String project2 = mProjectName2.getText().toString();
//                String[] list = new String[]{project1,project2};
//                String ads_url = mUrl.getText().toString();
//                String email = mEmail.getText().toString();
//                String desc = mDesc.getText().toString();
//                sme[0] = new SME(id,smeName,list,ads_url,email,desc);
//                Map<String, SME[]> smes = new HashMap<String, SME[]>();
//                smes.put("SME's",sme);
//                mRef.child("SME's").setValue(sme);

                String id = mId.getText().toString();
                String smeName = mCompanyName.getText().toString();
                String ads_url = "https://www.youtube.com/watch?v=4_SdDR5OU00";
                String email = mEmail.getText().toString();
                String desc = "Innovate and Transform";
                String key = dbFirebase.push().getKey();
                Location location  = new Location(192.16810,191.0291,"Basak");
                Milestones milestones = new Milestones(1,"https://www.youtube.com/watch?v=4_SdDR5OU00","https://www.youtube.com/watch?v=4_SdDR5OU00","Started Building...");
                Project list = new Project(1,"Innovation","Innovating Technologies","https://www.youtube.com/watch?v=4_SdDR5OU00",100000,"Technology",0,1000,milestones,0,12.01,10.01,1);
                SME sme = new SME(id,smeName,location,list,ads_url,email,desc);

                // Investor side...
                String investorId = mInvestorId.getText().toString();
                String firstName = mFname.getText().toString();
                String lastName = mLname.getText().toString();
                String investorEmail = mInvestorEmail.getText().toString();
                int paymaya_id = 10291232;
                int paypal_id = 4019231;
                String key2 = dbfirebase2.push().getKey();
                Investment investment = new Investment(list,15000,1000);
                Investor investor = new Investor(investorId,firstName,lastName,investorEmail,paymaya_id,paypal_id,list,investment,location);

                dbfirebase2.child(key2).setValue(investor);
                dbFirebase.child(key).setValue(sme);

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
//        mAuth.addAuthStateListener(mAuthListener);
//        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mSmes);
//        mListView.setAdapter(adapter);
//        Firebase smeRef = mRef.child("SME's").child("SME's");
//        smeRef.addValueEventListener(new com.firebase.client.ValueEventListener() {
//            @Override
//            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
//               mFirst.setText("List of SME's with their projects");
//               Map<String,String> map = dataSnapshot.getValue(Map.class);
//               String smeName = map.get("company_name");
//               List<String> projectList = new ArrayList<String>();
//                projectList.add(map.get("project_list"));
//                mSmes.add(smeName);
//                mSmes.add(projectList.get(0));
//
//
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//
//            }
//        });
    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        if(mAuthListener != null){
//            mAuth.removeAuthStateListener(mAuthListener) ;
//        }
//    }
//
//
//    private void createAccount(String email,String password){
//        Log.d("TAG","createAccount: " + email);
//        if(!validateForm()){
//            return;
//        }
//
//
//        //start create user with email
//        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                Log.d("TAG","createUserWithEmail:onComplete: " + task.isSuccessful());
//
//                //if sign in fails,display a message to the user
//                if(!task.isSuccessful()){
//                    Toast.makeText(MainActivity.this,"Authentication failed.",Toast.LENGTH_SHORT).show();
//                }
//
//
//            }
//        });
//    }
//
//    private void signIn(String email, String password){
//            Log.d("TAG", "signIn: " + email);
//        if (!validateForm()){
//            return;
//        }
//
//
//
//        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                Log.d("TAG", "signInWithEmail:onComplete: " + task.isSuccessful());
//
//                //if fails
//                if(!task.isSuccessful()){
//                    Log.w("TAG", "signInWithEmail",task.getException());
//                    Toast.makeText(MainActivity.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });
//    }
//
//    private void signOut(){
//        mAuth.signOut();
//        updateUI(null);
//    }
//
//    private boolean validateForm(){
//        boolean valid = true;
//
//        String email = mEmailField.getText().toString();
//        if (TextUtils.isEmpty(email)) {
//            mEmail.setError("Required");
//            valid = false;
//        }else {
//            mEmail.setError(null);
//        }
//
//        String password = mPasswordField.getText().toString();
//        if(TextUtils.isEmpty(password)){
//            mPasswordField.setError("Required");
//            valid = false;
//        }else{
//            mPasswordField.setError(null);
//        }
//        return valid;
//
//    }
//
//    private void updateUI(FirebaseUser user){
//
//        if(user != null){
//            mStatus.setText("Email User: " + user.getEmail());
//            mDetails.setText("Firebase User: " + user.getUid());
//
//            findViewById(R.id.buttons).setVisibility(View.GONE);
//            findViewById(R.id.email).setVisibility(View.GONE);
//            findViewById(R.id.password).setVisibility(View.GONE);
//            findViewById(R.id.signOut).setVisibility(View.VISIBLE);
//        }else {
//            mStatus.setText("Signed Out");
//            mDetails.setText(null);
//
//            findViewById(R.id.buttons).setVisibility(View.VISIBLE);
//            findViewById(R.id.email).setVisibility(View.VISIBLE);
//            findViewById(R.id.password).setVisibility(View.VISIBLE);
//        }
//    }

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
