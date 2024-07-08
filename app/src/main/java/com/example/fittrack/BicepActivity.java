package com.example.fittrack;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.time.Instant;

public class BicepActivity extends AppCompatActivity {

    private LinearLayout detailContainer;
    private ImageView exerciseGif;
    private TextView exerciseDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bicep);

        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        String[] exercises = {"Barbell Curls",
                "EZ Bar Curls",
                "Dumbbell Curls",
                "Hammer Curls",
                "Preacher Curls"};
        final int[] exerciseGifs = {R.drawable.barbell_curl_upper_arms,
                R.drawable.ez_bar_curl_exercise,
                R.drawable.dumbbell_curl_exercise,
                R.drawable.alternating_dumbbell_hammer_curl_exercise,
                R.drawable.ez_bar_preacher_curl_exercise};
        final String[] exerciseDescriptions = {
                "This classic bicep exercise effectively targets both the long head and short head of the biceps. You can adjust your grip width (wide for more upper chest involvement, close for more bicep focus) to target different areas.\n\n\n\n\n\n\n",
                "Similar to barbell curls, EZ bars offer a more ergonomic grip that can be easier on the wrists.  They also promote some forearm engagement and can target both bicep heads.\n\n\n\n\n\n\n",
                "Dumbbell curls allow for a greater range of motion and can help identify and address any imbalances between your biceps. They also promote core stability as you lift each arm independently.\n\n\n\n\n\n\n",
                "This exercise primarily targets the brachialis muscle, located under the biceps, which contributes to overall arm size and definition. It also works the forearms with a neutral grip.\n\n\n\n\n\n\n",
                "Preacher curls isolate the bicep muscles, minimizing shoulder involvement. By resting your arms on a pad, you can focus on a strict curl motion and maximize bicep contraction.\n\n\n\n\n\n\n"
        };

        ListView lvExercises = findViewById(R.id.lvExercises);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, exercises);
        lvExercises.setAdapter(adapter);

        detailContainer = findViewById(R.id.llDetailContainer);
        exerciseGif = findViewById(R.id.ivExerciseGif);
        exerciseDescription = findViewById(R.id.tvExerciseDescription);

        lvExercises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showExerciseDetail(exerciseGifs[position], exerciseDescriptions[position]);
            }
        });
    }

    private void showExerciseDetail(int gifResId, String description) {
        Glide.with(this)
                .asGif()
                .load(gifResId)
                .into(exerciseGif);
        exerciseDescription.setText(description);
        detailContainer.setVisibility(View.VISIBLE);
    }
}
