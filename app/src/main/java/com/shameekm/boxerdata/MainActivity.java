package com.shameekm.boxerdata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSendDataToServer = (Button)findViewById(R.id.btnSendValueToServer);
        final EditText edtValue = (EditText)findViewById(R.id.edtValue);
        View.OnClickListener click=new View.OnClickListener() {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
           final     DatabaseReference myRef=database.getReferenceFromUrl("https://boxerdata-5ea44.firebaseio.com/");
            @Override
            public void onClick(View v) {
                myRef.setValue(edtValue.getText().toString());
                edtValue.setText(null);
            }
        };
        btnSendDataToServer.setOnClickListener(click);
    }
}//shameek
