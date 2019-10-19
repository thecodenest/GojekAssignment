package rajendra.gojekassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConnectionError extends AppCompatActivity {

    Button retry;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection_error);


        retry = findViewById(R.id.retry);

        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(ConnectionError.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}
