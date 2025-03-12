package com.longthien.learningfragment;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
            if (firstFragment != null) firstFragment.sendData();
        });

//        Bundle argActivity = new Bundle();
//        argActivity.putString("Bundle", "From Activity");

//        getSupportFragmentManager().beginTransaction()
//                .setReorderingAllowed(true)
//                .add(R.id.fragment_container_view, ExampleFragment.class, argActivity)
//                .commit();
    }

    private void bindingView() {
        getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                .replace(R.id.container_fragment_first, FirstFragment.class, null).commit();

        getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                .replace(R.id.container_fragment_second, SecondFragment.class, null).commit();

        getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                .replace(R.id.container_fragment_third, ThirdFragment.class, null).commit();

        getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                .replace(R.id.container_fragment_four, FourFragment.class, null).commit();

        cardViewFirst = findViewById(R.id.cardViewFirst);
        cardViewSecond = findViewById(R.id.cardViewSecond);
        cardViewThird = findViewById(R.id.cardViewThird);
        cardViewFour = findViewById(R.id.cardViewFour);
        tvFragmentName = findViewById(R.id.tvFragmentName);
    }

    @Override
    public void onDataPass(String fragmentName) {
        if (fragmentName == null) {
            return;
        }
        tvFragmentName.setText(fragmentName);
    }
}