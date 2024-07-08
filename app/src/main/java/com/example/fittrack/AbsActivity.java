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

public class AbsActivity extends AppCompatActivity {

    private LinearLayout detailContainer;
    private ImageView exerciseGif;
    private TextView exerciseDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs);

        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        String[] exercises = {"Hanging Leg Raises",
                "Russian Twists",
                "straight leg raise"};
        final int[] exerciseGifs = {R.drawable.hanging_leg_raise_exercise,
                R.drawable.weighted_russian_twist_exercise,
                R.drawable.lying_leg_lift_hold_exercise};
        final String[] exerciseDescriptions = {
                "This bodyweight exercise is a classic for building lower abdominal strength. It works your rectus abdominis (six-pack) and obliques. Hang from a pull-up bar and keep your body straight as you lift your legs towards your chest.\n\n\n\n\n\n\n",
                "This exercise works your obliques and core rotation. Sit on the floor with your knees bent and feet flat. Lean back slightly and twist your torso from side to side, using a medicine ball or weight plate for added resistance if desired.\n\n\n\n\n\n\n",
                "The lying leg lift hold exercise, also known as a straight leg raise or supine leg lift, is a bodyweight exercise that strengthens your lower core muscles, particularly the rectus abdominis (six-pack) and the hip flexors\n\n\n\n\n\n\n"
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
