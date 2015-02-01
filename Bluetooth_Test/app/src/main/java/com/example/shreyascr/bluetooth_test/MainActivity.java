package com.example.shreyascr.bluetooth_test;

import java.util.Set;
import android.support.v7.app.ActionBarActivity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;
import android.content.Context;

public class MainActivity extends ActionBarActivity {

    ArrayAdapter<String> listAdapter;
	Button connectNew;
	ListView listView;
	BluetoothAdapter btAdapter;
	Set<BluetoothDevice> devicesArray;
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
			if (!btAdapter.isEnabled()){
				Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
				startActivityforResult(intent, 1);
			}
			getPairedDevices();
		}
	}

    private void startActivityforResult(Intent i, int num){

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
		listView=(ListView)findViewById(R.id.listView);
		listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,0);
		listView.setAdapter(listAdapter);
		btAdapter = BluetoothAdapter.getDefaultAdapter();
		pairedDevices = new ArrayList<String>();
		filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
		receiver = new BroadcastReceiver(){
			@Override
			public void onReceive (Context context, Intent intent){
				String action = intent.getAction();
				
				if (BluetoothDevice.ACTION_FOUND.equals(action)){
					BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
					listAdapter.add(device.getName() + "\n" + device.getAddress());
				}
			}
		};
		registerReceiver(receiver, filter);
		filter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
		registerReceiver(receiver, filter);
		filter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
		registerReceiver(receiver, filter);
		filter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
		registerReceiver(receiver, filter);
	}
	
	protected void onActivityResult (int requestCode, int resultCode, Intent data){
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_CANCELED){
			Toast.makeText(getApplicationContext(), "Bluetooth must be enabled to continue");
			finish();
		}
	}		
}