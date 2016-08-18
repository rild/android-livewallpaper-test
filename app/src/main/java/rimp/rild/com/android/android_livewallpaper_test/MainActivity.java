package rimp.rild.com.android.android_livewallpaper_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import rimp.rild.com.android.android_livewallpaper_test.chiralcode.livewallpaper.WallpaperActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void go(View v) {
        Intent intent = new Intent(getApplicationContext(), WallpaperActivity.class);
        startActivity(intent);
    }
}
