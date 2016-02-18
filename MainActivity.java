package com.example.solution_color;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;


public class MainActivity extends AppCompatActivity  {
    private static final int TAKE_PICTURE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent myIntent = new Intent(this, SettingsActivity.class);
                startActivity(myIntent);
                break;
            case R.id.action_about:
                doAbout();
                break;
            case R.id.action_share:
                Toast.makeText(this,"Share",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_colorize:
                Toast.makeText(this,"Colorize",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_edit:
                Toast.makeText(this,"Edit",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_reset:
                Toast.makeText(this,"Reset",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void doAbout() {

       AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("This is the about page");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Clicked ok in about", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void takePicture(View view) {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        File outputFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "MyPicture.png");

        Uri outputFileUri = Uri.fromFile(outputFile);

        intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);

        startActivityForResult(intent, TAKE_PICTURE);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        DisplayMetrics metrics = this.getResources().getDisplayMetrics();

        int screenheight = metrics.heightPixels;
        int screenwidth = metrics.widthPixels;
//
//        if(requestCode == TAKE_PICTURE) {
//            Bitmap bmp = Camera_Helpers.loadAndScaleImage(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "MyPicture.png", screenheight, screenwidth);
//
//            if (Camera_Helpers.saveProcessedImage(bmp, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "MyPicture.png")) {
//
//                Toast.makeText(MainActivity.this, "Picture is saved?", Toast.LENGTH_SHORT).show();
//
//
//            }
//        }

    }
}

