package es.iessaladillo.pedrojoya.pr08.ui.main;


import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import es.iessaladillo.pedrojoya.pr08.R;

public class MainFragment extends Fragment {

    private LoadDetailFragment loadDetailFragmentListener;
    private Toolbar toolbar;
    private LoadSettingsFragment loadSettingsFragmentListener;
    private TextView txtLorem;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
        MainActivityViewModel viewModel = ViewModelProviders.of(this).get(
                MainActivityViewModel.class);
        setupViews();
        viewModel.getTxtContent().observe(this, this::setText);
        setupToolbar();
    }

    private void setText(String key) {
        if(TextUtils.equals(key, getString(R.string.prefTextType_defaultValue))) {
            txtLorem.setText(getString(R.string.main_latin_ipsum));
        } else {
            txtLorem.setText(getString(R.string.main_chiquito_ipsum));
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        loadDetailFragmentListener = (LoadDetailFragment) context;
        loadSettingsFragmentListener = (LoadSettingsFragment) context;
    }

    private void setupViews() {
        toolbar = ActivityCompat.requireViewById(requireActivity(), R.id.toolbarMain);
        FloatingActionButton fab = ActivityCompat.requireViewById(requireActivity(), R.id.fabMain);
        txtLorem = ActivityCompat.requireViewById(requireActivity(), R.id.textLoremMain);
        
        //Fab's listener
        fab.setOnClickListener(v -> loadDetailFragmentListener.onClickFab());
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void setupToolbar() {
        toolbar.setTitle(R.string.toolbarLoremTitle);
        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemSettings:
                loadSettingsFragmentListener.onClickItemMenu();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public interface LoadDetailFragment {
        void onClickFab();
    }

    public interface LoadSettingsFragment {
        void onClickItemMenu();
    }
}
