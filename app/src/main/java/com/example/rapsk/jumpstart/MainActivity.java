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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
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

public class MainActivity extends AppCompatActivity {

    private TextView mFirst;
    private ListView mListView;
    ArrayList<String> mSmes = new ArrayList<>();
    private static final String TAG = "MainActivity";


    private DatabaseReference mDatabase;
    Firebase mRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRef = new Firebase("https://jumpstart-db0c6.firebaseio.com/Jumpstart");
        mDatabase = FirebaseDatabase.getInstance().getReference();
        Toast.makeText(this,""+mDatabase,Toast.LENGTH_LONG).show();

        mFirst = (TextView) findViewById(R.id.first);
        mListView = (ListView) findViewById(R.id.ListView);
        Map<String, SME> smes = new HashMap<String, SME>();
        smes.put("SME's", new SME(1,"USJ-R",new String[]{"ROBOT","CAR"},"youtube.com/asasdas","oloresralph@gmail.com","Adelante !"));
        mRef.child("SME's").setValue(smes);
        Map<String, SME> smes2 = new HashMap<String, SME>();
        smes2.put("SME's", new SME(2,"Jollibee",new String[]{"New Dessert","New Food"},"youtube.com/1mn79x","ralpholores@gmail.com","Bida ang sarap"));


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

    @Override
    protected void onStart() {
        super.onStart();

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mSmes);
        mListView.setAdapter(adapter);
        Firebase smeRef = mRef.child("SME's").child("SME's");
        smeRef.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
               mFirst.setText("List of SME's with their projects");
               Map<String,String> map = dataSnapshot.getValue(Map.class);
               String smeName = map.get("company_name");
               List<String> projectList = new ArrayList<String>();
                projectList.add(map.get("project_list"));
                mSmes.add(smeName);
                mSmes.add(projectList.get(0));


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

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
