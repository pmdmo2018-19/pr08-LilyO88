package es.iessaladillo.pedrojoya.pr08.ui.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import es.iessaladillo.pedrojoya.pr08.R;
import es.iessaladillo.pedrojoya.pr08.utils.ToastUtils;

public class Detail_fragment extends Fragment {

    private FloatingActionButton fab;

    public static Fragment newInstance() {
        return new Detail_fragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.detail_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupViews();
    }

    private void setupViews() {
        Toolbar toolbar = ActivityCompat.requireViewById(requireActivity(), R.id.toolbarDetail);
        fab = ActivityCompat.requireViewById(requireActivity(), R.id.fabDetail);

        toolbar.setTitle(R.string.detailTitle);

        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);

        /*Enable back button*/
        ((AppCompatActivity) requireActivity()).getSupportActionBar().setDisplayShowTitleEnabled(true);
        ((AppCompatActivity) requireActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*Listeners*/
        toolbar.setNavigationOnClickListener(v -> onBackPressedFragment());
        fab.setOnClickListener(v -> fabAction());
    }

    private void onBackPressedFragment() {
        requireActivity().onBackPressed();
    }

    private void fabAction() {
        ToastUtils.toast(getContext(), "Saved successfully");
        onBackPressedFragment();
    }


}
