package app.com.rogner;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class SpanActivity extends AppCompatActivity {
    TextView textView;
    Drawable drawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_span);
        textView=(TextView)findViewById(R.id.textview);
        SpannableString sstr = new SpannableString("Spannable image an text activity");
        String imgLacation=getIntent().getStringExtra("imgLacation");
        Uri uri= Uri.parse(imgLacation);
        Uri yourUri= uri;
        try {
            InputStream inputStream = getContentResolver().openInputStream(yourUri);
            drawable = Drawable.createFromStream(inputStream, yourUri.toString() );
        } catch (FileNotFoundException e) {

        }
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        ImageSpan span = new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE);
        sstr.setSpan(span, 0, 3, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        textView.setText(sstr);
    }

}
