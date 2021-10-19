package com.madmobiledevs.foodbounty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.madmobiledevs.foodbounty.LoadingDialougs.LoadingDialog;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class Restaurant_Details_Activity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Menu menu;

    Toolbar toolBar;

    ImageView nav_Btn;

    ActionBarDrawerToggle toggle;

    DatabaseReference Restaurent_Ref;

    LoadingDialog loadingDialog;

    private String name, detail, description, photo, menu_Extra, couponCode, discount, address, photo_Extra;

    private TextView name_TxtVw, address_TxtVw, description_TxtVw, couponCode_TxtVw, discount_TxtVw;

    private ImageView menu_ImgVw, restrnt_ImgVw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);

        name_TxtVw = findViewById(R.id.name_Restrent_Details);
        address_TxtVw = findViewById(R.id.address_Restrent_Details);
        description_TxtVw = findViewById(R.id.description_Restrent_Details);
        couponCode_TxtVw = findViewById(R.id.couponCode_Restrent_Details);

        menu_ImgVw = findViewById(R.id.menu_Img_Details);
        restrnt_ImgVw = findViewById(R.id.restaurent_Img_Details);

        Intent intent = getIntent();

        name = intent.getStringExtra("name");
        description = intent.getStringExtra("description");
        address = intent.getStringExtra("address");
        couponCode = intent.getStringExtra("couponCode");

        menu_Extra = intent.getStringExtra("menu");
        photo_Extra = intent.getStringExtra("photo");

        drawerLayout=findViewById(R.id.drawerLayout_Details);
        navigationView=findViewById(R.id.nav_view_Details);

        toolBar = findViewById(R.id.Toolbar_Details);

        setSupportActionBar(toolBar);


        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolBar, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.nav_MyCoupons:
                        Toast.makeText(Restaurant_Details_Activity.this, "a", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_About_us:
                        Toast.makeText(Restaurant_Details_Activity.this, "b", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_Faq:
                        Toast.makeText(Restaurant_Details_Activity.this, "c", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_AdminAccess:
                        Toast.makeText(Restaurant_Details_Activity.this, "d", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }

                return true;
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

        setData();
    }

    private void setData() {

        name_TxtVw.setText(name);
        description_TxtVw.setText(description);
        address_TxtVw.setText(address);
        couponCode_TxtVw.setText(couponCode);



        Picasso.get().load(photo_Extra).fit().into(restrnt_ImgVw, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {

            }
        });

        Picasso.get().load(menu_Extra).fit().into(menu_ImgVw, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {

            }
        });

    }
}