package com.android.siwoo.androidlabforjava.common.view.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.*;
import android.support.annotation.Nullable;
import com.android.siwoo.androidlabforjava.R;

public class StepSettingPreferenceFragment extends PreferenceFragment {
    private SharedPreferences preferences;
    private ListPreference keywordList;
    private ListPreference soundList;
    private PreferenceScreen keywordScreen;
    private static final String KEYWORD_LIST = "keyword_list";
    private static final String SOUND_LIST = "sound_list";
    private static final String KEYWORD_SCREEN = "keyword_screen";
    private static final String DEFAULT_ALARM = "카톡";
    public final SharedPreferences.OnSharedPreferenceChangeListener preferencesChangeListener = (_preference, _key) -> {
        if(_key == SOUND_LIST) {
            soundList.setSummary(_preference.getString(SOUND_LIST, DEFAULT_ALARM));
        }
        if(_key == KEYWORD_LIST) {
            keywordList.setSummary(_preference.getString(KEYWORD_LIST, DEFAULT_ALARM));
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settsings_preference2);

        init();
        getValueFromXML();
        preferences.registerOnSharedPreferenceChangeListener(preferencesChangeListener);
    }

    private void getValueFromXML() {
        preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        if(!"".equals(preferences.getString(SOUND_LIST, ""))) {
            soundList.setSummary(DEFAULT_ALARM);
        }
        if(!"".equals(preferences.getString(KEYWORD_LIST, ""))) {
            keywordList.setSummary(DEFAULT_ALARM);
        }
        if(preferences.getBoolean(KEYWORD_SCREEN, false)) {
            keywordScreen.setSummary("사용");
        }
    }

    private void init() {
        keywordList = (ListPreference) findPreference(KEYWORD_LIST);
        soundList = (ListPreference) findPreference(SOUND_LIST);
        keywordScreen = (PreferenceScreen) findPreference(KEYWORD_SCREEN);
    }
}
