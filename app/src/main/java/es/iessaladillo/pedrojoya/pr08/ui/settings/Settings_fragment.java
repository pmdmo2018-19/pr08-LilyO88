package es.iessaladillo.pedrojoya.pr08.ui.settings;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.preference.PreferenceFragmentCompat;
import es.iessaladillo.pedrojoya.pr08.R;

import android.os.Bundle;

public class Settings_fragment extends PreferenceFragmentCompat {

    private Toolbar toolbar;

    public static Settings_fragment newInstance() {
        return new Settings_fragment();
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String key) {
        setPreferencesFromResource(R.xml.preferences, key);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupViews();
        setupToolbar();
    }

    private void setupViews() {
        toolbar = ActivityCompat.requireViewById(requireActivity(), R.id.toolbarSettings);

    }

    private void setupToolbar() {
        toolbar.setTitle(R.string.settingsTitleToolbar);
        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);

        ((AppCompatActivity) requireActivity()).getSupportActionBar().setDisplayShowTitleEnabled(true);
        ((AppCompatActivity) requireActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(v -> onBackPressedFragment());
    }

    private void onBackPressedFragment() {
        requireActivity().onBackPressed();
    }

}
