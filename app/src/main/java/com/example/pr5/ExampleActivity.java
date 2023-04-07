package com.example.pr5;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExampleActivity extends AppCompatActivity {

    public ExampleActivity() {
        super(R.layout.activity);
    }
    Context context;
    String inf ="inf";
    NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("App specific directory = "+ this.getFilesDir().getAbsolutePath());
        try(FileOutputStream fos = this.openFileOutput("text.txt", MODE_PRIVATE)){
            fos.write(inf.getBytes());
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return Navigation.findNavController(this, R.id.nav_host_fragment).navigateUp();
    }

}
