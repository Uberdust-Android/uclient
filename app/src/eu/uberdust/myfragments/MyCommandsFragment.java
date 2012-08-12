package eu.uberdust.myfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import eu.uberdust.model.Room;
import eu.uberdust.uClient.R;

public final class MyCommandsFragment extends Fragment {

	Room room;
	
    public static MyCommandsFragment newInstance(String content ,Room iroom) {
        MyCommandsFragment fragment = new MyCommandsFragment();
        fragment.room=iroom;
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ListView list = new ListView(getActivity());
        
        MyCommandsAdapter adapter = new MyCommandsAdapter(getActivity(), R.layout.list_row_commands, room.getCommands());
        list.setAdapter(adapter);
        
        LinearLayout layout = new LinearLayout(getActivity());
        layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        layout.addView(list);

        return layout;
    }

}
