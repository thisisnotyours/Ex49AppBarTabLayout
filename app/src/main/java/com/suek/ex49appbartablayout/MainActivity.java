package com.suek.ex49appbartablayout;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    //햄버거메뉴 만들기
    DrawerLayout drawerLayout;

    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    TabLayout tabLayout;

    ViewPager pager;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout= findViewById(R.id.tablayout);

       /* //탭버튼(tab) 객체생성
        TabLayout.Tab tab1= tabLayout.newTab();
        tab1.setText("HOME");
        tab1.setIcon(R.mipmap.ic_launcher);
        tab1.setTag("tab1");      //탭버튼의 식별글씨(id 같은 역할- id 대신 tag 속성씀)
        tabLayout.addTab(tab1);

        //탭객체 위에서 하는 것처럼 말고 한방에 만드는 법
        TabLayout.Tab tab2= tabLayout.newTab().setText("Theme").setIcon(R.mipmap.ic_launcher).setTag("tab2");   //한줄로 쓰기
        tabLayout.addTab(tab2);

        //더 줄이는 법
        tabLayout.addTab(tabLayout.newTab().setText("Talk").setIcon(R.mipmap.ic_launcher).setTag("tab3"));  //바로 new 해주기*/

        //ViewPager 에 Adapter 설정
        adapter= new MyAdapter( getSupportFragmentManager() );
        pager= findViewById(R.id.pager);
        pager.setAdapter(adapter);

        //TabLayout 과 ViewPager 를 연동하기!
        //이것들을 연동하면 Tab 버튼의 글씨는 뷰페이져의 아답터에서 결정함.
        //즉, 위 Tab 객체 추가는 의미없어짐
        tabLayout.setupWithViewPager(pager);

        //연동을 시키면 기본적으로 탭버튼에 아이콘을 만들수없다.
        //만약 하고싶다면...
        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_launcher);

        //제목줄관리자 (ActionBar)에게 서브제목 설정가능
        getSupportActionBar().setSubtitle("Home");

        //탭이 변경되는 것을 듣는 리스너 객체 추가
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                getSupportActionBar().setSubtitle(tab.getText());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });




        drawerLayout= findViewById(R.id.layout_drawer);
        navigationView= findViewById(R.id.nav);
        drawerToggle= new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);  //R.string.app_name, R.string.app_name 시각장애인
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }
}
