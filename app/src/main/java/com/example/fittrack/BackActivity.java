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

public class BackActivity extends AppCompatActivity {

    private LinearLayout detailContainer;
    private ImageView exerciseGif;
    private TextView exerciseDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);

        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        String[] exercises = {"Barbell Rows",
                "Seated Cable Rows",
                "Dumbbell Rows",
                "Barbell Deadlifts"};
        final int[] exerciseGifs = {R.drawable.barbell_row,
                R.drawable.seated_cable_row_exercise,
                R.drawable.dumbbell_rows,
                R.drawable.barbell_deadlift_exercise};
        final String[] exerciseDescriptions = {
                "This compound exercise is a king for back development. It works your lats, traps, rhomboids, and core. You can adjust the grip width to target different areas of your back.\n\n\n\n\n\n\n",
                "This machine exercise offers good isolation for your lats, allowing you to focus on form and technique. It's a great exercise for beginners or those recovering from injuries.\n\n\n\n\n\n\n",
                "Similar to barbell rows, dumbbell rows allow for more unilateral (one-sided) work, which can help identify and address any imbalances. They also target core stability.\n\n\n\n\n\n\n",
                "The deadlift is a multi-joint exercise that works a powerhouse of muscles, including your lower back, glutes, hamstrings, and core. It's a great exercise for overall strength and back development, but ensure proper form to avoid injury.\n\n\n\n\n\n\n"
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
