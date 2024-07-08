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

public class TricepActivity extends AppCompatActivity {

    private LinearLayout detailContainer;
    private ImageView exerciseGif;
    private TextView exerciseDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tricep);

        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        String[] exercises = {"Close-Grip Bench Press",
                "Overhead Triceps Extensions",
                "Triceps Pushdowns",
                "Lying Triceps Extensions"};
        final int[] exerciseGifs = {R.drawable.barbell_close_grip_bench_press_exercise,
                R.drawable.overhead_rope_tricep_extension_exercise,
                R.drawable.cable_tricep_pushdown_exercise,
                R.drawable.barbell_lying_close_grip_triceps_extension_exercise};
        final String[] exerciseDescriptions = {
                "This variation of the bench press places more emphasis on the triceps compared to a standard grip. By bringing your hands closer together, you isolate the triceps during the pushing motion.\n\n\n\n\n\n\n",
                "This exercise effectively targets the long head of the triceps, which contributes to overall arm size and horseshoe shape. You can perform this exercise with dumbbells, a barbell, or cables, depending on your preference.\n\n\n\n\n\n\n",
                "This machine exercise provides great isolation for the triceps, allowing for controlled movements and focused contractions. You can adjust the handle attachments (rope, straight bar, V-bar) to target different areas of the triceps\n\n\n\n\n\n\n",
                "Performed while lying on a flat bench, this exercise isolates the long head of the triceps with good control. You can use dumbbells or a barbell for this exercise, focusing on extending your arms and squeezing your triceps at the top of the movement.\n\n\n\n\n\n\n"
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
