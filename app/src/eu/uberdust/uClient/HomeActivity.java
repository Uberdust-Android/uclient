package eu.uberdust.uClient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
/*
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
*/
import eu.uberdust.model.Capability;
import eu.uberdust.model.Room;



public class HomeActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);	

    }

    
    @Override
    protected void onResume() {
        super.onResume();
        
        int read=0;
        Room room1 = new Room();
    	Capability capa1 = new Capability();
    	Capability capa2 = new Capability();
    	Capability capa3 = new Capability();
    	Capability capa4 = new Capability();
    	Capability capa5 = new Capability();
    	Capability capa6 = new Capability();
    	Capability capa7 = new Capability();
    	Capability capa8 = new Capability();
    	Capability capa9 = new Capability();
    	Capability capa10 = new Capability();
    	capa1.setName("ceilinglight1");
    	capa1.setType(1);
    	capa2.setName("desklamp1");
    	capa2.setType(1);
    	capa3.setName("desklamp2");
    	capa3.setType(1);
    	capa4.setName("light1");
    	capa4.setValue("0");
    	capa4.setType(0);
    	capa5.setName("lamp2");
    	capa5.setValue("0");
    	capa5.setType(0);
    	capa6.setName("lamp1");
    	capa6.setValue("0");
    	capa6.setType(0);
    	capa7.setName("aircodition:temprature");
    	capa7.setType(1);
    	capa8.setName("aircodition:active");
    	capa8.setType(1);
    	capa9.setName("aircodition:turbo");
    	capa9.setType(1);
    	capa10.setName("aircodition:led");
    	capa10.setType(1);
    	room1.appendCommand(capa1);
    	room1.appendCommand(capa2);
    	room1.appendCommand(capa3);
    	room1.appendCapability(capa4);
    	room1.appendCapability(capa5);
    	room1.appendCapability(capa6);
    	room1.appendCommand(capa7);
    	room1.appendCommand(capa8);
    	room1.appendCommand(capa9);
    	room1.appendCommand(capa10);
    	
    	
    	if(read==0){
    		Intent i = new Intent(getApplicationContext(), RoomActivity.class);
    		i.putExtra("MyRoom", room1);
    		startActivity(i);
    	}else if (read==1) {
    		Intent j = new Intent(getApplicationContext(), CapabilityActivity.class);
    		j.putExtra("MyCapa", capa7);
    		startActivity(j);
    	}
    	/*IntentIntegrator integrator = new IntentIntegrator(HomeActivity.this);
    	integrator.initiateScan(IntentIntegrator.QR_CODE_TYPES);*/
        
    }
    /*
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (result != null) {
          String contents = result.getContents();
          if (contents != null) {
            Log.d("SCAN",contents);
          } else {
        	  Log.d("SCAN","FAIL");
          }
        }
      }
     */
    
}
