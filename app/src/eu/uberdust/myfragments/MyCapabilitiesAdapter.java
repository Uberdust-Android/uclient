package eu.uberdust.myfragments;

import java.util.ArrayList;
import java.util.regex.Pattern;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import eu.uberdust.model.Capability;
import eu.uberdust.uClient.R;

public class MyCapabilitiesAdapter extends ArrayAdapter<Capability>{
	Context context;
	int layoutResourceId;
	ArrayList<Capability> capabilities;
	
	public MyCapabilitiesAdapter(Context context, int layoutResourceId ,ArrayList<Capability> capabilities) {
		super(context, layoutResourceId , capabilities);
		this.context = context;
		this.capabilities = capabilities;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		ViewHolder holder = null;
		
		int theType = getItemViewType(position);
		
		if(row == null){
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			holder = new ViewHolder();
			
			
			  if (theType == 0) { //default
				  row = inflater.inflate(R.layout.list_row_capabilities, parent, false);
				  holder.textView1 = (TextView) row.findViewById(R.id.textView1);
				  holder.textView2 = (TextView) row.findViewById(R.id.textView2);
				  holder.imageView1 = (ImageView) row.findViewById(R.id.imageView1);
				  
				  holder.textView1.setText(capabilities.get(position).getName());
				  holder.textView2.setText(capabilities.get(position).getValue());
				  holder.imageView1.setImageResource(R.drawable.ic_launcher);
			  }
			  else if (theType == 1){ //Temperature
				  row = inflater.inflate(R.layout.list_row_capabilities, parent, false);
				  holder.textView1 = (TextView) row.findViewById(R.id.textView1);
				  holder.textView2 = (TextView) row.findViewById(R.id.textView2);
				  holder.imageView1 = (ImageView) row.findViewById(R.id.imageView1);
				  
				  holder.textView1.setText(capabilities.get(position).getName());
				  holder.textView2.setText(capabilities.get(position).getValue());
				  holder.imageView1.setImageResource(R.drawable.thermometer);
			  }
			  else if (theType == 2){ //Light
				  row = inflater.inflate(R.layout.list_row_capabilities, parent, false);
				  holder.textView1 = (TextView) row.findViewById(R.id.textView1);
				  holder.textView2 = (TextView) row.findViewById(R.id.textView2);
				  holder.imageView1 = (ImageView) row.findViewById(R.id.imageView1);
				  
				  holder.textView1.setText(capabilities.get(position).getName());
				  holder.textView2.setText(capabilities.get(position).getValue());
				  holder.imageView1.setImageResource(R.drawable.lamp_pressed);
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
		TextView textView2;
		ImageView imageView1;
	}
	@Override
	public int getViewTypeCount() {
	   return 3;
	}

	@Override
	public int getItemViewType(int position) {
		if(Pattern.compile(Pattern.quote("light"), Pattern.CASE_INSENSITIVE).matcher(capabilities.get(position).getName()).find()  ||  Pattern.compile(Pattern.quote("lamp"), Pattern.CASE_INSENSITIVE).matcher(capabilities.get(position).getName()).find()){
			return 2;
		}
		if(Pattern.compile(Pattern.quote("temperature"), Pattern.CASE_INSENSITIVE).matcher(capabilities.get(position).getName()).find()){
			return 1;
		}
		else return 0;
	}
}