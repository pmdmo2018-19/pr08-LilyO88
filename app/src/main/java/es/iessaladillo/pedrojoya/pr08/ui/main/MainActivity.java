package es.iessaladillo.pedrojoya.pr08.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import es.iessaladillo.pedrojoya.pr08.R;
import es.iessaladillo.pedrojoya.pr08.ui.detail.Detail_fragment;
import es.iessaladillo.pedrojoya.pr08.ui.settings.Settings_fragment;
import es.iessaladillo.pedrojoya.pr08.utils.FragmentUtils;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MainFragment.LoadDetailFragment, MainFragment.LoadSettingsFragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            FragmentUtils.replaceFragment(getSupportFragmentManager(),
                            R.id.flContainerMainActivity, MainFragment.newInstance(), MainFragment.class.getSimpleName());
        }
    }

    @Override
    public void onClickFab() {
        FragmentUtils.replaceFragmentAddToBackstack(getSupportFragmentManager(), R.id.flContainerMainActivity, Detail_fragment.newInstance(),
                Detail_fragment.class.getSimpleName(), MainFragment.class.getSimpleName(), 0);
    }

    @Override
    public boolean onNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onClickItemMenu() {
        FragmentUtils.replaceFragmentAddToBackstack(getSupportFragmentManager(), R.id.flContainerMainActivity, Settings_fragment.newInstance(),
                Detail_fragment.class.getSimpleName(), MainFragment.class.getSimpleName(), 0);
    }
}
