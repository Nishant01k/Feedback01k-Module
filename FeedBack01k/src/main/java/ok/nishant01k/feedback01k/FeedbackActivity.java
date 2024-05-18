package ok.nishant01k.feedback01k;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FeedbackActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private EditText messageEditText;
    private Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedbackmodule);

        // Initialize UI components
        ratingBar = findViewById(R.id.ratingBar);
        messageEditText = findViewById(R.id.messageEditText);
        submitBtn = findViewById(R.id.submitBtn);

        // Handle submit button click
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rating = ratingBar.getRating();
                String feedbackMessage = messageEditText.getText().toString().trim();

                // Check if rating is given
                if (rating == 0) {
                    Toast.makeText(FeedbackActivity.this, "Please provide a rating", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Check if feedback message is provided
                if (feedbackMessage.isEmpty()) {
                    Toast.makeText(FeedbackActivity.this, "Please leave your feedback", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Here, you can implement your logic to submit feedback to a server, database, etc.
                // For now, let's just show a toast message indicating feedback submission.
                Toast.makeText(FeedbackActivity.this, "Feedback submitted successfully", Toast.LENGTH_SHORT).show();

                // Optionally, you can finish the activity after feedback submissions
                finish();
            }
        });
    }
}
