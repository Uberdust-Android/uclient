package eu.uberdust.uClient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.viewpagerindicator.PageIndicator;
import com.viewpagerindicator.TabPageIndicator;

import eu.uberdust.model.Room;
import eu.uberdust.myfragments.MyCapabilitiesFragment;
import eu.uberdust.myfragments.MyCommandsFragment;

public class RoomActivity extends FragmentActivity {
	
	private static final String[] CONTENT = new String[] { "Capabilities", "Commands" };
    MyFragmentAdapter mAdapter;
    ViewPager mPager;
    PageIndicator mIndicator;
    Room room;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        
        Intent i = getIntent();
        room = (Room)i.getSerializableExtra("MyRoom");
        
        mAdapter = new MyFragmentAdapter(getSupportFragmentManager());

        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        mIndicator = (TabPageIndicator)findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
        
    }
    
  
    class MyFragmentAdapter extends FragmentPagerAdapter {
        public MyFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
        	if(position==0)
        		return MyCapabilitiesFragment.newInstance(RoomActivity.CONTENT[position % RoomActivity.CONTENT.length] , room);
        	else
        		return MyCommandsFragment.newInstance(RoomActivity.CONTENT[position % RoomActivity.CONTENT.length] , room);
        }

        @Override
        public int getCount() {
            return RoomActivity.CONTENT.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return RoomActivity.CONTENT[position % RoomActivity.CONTENT.length].toUpperCase();
        }
    }
    
}
