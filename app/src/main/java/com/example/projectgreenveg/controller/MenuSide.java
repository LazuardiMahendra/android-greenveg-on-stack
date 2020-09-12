package com.example.projectgreenveg.controller;

import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.projectgreenveg.R;
import com.example.projectgreenveg.controller.Produk.AddProduk;
import com.google.android.material.navigation.NavigationView;

public class MenuSide extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle myToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_side);

        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout =findViewById(R.id.mDrawer);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle  toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_contain, new FragmentAddProduk()).commit();
            navigationView.setCheckedItem(R.id.bt_add_produk);
//            Intent i = new Intent(this,MenuSide.class);
//            startActivity(i);
        }
//        mDrawer  = (DrawerLayout) findViewById(R.id.mDrawer);
//        myToggle = new ActionBarDrawerToggle(this,mDrawer,R.string.open,R.string.close);
//        mDrawer.addDrawerListener(myToggle);
//        myToggle.syncState();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onNavigationItemSelected( MenuItem menuItem) {
        int id = menuItem.getItemId();
        if(id == R.id.bt_add_kategori){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_contain, new FragmentKategori());
            ft.commit();
        }else if (id == R.id.bt_add_produk){
            Intent i = new Intent(MenuSide.this, AddProduk.class);
            startActivity(i);
        }
//        DrawerLayout drawerLayout =(DrawerLayout) findViewById(R.id.drawer);
//        drawerLayout.closeDrawer();
        return false;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    private class FragmentKategori extends Fragment {
    }

    //    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if(myToggle.onOptionsItemSelected(item)) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }




}
