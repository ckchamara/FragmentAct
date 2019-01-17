package com.berunda.audio.fragmentact;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button1,button2;


    FragmentManager fragmentManager = getSupportFragmentManager();

    BlankFragment1 fragment = new BlankFragment1();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1= (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!fragment.isAdded()) {

                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    //customanimations have to be stated before add() to get animation work
                    fragmentTransaction.setCustomAnimations(R.anim.slide_up, R.anim.slide_down);
                    fragmentTransaction.add(R.id.fragment1, fragment, "first");//first is identifire tag
                    fragmentTransaction.addToBackStack(null);

                    // fragmentTransaction.setTransitionStyle(R.anim.slide_up);
                    fragmentTransaction.commit();
                }
                else{
                    FragmentManager fragmentManager1 = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();

                    Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment1);

                    fragmentTransaction1.remove(fragment);
                    fragmentTransaction1.commit();

                }


            }
        });

        button2= (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager1 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();

                Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment1);
                fragmentTransaction1.setCustomAnimations(R.anim.slide_down, R.anim.slide_down);
                fragmentTransaction1.remove(fragment);
                fragmentTransaction1.commit();

                }
        });


    }

    public void viewfragment(View view)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        BlankFragment1 fragment = new BlankFragment1();
        fragmentTransaction.add(R.id.fragment1, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

             /*   if (fragment.isHidden())
               {
                    fragmentTransaction1.show(fragment);
                } else {
                    fragmentTransaction1.hide(fragment);
                }

                fragmentTransaction1.commit();      */

    }


}
