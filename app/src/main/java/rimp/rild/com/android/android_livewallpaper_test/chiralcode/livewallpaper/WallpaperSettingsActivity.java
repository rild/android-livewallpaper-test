package rimp.rild.com.android.android_livewallpaper_test.chiralcode.livewallpaper;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import rimp.rild.com.android.android_livewallpaper_test.R;

public class WallpaperSettingsActivity extends PreferenceActivity {

    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        // tell the preference API what file name should be used
        getPreferenceManager().setSharedPreferencesName("wallpaper_settings");

        // load the preferences from an XML resource
        addPreferencesFromResource(R.xml.wallpaper_settings);
        setContentView(R.layout.act_wallpaper_settings);

    }

}
