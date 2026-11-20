package com.example.a20243006965_assignmentone;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * Main screen of the CampusLife app.
 * <p>
 * Shows the banner and the four topic image buttons. Each button shows a Toast and
 * starts {@link DetailActivity} with an explicit Intent that carries the index of the
 * clicked topic; that index is the unique identifier the detail screen works with.
 */
public class MainActivity extends AppCompatActivity {

    /** Key of the unique identifier passed to DetailActivity. */
    public static final String EXTRA_TOPIC_INDEX = "extra_topic_index";

    /** Topic indexes, kept in the same order as the arrays in arrays.xml. */
    private static final int TOPIC_FACILITIES = 0;
    private static final int TOPIC_EVENTS = 1;
    private static final int TOPIC_CLUBS = 2;
    private static final int TOPIC_SUPPORT = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Every image button has its own click listener.
        findViewById(R.id.btnFacilities).setOnClickListener(v -> onFacilitiesClicked());
        findViewById(R.id.btnEvents).setOnClickListener(v -> onEventsClicked());
        findViewById(R.id.btnClubs).setOnClickListener(v -> onClubsClicked());
        findViewById(R.id.btnSupport).setOnClickListener(v -> onSupportClicked());
    }

    /** Handles a click on the Facilities button. */
    private void onFacilitiesClicked() {
        Toast.makeText(this, "Facilities clicked", Toast.LENGTH_SHORT).show();
        openDetail(TOPIC_FACILITIES);
    }

    /** Handles a click on the Events button. */
    private void onEventsClicked() {
        Toast.makeText(this, "Events clicked", Toast.LENGTH_SHORT).show();
        openDetail(TOPIC_EVENTS);
    }

    /** Handles a click on the Clubs button. */
    private void onClubsClicked() {
        Toast.makeText(this, "Clubs clicked", Toast.LENGTH_SHORT).show();
        openDetail(TOPIC_CLUBS);
    }

    /** Handles a click on the Support button. */
    private void onSupportClicked() {
        Toast.makeText(this, "Support clicked", Toast.LENGTH_SHORT).show();
        openDetail(TOPIC_SUPPORT);
    }

    /**
     * Starts DetailActivity with an explicit Intent and passes the topic index
     * as the unique identifier.
     *
     * @param topicIndex index of the clicked topic, matching the arrays in arrays.xml
     */
    private void openDetail(int topicIndex) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(EXTRA_TOPIC_INDEX, topicIndex);
        startActivity(intent);
    }
}
