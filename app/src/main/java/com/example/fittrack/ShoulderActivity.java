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

public class ShoulderActivity extends AppCompatActivity {

    private LinearLayout detailContainer;
    private ImageView exerciseGif;
    private TextView exerciseDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoulder);

        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        String[] exercises = {"Military Press (Overhead Press)",
                "Lateral Raises",
                "Front Raises",
                "Rear Delt Flyes",
                "Arnold Press"};
        final int[] exerciseGifs = {R.drawable.barbell_standing_military_press_exercise,
                R.drawable.dumbbell_lateral_raise_exercise,
                R.drawable.barbell_front_raise_exercise,
                R.drawable.seated_dumbbell_rear_lateral_raise_exercise,
                R.drawable.dumbbell_arnold_press_exercise};
        final String[] exerciseDescriptions = {
                "This compound exercise is a king for shoulder development. It works all three heads of the deltoid (anterior, lateral, and posterior) along with your core and triceps. You can perform it with a barbell or dumbbells, adjusting your grip width for slightly different muscle emphasis.\n\n\n\n\n\n\n",
                "This exercise isolates the medial deltoid, the rounded muscle on the outer shoulder. It helps create definition and width in your shoulders. You can perform lateral raises with dumbbells or cables, keeping your elbows slightly bent and lifting your arms out to the sides.\n\n\n\n\n\n\n",
                "This exercise primarily targets the anterior deltoid, the muscle on the front of your shoulder. It helps build strength and contributes to a sculpted upper body. You can perform front raises with dumbbells or a barbell, keeping your arms straight and lifting them out in front of your body.\n\n\n\n\n\n\n",
                " This exercise isolates the posterior deltoid, the muscle on the back of your shoulder. It's important for maintaining shoulder health and posture. You can perform rear delt flyes using a cable machine, leaning forward with a slight bend in your knees and raising your arms out and back with a squeezing motion.\n\n\n\n\n\n\n",
                "This unique exercise combines elements of a shoulder press and a lateral raise, targeting all three heads of the deltoid. You can perform it with dumbbells, starting with your palms facing your body and rotating them outward as you press the weights overhead.\n\n\n\n\n\n\n"
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
