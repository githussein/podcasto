package meemseen.qustreamer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find the view for each category
        final TextView technologyTextView = findViewById(R.id.technology);
        final TextView businessTextView  = findViewById(R.id.business);
        final TextView healthTextView  = findViewById(R.id.health);
        final TextView sportsTextView = findViewById(R.id.sports);


        SharedPreferences sharedPreferences = getSharedPreferences("pref" , MODE_PRIVATE);
        final SharedPreferences.Editor spEdit = sharedPreferences.edit();

        technologyTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                spEdit.putString("category" , "technology");
                spEdit.apply();

                Intent intent = new Intent(MainActivity.this, Category.class);
                startActivity(intent);
            }
        });

        //Set on click listener for family text view
        businessTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spEdit.putString("category" , "business");
                spEdit.apply();

                Intent intent = new Intent(MainActivity.this, Category.class);
                startActivity(intent);
            }
        });

        healthTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spEdit.putString("category" , "health");
                spEdit.apply();

                Intent intent = new Intent(MainActivity.this, Category.class);
                startActivity(intent);
            }
        });

   