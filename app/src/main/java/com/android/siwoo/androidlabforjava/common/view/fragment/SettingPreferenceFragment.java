package com.android.siwoo.androidlabforjava.common.view.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.support.annotation.Nullable;
import com.android.siwoo.androidlabforjava.R;

public class SettingPreferenceFragment extends PreferenceFragment {
    private SharedPreferences preferences;
    ListPreference soundPreference;
    ListPreference keywordSoundPreference;
    PreferenceScreen keywordScreen;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings_preference);

        soundPreference = (ListPreference) findPreference("sound_list");
        keywordSoundPreference = (ListPreference) findPreference("keyword_sound_list");
        keywordScreen = (PreferenceScreen) findPreference("keyword_screen");

        preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        if(!"".equals(preferences.getString("sound_list",""))) {
            soundPreference.setSummary(preferences.getString("sound_list", "카톡"));
        }

        if(!"".equals(preferences.getString("keyword_sound_list", ""))) {
            keywordSoundPreference.setSummary(preferences.getString("keyword_sound_list", "카톡"));
        }
        if(preferences.getBoolean("keyword", false)) {
            keywordScreen.setSummary("사용");
        }

        preferences.registerOnSharedPreferenceChangeListener(
                (_preferences, key) -> {
                    if("sound_list".equals(key)) {
                        soundPreference.setSummary(_preferences.getString("sound_list", "카톡"));
                    }
                    if("keyword_sound_list".equals(key)) {
                        keywordSoundPreference.setSummary(_preferences.getString("keyword_sound_list", "카톡"));
                    }
                }
        );
    }
}
