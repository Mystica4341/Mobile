package com.bt.demofragmentlab6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class DynamicFragment extends AppCompatActivity {

    Button btn1, btn2;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);
        addControls();
        addEvents();
    }

    public void addControls(){
        btn1 = (Button) findViewById(R.id.btnFrag1);
        btn2 = (Button) findViewById(R.id.btnFrag2);
        frameLayout = (FrameLayout) findViewById(R.id.Dynamic_Fragment);
    }

    public void addEvents(){
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenFragment(new DynamicFragment1());
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenFragment(new DynamicFragment2());
            }
        });
    }

    public void OpenFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        //đẩy fragment tương ứng lên
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.Dynamic_Fragment, fragment);
        ft.commit();
    }
}