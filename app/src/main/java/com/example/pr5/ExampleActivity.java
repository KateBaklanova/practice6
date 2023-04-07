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
import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.Update;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

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



    @Entity
    public class User {
        @PrimaryKey
        public int uid;
        @ColumnInfo(name = "first_name")
        public String firstName;
        @ColumnInfo(name = "last_name")
        public String lastName;
    }

    @Dao
    public interface UserDao {
        @Query("SELECT * FROM user")
        List<User> getAll();
        @Query("SELECT * FROM user WHERE uid IN (:userIds)")
        List<User> loadAllByIds(int[] userIds);
        @Query("SELECT * FROM user WHERE first_name LIKE :first AND " + "last_name LIKE :last LIMIT 1")
        User findByName(String first, String last);
        @Insert
        void insert(User user);
        @Update
        void update(User user);
        @Insert
        void insertMany(User... users);
        @Delete
        void delete(User user);
    }

    @Database(entities = {User.class}, version = 1)
    public abstract class AppDatabase extends RoomDatabase {
        public abstract UserDao userDao();
    }

    @Override
    public boolean onSupportNavigateUp() {
        return Navigation.findNavController(this, R.id.nav_host_fragment).navigateUp();
    }

    @Override
    protected void onResume() {
        super.onResume();
        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database-name").build();
        UserDao userDao = db.userDao();
        List<User> users = userDao.getAll();
    }
}
