package com.example.a20243006965_assignmentone;

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
 * Part E: every topic button has its own click listener. At this stage each listener
 * only shows a Toast, so the click wiring can be checked before DetailActivity exists.
 */
public class MainActivity extends AppCompatActivity {

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

        findViewById(R.id.btnFacilities).setOnClickListener(v -> onFacilitiesClicked());
        findViewById(R.id.btnEvents).setOnClickListener(v -> onEventsClicked());
        findViewById(R.id.btnClubs).setOnClickListener(v -> onClubsClicked());
        findViewById(R.id.btnSupport).setOnClickListener(v -> onSupportClicked());
    }

    /** Handles a click on the Facilities button. */
    private void onFacilitiesClicked() {
        Toast.makeText(this, "Facilities clicked", Toast.LENGTH_SHORT).show();
    }

    /** Handles a click on the Events button. */
    private void onEventsClicked() {
        Toast.makeText(this, "Events clicked", Toast.LENGTH_SHORT).show();
    }

    /** Handles a click on the Clubs button. */
    private void onClubsClicked() {
        Toast.makeText(this, "Clubs clicked", Toast.LENGTH_SHORT).show();
    }

    /** Handles a click on the Support button. */
    private void onSupportClicked() {
        Toast.makeText(this, "Support clicked", Toast.LENGTH_SHORT).show();
    }
}
