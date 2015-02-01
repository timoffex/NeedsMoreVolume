package com.example.shreyascr.bluetooth_test;

import java.util.Set;
import android.support.v7.app.ActionBarActivity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.button;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    ArrayAdapter<String> listAdapter;
	Button connectNew;
	ListView listView;
	BluetoothAdapter btAdapter;
	Set<BluetoothDevices> devicesArray;
	ArrayList<String> pairedDevices;
	IntentFilter filter;
	BroadcastReceiver receiver;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		init();
		if (btAdapter == null){
			Toast.makeText(getApplicationContext(), "No bluetooth detecte", 0).show();
			finish();
		}
		else{
			if (!bt.Adapter.isEnabled()){
				Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
				startActivityforResult(intent, 1);
			}
			getPairedDevices();
		}
	}
	
	private void getPairedDevices(){
		devicesArray = btAdapter.getBondedDevices();
		if(devicesArray.size() > 0){
			for(BluetoothDevice device:devicesArray){
				pairedDevices.add(device.getName());
			}
		}
	}

	private void init(){
		connectNew=(Button)findViewById(R.id.bConnectNew);
		listView=(ListView)findViewById(R.id.ListView);
		listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,0);
		listView.setAdapter(listAdapter);
		btAdapter = BluetoothAdapter.getDefaultAdapter();
		pairedDevices = new ArrayList<String>();
		filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
		receive = new BroadcastReceiver(){
			@Override
			public void onReceive (Context context, Intent intent){
				String action = intent.getAction();
				
				if (BluetoothDevice.ACTION_FOUND.equals(action)){
					BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVIC);
					listAdapter.add(device.getName() + "\n" + device.getAddress());
				}
			}
		};
		registerReceiver(receiver, filter);
		IntentFilter filter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
		registerReceiver(receiver, filter);
		IntentFilter filter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
		registerReceiver(receiver, filter);
		IntentFilter filter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
		registerReceiver(receiver, filter);
	}
	
	protected void onActivityResult (int requestCode, int resultCode, Intent data){
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_CANCLED){
			Toast.makeText(getAplicationContext(), "Bluetooth must be enabled to continue");
			finsh();
		}
	}		
}