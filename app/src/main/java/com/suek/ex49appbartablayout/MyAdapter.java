package com.suek.ex49appbartablayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {

    Fragment[] frags= new Fragment[3];   //fragment 배열 참조변수
    String[] tabTexts= new String[]{"Home","Theme","Talk"};


    public MyAdapter(@NonNull FragmentManager fm) {
        super(fm);

        frags[0]= new Tab1Fragment();
        frags[1]= new Tab2Fragment();
        frags[2]= new Tab3Fragment();

    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        return frags[position];
    }

    @Override
    public int getCount() {
        return frags.length;
    }


    //탭레이아웃과 연동한다면 탭버튼의 보여질 글씨를 리턴해주는 메소드가 따로있음..
    //단점은 아이콘을 만들수없어서 메인자바로 가서 만들기..
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTexts[position];
    }
}
