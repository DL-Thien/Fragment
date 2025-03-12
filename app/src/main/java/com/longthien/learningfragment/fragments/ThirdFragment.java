package com.longthien.learningfragment.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.longthien.learningfragment.OnDataPassListener;
import com.longthien.learningfragment.R;

public class ThirdFragment extends Fragment {
    private OnDataPassListener onDataPassListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onDataPassListener = (OnDataPassListener) getActivity();
        assert getActivity() != null;
        CardView cardViewThird = getActivity().findViewById(R.id.cardViewThird);
        cardViewThird.setOnClickListener(v -> onDataPassListener.onDataPass("Third Fragment"));
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onDataPassListener = null;
    }
}
