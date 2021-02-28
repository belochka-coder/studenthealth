package com.example.project;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration; // переменная для меню

    @Override // переопределяем метод, который написан далее
    protected void onCreate(Bundle savedInstanceState) { //создаем активити, объявляем метод
        super.onCreate(savedInstanceState); //вызываем родительский метод
        setContentView(R.layout.activity_main); // задаем связь с xml файлом
        // создаем иконку меню - три полосочки
        Toolbar toolbar = findViewById(R.id.toolbar); // заводим переменную для Tool bar (инструменты для панели сверху)
        setSupportActionBar(toolbar); // устанавливаем отображение Tool bar
        // 30 - 38 удалим
        FloatingActionButton fab = findViewById(R.id.fab); // создаем переменную для кнопки три полосочки
        fab.setOnClickListener(new View.OnClickListener() { // метод, который срабатывает при клике
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout); // создаем переменную для контейнера для отрисовки меню
        NavigationView navigationView = findViewById(R.id.nav_view); // создаём переменную (navigationView для меню
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder( //создаем конфигурацию меню. Конфигурация описывает, как будет выглядеть меню
                R.id.nav_home, R.id.nav_Расписание, R.id.nav_Разминка, R.id.nav_Шагомер, R.id.nav_Питание)
                .setDrawerLayout(drawer) //устаревшая: привязывает конфигурацию к контейнеру
                .build(); // создаем конфигурацию
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment); // создаем контроллер, то, что обрабатывает нажатие
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration); // связываем контроллер с конфигурацией
        NavigationUI.setupWithNavController(navigationView, navController); // связываем navigationView для меню с контроллером
    }

    @Override // переопределяем метод, который написан далее
    public boolean onCreateOptionsMenu(Menu menu) { // метод отрисовки меню
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu); // отрисовка меню по xml
        return true; // возвращаем true т.к.это функция и она должна что то вернуть
    }

    @Override // переопределяем метод, который написан далее
    public boolean onSupportNavigateUp() { // метод, который обрабатывает включение поддержки кнопки назад
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment); // создаем контроллер, то, что обрабатывает нажатие
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp(); // возвращаемое значение, зависит от правильности  определения меню.
    }
}