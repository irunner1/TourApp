package com.example.kr.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;

import com.example.kr.R;
import com.example.kr.fragments.FindFragment;
import com.example.kr.pages.AntaliaFragment;
import com.example.kr.pages.BarsaFragment;
import com.example.kr.pages.EditFragment;
import com.example.kr.pages.HelpFragment;
import com.example.kr.pages.HotelsFragment;
import com.example.kr.pages.ItalyFragment;
import com.example.kr.pages.NYFragment;
import com.example.kr.pages.AbkhaziaFragment;
import com.example.kr.pages.NotificationsFragment;
import com.example.kr.pages.ParisFragment;
import com.example.kr.pages.PaymentFragment;
import com.example.kr.pages.RestaurantsFragment;
import com.example.kr.pages.RomaFragment;
import com.example.kr.pages.SettingsFragment;
import com.example.kr.pages.SingaporeFragment;
import com.example.kr.pages.ToursFragment;
import com.example.kr.pages.TurkeyFragment;

public class TourActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);
        Bundle extras = getIntent().getExtras();

        //Главная страница
        if (extras.getString("name").equals("Нью-Йорк")) {
            Fragment fragment = new NYFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }
        if (extras.getString("name").equals("Барселона")) {
            Fragment fragment = new BarsaFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }
        if (extras.getString("name").equals("Рим")) {
            Fragment fragment = new RomaFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }
        if (extras.getString("name").equals("Анталья")) {
            Fragment fragment = new AntaliaFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }
        if (extras.getString("name").equals("Турция")) {
            Fragment fragment = new TurkeyFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }
        if (extras.getString("name").equals("Италия")) {
            Fragment fragment = new ItalyFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }
        if (extras.getString("name").equals("Абхазия")) {
            Fragment fragment = new AbkhaziaFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }

        //Страница Поиск
        if (extras.getString("name").equals("Сингапур")) {
            Fragment fragment = new SingaporeFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }
        if (extras.getString("name").equals("Париж")) {
            Fragment fragment = new ParisFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }
        if (extras.getString("name").equals("Поиск")) {
            Fragment fragment = new FindFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }

        if (extras.getString("name").equals("Туры")) {
            Fragment fragment = new ToursFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }
        if (extras.getString("name").equals("Отели")) {
            Fragment fragment = new HotelsFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }
        if (extras.getString("name").equals("Рестораны")) {
            Fragment fragment = new RestaurantsFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }

        if (extras.getString("name").equals("Настройки")) {
            Fragment fragment = new SettingsFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }
        if (extras.getString("name").equals("Справка")) {
            Fragment fragment = new HelpFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }
        if (extras.getString("name").equals("Оплата")) {
            Fragment fragment = new PaymentFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }
        if (extras.getString("name").equals("Уведомления")) {
            Fragment fragment = new NotificationsFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }
        if (extras.getString("name").equals("Редактировать")) {
            Fragment fragment = new EditFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}