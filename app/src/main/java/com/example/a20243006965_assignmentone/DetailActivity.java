package com.example.a20243006965_assignmentone;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * Detail screen of the CampusLife app.
 * <p>
 * Reads the topic index that MainActivity passed through the Intent and uses it
 * directly as the index into the three parallel arrays in arrays.xml. Because the
 * identifier is the array index, no if statements or switch cases are needed.
 */
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Unique identifier of the topic that was clicked in MainActivity.
        int topicIndex = getIntent().getIntExtra(MainActivity.EXTRA_TOPIC_INDEX, 0);

        // The three parallel dummy data arrays from arrays.xml.
        String[] titles = getResources().getStringArray(R.array.detail_titles);
        String[] contents = getResources().getStringArray(R.array.detail_contents);
        String[] imageNames = getResources().getStringArray(R.array.detail_images);

        // Views to populate.
        TextView tvTitle = findViewById(R.id.tvDetailTitle);
        TextView tvContent = findViewById(R.id.tvDetailContent);
        ImageView ivImage = findViewById(R.id.ivDetailImage);

        // Populate the UI from the arrays, using the identifier as the index.
        tvTitle.setText(titles[topicIndex]);
        tvContent.setText(contents[topicIndex]);

        int imageId = getResources()
                .getIdentifier(imageNames[topicIndex], "drawable", getPackageName());
        ivImage.setImageResource(imageId);
        ivImage.setContentDescription(titles[topicIndex]);
    }
}
