package com.example.externalstorage_storedataintextfiles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    public static final String FILE_NAME = "my_file_external_storage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);
        textView.setText(R.string.text_follow);

    }

    public void createBtn(View view) {
        String string = getString(R.string.text_lorem_ipsum);

        FileOutputStream fileOutputStream = null;

        File file = new File(FILE_NAME);

        try {
            fileOutputStream = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fileOutputStream.write(string.getBytes());
            Toast.makeText(this,"File Written :"+FILE_NAME,Toast.LENGTH_SHORT).show();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteBtn(View view) {
        File file = new File(getFilesDir(),FILE_NAME) ;
        if(file.exists()){
            deleteFile(FILE_NAME);
            Toast.makeText(this,"File Deleted",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"File doesn't exist",Toast.LENGTH_SHORT).show();
        }
    }
}
