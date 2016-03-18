package app.com.rogner;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.joanzapata.pdfview.PDFView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class PdfActivity extends AppCompatActivity implements View.OnClickListener {
    PDFView pdfView;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        b=(Button)findViewById(R.id.button);
        b.setOnClickListener(this);
        pdfView=(PDFView)findViewById(R.id.pdfview);;
        pdfView.fromAsset("sample.pdf")
                .pages(0, 2, 1, 3, 3, 3)
                .defaultPage(1)
                .showMinimap(false)
                .enableSwipe(true)
                .load();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==b.getId()){
            pdfView.buildDrawingCache();
            Bitmap bitmap =    pdfView.getDrawingCache();// view.getDrawingCache();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            byte[] bytes = stream.toByteArray();
            Intent intent=new Intent(this,ImgActivity.class);
            intent.putExtra("BitmapImage",bytes);
            startActivity(intent);
        }
    }
}
