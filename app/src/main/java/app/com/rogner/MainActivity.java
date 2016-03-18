package app.com.rogner;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=new Intent(this,PdfActivity.class);
            startActivity(intent);

    }

}
