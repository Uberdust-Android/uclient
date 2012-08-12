package eu.uberdust.myfragments;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import eu.uberdust.model.Capability;
import eu.uberdust.uClient.R;

public class MyCommandsAdapter extends ArrayAdapter<Capability>{
	Context context;
	int layoutResourceId;
	ArrayList<Capability> commands;
	
	public MyCommandsAdapter(Context context, int layoutResourceId ,ArrayList<Capability> commands) {
		super(context, layoutResourceId , commands);
		this.context = context;
		this.commands = commands;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		ViewHolder holder = null;
		
		int theType = getItemViewType(position);
		
		if(row == null){
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			holder = new ViewHolder();
			
			
			  if (theType == 0) {
				  row = inflater.inflate(R.layout.list_row_commands, parent, false);
				  holder.textView1 = (TextView) row.findViewById(R.id.textView1);
				  holder.button1 = (Button) row.findViewById(R.id.button1);
				  
				  holder.textView1.setText(commands.get(position).getName());
			  }
			  else if (theType == 1){
				  
			  }
			
			
			row.setTag(holder);

		}
		else{
			holder = (ViewHolder)row.getTag();
		}
		
		

		return row;
	}
	
	static class ViewHolder{
		TextView textView1;
		Button button1;
	}
	@Override
	public int getViewTypeCount() {
	   return 1;
	}

	@Override
	public int getItemViewType(int position) {
		/*if(values.get(position).contains("1") || values.get(position).contains("2") ||values.get(position).contains("3")){
			return 1;
		}
		else return 0;*/
		return 0;
	}
}