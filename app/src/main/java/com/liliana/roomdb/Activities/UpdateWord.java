package com.liliana.roomdb.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.liliana.roomdb.R;
import com.liliana.roomdb.WordViewModel;

public class UpdateWord extends AppCompatActivity {
private WordViewModel model;
private EditText edtUpdate;
private String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_word);
        edtUpdate=findViewById(R.id.edt_UpAWord);
        Intent getdb=getIntent();
        data=getdb.getStringExtra("key");
        edtUpdate.setText(data);
    }


    public void upDateWord(View view) {
       //    model.udWord(edtUpdate.getText().toString());
        finish();
    }
}
