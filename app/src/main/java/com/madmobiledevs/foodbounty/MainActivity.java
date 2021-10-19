package com.madmobiledevs.foodbounty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.madmobiledevs.foodbounty.LoadingDialougs.LoadingDialog;
import com.madmobiledevs.foodbounty.Model.Restaurants;
import com.madmobiledevs.foodbounty.ViewHolder.Restaurant_ViewHolder;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Menu menu;

    Toolbar toolBar;

    ImageView nav_Btn;

    ActionBarDrawerToggle toggle;

    RecyclerView recyclerView_Restaurents;
    RecyclerView.LayoutManager layoutManager;

    DatabaseReference Restaurent_Ref;

    LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadingDialog = new LoadingDialog(this);

        recyclerView_Restaurents = findViewById(R.id.recycler_view_restaurents);
        layoutManager= new LinearLayoutManager(this);
        recyclerView_Restaurents.setLayoutManager(layoutManager);

        Restaurent_Ref = FirebaseDatabase.getInstance().getReference().child("Restaurants");

        drawerLayout=findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.nav_view);

        toolBar = findViewById(R.id.Toolbar_Main);

        setSupportActionBar(toolBar);


        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolBar, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.nav_MyCoupons:
                        Toast.makeText(MainActivity.this, "a", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_About_us:
                        Toast.makeText(MainActivity.this, "b", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_Faq:
                        Toast.makeText(MainActivity.this, "c", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_AdminAccess:
                        Toast.makeText(MainActivity.this, "d", Toast.LENGTH_SHORT).show();
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

        showAllProducts();
    }

    private void showAllProducts() {

        loadingDialog.startLoadingDialog();

        Toast.makeText(getApplicationContext(), "this", Toast.LENGTH_SHORT).show();
        FirebaseRecyclerOptions<Restaurants> options=
                new FirebaseRecyclerOptions.Builder<Restaurants>()
                        .setQuery(Restaurent_Ref,Restaurants.class)
                        .build();


        FirebaseRecyclerAdapter<Restaurants, Restaurant_ViewHolder> adapter = new FirebaseRecyclerAdapter<Restaurants, Restaurant_ViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull Restaurant_ViewHolder restaurant_viewHolder, int i, @NonNull Restaurants restaurants) {


//                Picasso.get().load(restaurants.getPhoto())
//                        .fit()
//                        .into(img, new Callback() {
//                            @Override
//                            public void onSuccess() {
//                                restaurant_viewHolder.rest_ImgVw.setBackground(img.getDrawable());
//                                loadingDialog.dismissDialog();
//                            }
//
//                            @Override
//                            public void onError(Exception e) {
//                                loadingDialog.dismissDialog();
//                                Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
//
//                            }
//                        });






                Picasso.get().load(restaurants.getPhoto())
                        .fit()
                        .into(restaurant_viewHolder.rest_ImgVw, new Callback() {
                            @Override
                            public void onSuccess() {
                                loadingDialog.dismissDialog();
                            }

                            @Override
                            public void onError(Exception e) {

                            }
                        });

                restaurant_viewHolder.restName_TxtVw.setText(restaurants.getName());
                restaurant_viewHolder.restDetails_TxtVw.setText(restaurants.getDetails());
                restaurant_viewHolder.rest_Address_TxtVw.setText(restaurants.getAddress());

                restaurant_viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent(MainActivity.this, Restaurant_Details_Activity.class);

                        intent.putExtra("name",restaurants.getName().toString());
                        intent.putExtra("detail",restaurants.getDetails().toString());
                        intent.putExtra("description",restaurants.getDescription().toString());
                        intent.putExtra("address",restaurants.getAddress().toString());
                        intent.putExtra("photo",restaurants.getPhoto().toString());
                        intent.putExtra("menu",restaurants.getMenu_img().toString());
                        intent.putExtra("couponCode",restaurants.getCouponCode().toString());
                        intent.putExtra("discount",restaurants.getDiscount().toString());

                        startActivity(intent);
                    }
                });
            }

            @NonNull
            @Override
            public Restaurant_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurents_layout,parent, false);
                Restaurant_ViewHolder holder= new Restaurant_ViewHolder(view);
                return holder;
            }
        };

        recyclerView_Restaurents.setAdapter(adapter);
        adapter.startListening();

    }
}