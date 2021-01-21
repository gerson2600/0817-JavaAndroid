package com.example.carpartsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    private ScrollView ScrollViewMenu;

    private TextView IntercoolerTitle;
    private ImageView Intercooler1Img;
    private TextView Intercooler1Desc;
    private TextView Intercooler1Price;
    private ImageView Intercooler2Img;
    private TextView Intercooler2Desc;
    private TextView Intercooler2Price;

    private TextView ExhaustTitle;
    private ImageView Exhaust1Img;
    private TextView Exhaust1Desc;
    private TextView Exhaust1Price;
    private ImageView Exhaust2Img;
    private TextView Exhaust2Desc;
    private TextView Exhaust2Price;

    private TextView WheelsTitle;
    private ImageView Wheels1Img;
    private TextView Wheels1Desc;
    private TextView Wheels1Price;
    private ImageView Wheels2Img;
    private TextView Wheels2Desc;
    private TextView Wheels2Price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ScrollViewMenu = findViewById(R.id.MenuScrollView);

        IntercoolerTitle = findViewById(R.id.IntercoolersTxtMenu);
        Intercooler1Img = findViewById(R.id.Intercooler1ImgView);
        Intercooler1Desc = findViewById(R.id.Intercooler1DescTxtView);
        Intercooler1Price = findViewById(R.id.Intercooler1PriceTxtView);
        Intercooler2Img = findViewById(R.id.Intercooler2ImgView);
        Intercooler2Desc = findViewById(R.id.Intercooler2DescTxtView);
        Intercooler2Price = findViewById(R.id.Intercooler2PriceTxtView);

        ExhaustTitle = findViewById(R.id.ExhaustsTxtMenu);
        Exhaust1Img = findViewById(R.id.Exhaust1ImgView);
        Exhaust1Desc = findViewById(R.id.Exhaust1DescTxtView);
        Exhaust1Price = findViewById(R.id.Exhaust1PriceTxtView);
        Exhaust2Img = findViewById(R.id.Exhaust2ImgView);
        Exhaust2Desc = findViewById(R.id.Exhaust2DescTxtView);
        Exhaust2Price = findViewById(R.id.Exhaust2PriceTxtView);

        WheelsTitle = findViewById(R.id.WheelsTxtMenu);
        Wheels1Img = findViewById(R.id.Wheels1ImgView);
        Wheels1Desc = findViewById(R.id.Wheels1DescTxtView);
        Wheels1Price = findViewById(R.id.Wheels1PriceTxtView);
        Wheels2Img = findViewById(R.id.Wheels2ImgView);
        Wheels2Desc = findViewById(R.id.Wheels2DescTxtView);
        Wheels2Price = findViewById(R.id.Wheels2PriceTxtView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        //Menu association to activity
        getMenuInflater().inflate(R.menu.partsmenu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        int id = item.getItemId();
        if(id == R.id.Intercoolers)
        {
            //Show only Intercoolers
            TogglePartVisibilityIntercooler(1);
            TogglePartVisibilityExhausts(0);
            TogglePartVisibilityWheels(0);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    ScrollViewMenu.fullScroll(ScrollView.FOCUS_UP);
                }
            }, 100);

        }
        if(id == R.id.Exhausts)
        {
            //Show only Exhausts
            TogglePartVisibilityIntercooler(0);
            TogglePartVisibilityExhausts(1);
            TogglePartVisibilityWheels(0);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    ScrollViewMenu.fullScroll(ScrollView.FOCUS_UP);
                }
            }, 100);
        }
        if(id == R.id.Wheels)
        {
            //Show only Wheels
            TogglePartVisibilityIntercooler(0);
            TogglePartVisibilityExhausts(0);
            TogglePartVisibilityWheels(1);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    ScrollViewMenu.fullScroll(ScrollView.FOCUS_UP);
                }
            }, 100);

        }
        if(id == R.id.AllParts)
        {
            //Show all Parts, toggle on
            TogglePartVisibilityIntercooler(1);
            TogglePartVisibilityExhausts(1);
            TogglePartVisibilityWheels(1);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    ScrollViewMenu.fullScroll(ScrollView.FOCUS_UP);
                }
            }, 100);
        }

        if (id == R.id.ExitCarParts)
        {
            MenuActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    //ToggleVal = 1 ->Show
    //ToggleVal = 0 ->Hide
    public void TogglePartVisibilityIntercooler(int ToggleVal)
    {
        if (IntercoolerTitle.isShown() && ToggleVal == 0)
        {
            IntercoolerTitle.setVisibility(View.GONE);
            Intercooler1Img.setVisibility(View.GONE);
            Intercooler1Desc.setVisibility(View.GONE);
            Intercooler1Price.setVisibility(View.GONE);
            Intercooler2Img.setVisibility(View.GONE);
            Intercooler2Desc.setVisibility(View.GONE);
            Intercooler2Price.setVisibility(View.GONE);
        }else if (!IntercoolerTitle.isShown() && ToggleVal == 1)
        {
            IntercoolerTitle.setVisibility(View.VISIBLE);
            Intercooler1Img.setVisibility(View.VISIBLE);
            Intercooler1Desc.setVisibility(View.VISIBLE);
            Intercooler1Price.setVisibility(View.VISIBLE);
            Intercooler2Img.setVisibility(View.VISIBLE);
            Intercooler2Desc.setVisibility(View.VISIBLE);
            Intercooler2Price.setVisibility(View.VISIBLE);
        }
    }

    public void TogglePartVisibilityExhausts(int ToggleVal)
    {
        if (ExhaustTitle.isShown() && ToggleVal == 0)
        {
            ExhaustTitle.setVisibility(View.GONE);
            Exhaust1Img.setVisibility(View.GONE);
            Exhaust1Desc.setVisibility(View.GONE);
            Exhaust1Price.setVisibility(View.GONE);
            Exhaust2Img.setVisibility(View.GONE);
            Exhaust2Desc.setVisibility(View.GONE);
            Exhaust2Price.setVisibility(View.GONE);
        }else if (!ExhaustTitle.isShown() && ToggleVal == 1)
        {
            ExhaustTitle.setVisibility(View.VISIBLE);
            Exhaust1Img.setVisibility(View.VISIBLE);
            Exhaust1Desc.setVisibility(View.VISIBLE);
            Exhaust1Price.setVisibility(View.VISIBLE);
            Exhaust2Img.setVisibility(View.VISIBLE);
            Exhaust2Desc.setVisibility(View.VISIBLE);
            Exhaust2Price.setVisibility(View.VISIBLE);
        }
    }

    public void TogglePartVisibilityWheels(int ToggleVal)
    {
        if (WheelsTitle.isShown() && ToggleVal == 0)
        {
            WheelsTitle.setVisibility(View.GONE);
            Wheels1Img.setVisibility(View.GONE);
            Wheels1Desc.setVisibility(View.GONE);
            Wheels1Price.setVisibility(View.GONE);
            Wheels2Img.setVisibility(View.GONE);
            Wheels2Desc.setVisibility(View.GONE);
            Wheels2Price.setVisibility(View.GONE);
        }else if (!WheelsTitle.isShown() && ToggleVal == 1)
        {
            WheelsTitle.setVisibility(View.VISIBLE);
            Wheels1Img.setVisibility(View.VISIBLE);
            Wheels1Desc.setVisibility(View.VISIBLE);
            Wheels1Price.setVisibility(View.VISIBLE);
            Wheels2Img.setVisibility(View.VISIBLE);
            Wheels2Desc.setVisibility(View.VISIBLE);
            Wheels2Price.setVisibility(View.VISIBLE);
        }
    }
}