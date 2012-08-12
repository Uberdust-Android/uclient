package eu.uberdust.uClient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import eu.uberdust.model.Capability;

public class CapabilityActivity extends Activity {

	Capability capa;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        capa = (Capability)i.getSerializableExtra("MyCapa");
        
        if(capa.getType()==0) {
        	setContentView(R.layout.capability);
        	TextView name = (TextView)findViewById(R.id.name);
        	TextView value = (TextView)findViewById(R.id.value);
        	ImageView image = (ImageView)findViewById(R.id.image);
        	name.setText(capa.getName());
        	value.setText(capa.getValue());
        	
        	if(capa.getName().contains("light") || capa.getName().contains("lamp") ){
        		image.setImageResource(R.drawable.lamp_pressed);
        	} else {
        		image.setImageResource(R.drawable.ic_launcher);
        	}
        		
        }
        else if(capa.getType()==1) {
        	setContentView(R.layout.command);
        	TextView name = (TextView)findViewById(R.id.name);
        	Button command = (Button)findViewById(R.id.command);
        	ImageView image = (ImageView)findViewById(R.id.image);
        	name.setText(capa.getName());
        	
        	
        	if(capa.getName().contains("light") || capa.getName().contains("lamp") ){
        		image.setImageResource(R.drawable.lamp_pressed);
        	} else if (capa.getName().contains("aircodition")) {
        		image.setImageResource(R.drawable.ac);
        	}else
        		image.setImageResource(R.drawable.ic_launcher);
        	}
        }
    }

