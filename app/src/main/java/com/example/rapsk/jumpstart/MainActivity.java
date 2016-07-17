package com.example.rapsk.jumpstart;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.auth.api.model.StringList;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView mFirst;
    private static final String TAG = "MainActivity";


    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Firebase mRef;
        mRef = new Firebase("https://jumpstart-db0c6.firebaseio.com/Jumpstart");

        mDatabase = FirebaseDatabase.getInstance().getReference();
        Toast.makeText(this,""+mDatabase,Toast.LENGTH_LONG).show();


        Map<String, SME> smes = new HashMap<String, SME>();
        smes.put("SME's", new SME(1,"USJ-R","youtube.com/asasdas","oloresralph@gmail.com","Adelante !"));
        mRef.child("SME's").setValue(smes);

        Map<String, Investor> investors = new HashMap<String, Investor>();
        investors.put("Investors", new Investor(1,"Ralph","Olores","oloresralph@gmail.com","USJ-R BASAK"));
        mRef.child("Investors").setValue(investors);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    private void writeSME(int id, String company_name, String ads_url, String email_address, String[] location, String[] project_list, String description){

//            mDatabase.push(sme);
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
}
