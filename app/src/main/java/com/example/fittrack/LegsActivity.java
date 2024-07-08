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

public class LegsActivity extends AppCompatActivity {

    private LinearLayout detailContainer;
    private ImageView exerciseGif;
    private TextView exerciseDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legs);

        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        String[] exercises = {"Barbell Squats",
                "Lunges",
                "Lever-Standing Calf Raise",
                "Calf Raises",
                "Leg Press"};
        final int[] exerciseGifs = {R.drawable.barbell_low_bar_squat_exercise,
                R.drawable.barbell_walking_lunge_exercise,
                R.drawable.dumbbell_single_leg_deadlift_exercise,
                R.drawable.lever_standing_calf_raise_calf,
                R.drawable.sled_narrow_stance_leg_press_exercise};
        final String[] exerciseDescriptions = {
                "This king of leg exercises hits all the major muscle groups in your legs – quads, hamstrings, glutes, and calves. It builds overall leg strength, power, and muscle mass. Ensure proper form to avoid injury: back straight, core engaged, knees tracking over toes.\n\n\n\n\n\n\n",
                "Lunges are a fantastic compound exercise that works your quads, hamstrings, glutes, and core. They also improve balance and stability. You can perform them with dumbbells, a barbell, or bodyweight. Focus on keeping your front knee aligned with your ankle and your torso uprig\n\n\n\n\n\n\n",
                "The lever-standing calf raise or lever calf raise refers to a calf raise exercise performed using a specialized weight training machine called a lever calf raise machine.\n\n\n\n\n\n\n",
                "Don't neglect your calves! Calf raises strengthen your calf muscles, which contribute to ankle stability, power, and overall leg definition. You can perform them on a calf raise machine, with dumbbells, or even bodyweight using a step.\n\n\n\n\n\n\n",
                "The leg press is a machine exercise that isolates your quads for targeted growth. It's a good option for beginners or those recovering from injuries. Adjust the foot placement to target different areas of your quads.\n\n\n\n\n\n\n"
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
