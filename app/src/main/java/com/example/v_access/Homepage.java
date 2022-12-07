package com.example.v_access;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Homepage extends AppCompatActivity {
    CardView vtopcardview,vtopquizcardview,codetantracardview,msteamscardview,gpacalcicardview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);
        vtopcardview=findViewById(R.id.vtopcardview);
        vtopquizcardview=findViewById(R.id.vtopquizcardview);
        codetantracardview=findViewById(R.id.codetantracardview);
       gpacalcicardview=findViewById(R.id.gpacalcicardview);
       msteamscardview=findViewById(R.id.msteamscardview);
       vtopcardview.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent();
               intent.setAction(Intent.ACTION_VIEW);
               intent.addCategory(Intent.CATEGORY_BROWSABLE);
               intent.setData(Uri.parse("https://vtop2.vitap.ac.in/vtop/initialProcess"));
               startActivity(intent);
           }
       });
       vtopquizcardview.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent();
               intent.setAction(Intent.ACTION_VIEW);
               intent.addCategory(Intent.CATEGORY_BROWSABLE);
               intent.setData(Uri.parse("https://vtop.vitap.ac.in/onlineexam/login"));
               startActivity(intent);

           }
       });
       msteamscardview.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent();
               intent.setAction(Intent.ACTION_VIEW);
               intent.addCategory(Intent.CATEGORY_BROWSABLE);
               intent.setData(Uri.parse("https://www.microsoft.com/en-in/microsoft-teams/log-in"));
               startActivity(intent);

           }
       });
       codetantracardview.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent();
               intent.setAction(Intent.ACTION_VIEW);
               intent.addCategory(Intent.CATEGORY_BROWSABLE);
               intent.setData(Uri.parse("https://vitap.codetantra.com/login.jsp"));
               startActivity(intent);
           }
       });
       gpacalcicardview.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent();
               intent.setAction(Intent.ACTION_VIEW);
               intent.addCategory(Intent.CATEGORY_BROWSABLE);
               intent.setData(Uri.parse("https://getcgpa.rajchandra.me/"));
               startActivity(intent);
           }
       });
    }
}