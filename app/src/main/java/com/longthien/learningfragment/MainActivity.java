package com.longthien.learningfragment;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.longthien.learningfragment.fragments.FirstFragment;
import com.longthien.learningfragment.fragments.FourFragment;
import com.longthien.learningfragment.fragments.SecondFragment;
import com.longthien.learningfragment.fragments.ThirdFragment;

public class MainActivity extends AppCompatActivity implements OnDataPassListener {

    TextView tvFragmentName;
    CardView cardViewFirst;
    CardView cardViewSecond;
    CardView cardViewThird;
    CardView cardViewFour;

    private FirstFragment firstFragment;
    private SecondFragment secondFragment;
    private ThirdFragment thirdFragment;
    private FourFragment fourFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        bindingView();

        cardViewFirst.setOnClickListener(v -> {
            firstFragment = (FirstFragment) getSupportFragmentManager().findFragmentById(R.id.container_fragment_first);
            if (firstFragment != null) {
                firstFragment.registerReceiveDataFromFirstFragment(this);
                firstFragment.sendData();
            }
        });

        cardViewSecond.setOnClickListener(v -> {
            secondFragment = (SecondFragment) getSupportFragmentManager().findFragmentById(R.id.container_fragment_second);
            if (secondFragment != null) {
                secondFragment.registerReceiveDataFromSecondFragment(this);
                secondFragment.sendData();
            }
        });

        cardViewThird.setOnClickListener(v -> {
            thirdFragment = (ThirdFragment) getSupportFragmentManager().findFragmentById(R.id.container_fragment_third);
            if (thirdFragment != null) {
                thirdFragment.registerReceiveDataFromThirdFragment(this);
                thirdFragment.sendData();
            }
        });

        cardViewFour.setOnClickListener(v -> {
            fourFragment = (FourFragment) getSupportFragmentManager().findFragmentById(R.id.container_fragment_four);
            if (fourFragment != null) {
                fourFragment.registerReceiveDataFromFourFragment(this);
                fourFragment.sendData();
            }
        });
    }

    @Override
    public void onDataPass(String fragmentName) {
        if (fragmentName == null) {
            return;
        }
        tvFragmentName.setText(fragmentName);
    }

    private void bindingView() {

        cardViewFirst = findViewById(R.id.cardViewFirst);
        cardViewSecond = findViewById(R.id.cardViewSecond);
        cardViewThird = findViewById(R.id.cardViewThird);
        cardViewFour = findViewById(R.id.cardViewFour);
        tvFragmentName = findViewById(R.id.tvFragmentName);
        initFragmentView(R.id.container_fragment_first, new FirstFragment(), "First Fragment");
        initFragmentView(R.id.container_fragment_second, new SecondFragment(), "Second Fragment");
        initFragmentView(R.id.container_fragment_third, new ThirdFragment(), "Third Fragment");
        initFragmentView(R.id.container_fragment_four, new FourFragment(), "Four Fragment");

    }

    private void initFragmentView(int id, Fragment fragment, String fragmentName) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().setReorderingAllowed(true).add(id, fragment, fragmentName).commit();
    }
}