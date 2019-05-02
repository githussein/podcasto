package meemseen.podcasto;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class Play extends AppCompatActivity {
    // Get references for the views
    ImageView homeIcon;
    ImageView playIcon;
    ImageView pauseIcon;
    ImageView playAudioArt;
    TextView playTitle;
    TextView playSubtitle;
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);


        homeIcon     = findViewById(R.id.home_icon);
        playIcon     = findViewById(R.id.play_icon);
        pauseIcon    = findViewById(R.id.pause_icon);
        playAudioArt = findViewById(R.id.play_audio_art);
        playTitle    = findViewById(R.id.play_title);
        playSubtitle = findViewById(R.id.play_subtitle);

        //Find the url passed from the Category Activity
        SharedPreferences sharedPreferences = getSharedPreferences("pref", MODE_PRIVATE);
        final String sharedStreamingUrl = sharedPreferences.getString("url", "");
        final String sharedPlayTitle = sharedPreferences.getString("title", "");
        final String sharedPlaySubitle = sharedPreferences.getString("subtitle", "");
        final int sharedAudiArtId = sharedPreferences.getInt("image_id", -1);

        playAudioArt.setImageResource(sharedAudiArtId);
        playTitle.setText(sharedPlayTitle);
        playSubtitle.setText(sharedPlaySubitle);


        //start streaming the audio file
        playIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Give a feedback to the user when he plays a podcast
                Toast.makeText
                        (Play.this, "Streaming, please wait...", Toast.LENGTH_SHORT)
                        .show();
                //Stream the podcast
                mediaPlayer = MediaPlayer.create(Play.this, Uri.parse(sharedStreamingUrl));
                mediaPlayer.start();
            }
        });
        //Pause streaming
        pauseIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Give a feedback to the user when he pauses the podcast
                Toast.makeText
                        (Play.this, "pause", Toast.LENGTH_SHORT)
                        .show();
                mediaPlayer.pause();
            }
        });
        //Go to home screen
        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Give a feedback to the user
                Toast.makeText
                        (Play.this, "Browse Categories...", Toast.LENGTH_SHORT)
                        .show();
                Intent intent = new Intent(Play.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
