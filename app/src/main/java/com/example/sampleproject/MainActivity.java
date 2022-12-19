package com.example.sampleproject;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sampleproject.Model.Asset;
import com.example.sampleproject.Model.Map;
import com.google.android.material.navigation.NavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
public class MainActivity extends AppCompatActivity {
    APIInterface apiInterface;
    MapInterface mapInterface;
    Button btnSend;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    NavController navController;
//    public Asset CallAPIAsset(){
//        apiInterface = APIClient.getClient().create(APIInterface.class);
//        Asset asset = null;
//        System.out.println(apiInterface);
//
//        Call<Asset> call = apiInterface.getAsset("6H4PeKLRMea1L0WsRXXWp9");//, "Bearer "+ token);
//        call.enqueue(new Callback<Asset>() {
//            @Override
//            public void onResponse(Call<Asset> call, Response<Asset> response) {
//                Log.d("API CALL", response.code()+"");
//                asset = response.body();
//                Log.d("API CALL", asset.attributes+"");
//                Toast.makeText(getApplicationContext(), "SUCCESS CALL API", Toast.LENGTH_SHORT).show();
//
//            }
//            @Override
//            public void onFailure(Call<Asset> call, Throwable t) {
//                Log.d("API CALL", t.getMessage().toString());
//                Toast.makeText(getApplicationContext(), "ERROR CALL API", Toast.LENGTH_SHORT).show();
//            }
//        });
//        Log.d("API CALL", asset.id);
//        return asset;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        TextView txttype = (TextView)findViewById(R.id.textView1);

//        txttype.setText("HELLO MY FRIEND");
        //Call AssetAPI
<<<<<<< HEAD

        apiInterface = APIClient.getClient().create(APIInterface.class);

        System.out.println(apiInterface);

        Call<Asset> call = apiInterface.getAsset("6H4PeKLRMea1L0WsRXXWp9");//, "Bearer "+ token);
        call.enqueue(new Callback<Asset>() {
            @Override
            public void onResponse(Call<Asset> call, Response<Asset> response) {
                Log.d("API CALL", response.code()+"");
                Asset asset = response.body();
                Log.d("API CALL", asset.attributes.weatherData.getClass()+"");
                Toast.makeText(getApplicationContext(), "SUCCESS CALL API", Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onFailure(Call<Asset> call, Throwable t) {
                Log.d("API CALL", t.getMessage().toString());
                Toast.makeText(getApplicationContext(), "ERROR CALL API", Toast.LENGTH_SHORT).show();

                //t.printStackTrace();

            }
        });
=======
//        apiInterface = APIClient.getClient().create(APIInterface.class);
//        Call<Asset> call = apiInterface.getAsset("6H4PeKLRMea1L0WsRXXWp9");//, "Bearer "+ token);
//        call.enqueue(new Callback<Asset>() {
//            @Override
//            public void onResponse(Call<Asset> call, Response<Asset> response) {
//                Log.d("API CALL", response.code()+"");
//                Asset asset = response.body();
//                Log.d("API CALL", asset.attributes.weatherData.type+"");
//                Toast.makeText(getApplicationContext(), "SUCCESS CALL API", Toast.LENGTH_SHORT).show();
////                senddata(asset);
//            }
//            @Override
//            public void onFailure(Call<Asset> call, Throwable t) {
//                Log.d("API CALL", t.getMessage().toString());
//                Toast.makeText(getApplicationContext(), "ERROR CALL API", Toast.LENGTH_SHORT).show();
//
//                //t.printStackTrace();
//
//            }
//        });
>>>>>>> f653259aca8a9241590620e2c51a32e54bed3aad
//
//        //Call mapAPI
//        mapInterface = APIClient.getClient().create(MapInterface.class);
//        Call<Map> call = mapInterface.getAllData();
//        call.enqueue(new Callback<Map>() {
//            @Override
//            public void onResponse(Call<Map> call, Response<Map> response) {
//                Log.d("API CALL", response.code()+"");
//                //Log.d ("API CALL", response.toString());
//                Map map = response.body();
//
//                Log.d("API CALL", map.version+"");
//                txttype.setText(map.options.toString());
//            }
//
//            @Override
//            public void onFailure(Call<Map> call, Throwable t) {
//                Log.d("API CALL", t.getMessage().toString());
//            }
//        });

//        btnSend = (Button) findViewById(R.id.btn1);
//        btnSend.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
//                startActivity(intent);
//            }
//        });
        drawerLayout = findViewById(R.id.drawerLayout);

        findViewById(R.id.img_Menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        navigationView = findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);

        navController = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    private void senddata(Asset asset) {
        AssetsFragment assetsFragment = new AssetsFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Bundle data = new Bundle();
        data.putSerializable("asset", asset);
        assetsFragment.setArguments(data);
        Toast.makeText(getApplicationContext(), "SEND ", Toast.LENGTH_SHORT).show();
        fragmentTransaction.replace(R.id.mana, assetsFragment);
        Log.d("API CALL", asset.attributes.weatherData.name+"2");
        fragmentTransaction.commit();
        Log.d("API CALL", asset.attributes.weatherData.name+"3");
    }
}