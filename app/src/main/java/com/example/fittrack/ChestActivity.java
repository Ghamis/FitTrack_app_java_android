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

public class ChestActivity extends AppCompatActivity {

    private LinearLayout detailContainer;
    private ImageView exerciseGif;
    private TextView exerciseDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest);

        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        String[] exercises = {"Barbell Bench Press",
                "Dumbbell Bench Press",
                "Incline Dumbbell Press",
                "Decline Bench Press",
                "Cable Flyes"};
        final int[] exerciseGifs = {R.drawable.barbell_bench_press_exercise,
                R.drawable.dumbbell_bench_press_exercise,
                R.drawable.incline_dumbbell_bench_press_exercise,
                R.drawable.dumbbell_bench_press_exercise,
                R.drawable.low_cable_fly_exercise};
        final String[] exerciseDescriptions = {
                "This is a classic and highly effective exercise for building overall chest strength and mass. It primarily targets the pectoralis major, but also engages your shoulders and triceps.\n\n\n\n\n\n\n",
                "Similar to the barbell bench press, dumbbell presses offer a wider range of motion and can help target different areas of your chest by adjusting your hand position. They also promote better core stability.\n\n\n\n\n\n\n",
                "This variation targets the upper pectoralis major, which is the top portion of your chest muscles. By adjusting the incline of the bench, you can emphasize this area for a more sculpted chest.\n\n\n\n\n\n\n",
                "This exercise focuses on the lower pectoralis major, the muscle fibers closest to your abdomen. It can help create a more complete and balanced chest development.\n\n\n\n\n\n\n",
                "This machine exercise provides great isolation for your chest muscles, allowing you to focus on squeezing and contracting them throughout the movement. It's a good choice for building muscle definition and targeting specific areas of your chest.\n\n\n\n\n\n\n"
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
