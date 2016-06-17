package com.example.wifiinfo;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.net.wifi.*;
public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button bt1=(Button)findViewById(R.id.button1);
		Button bt2=(Button)findViewById(R.id.button2);
		Button bt3=(Button)findViewById(R.id.button3);
		View.OnClickListener reload=new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TextView txt=(TextView)findViewById(R.id.textView1);
				try{
				WifiManager Manager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
				WifiInfo wifiinfo=Manager.getConnectionInfo();
				txt.setText("");
				txt.append("Wifi AP Info:"+"\r\n");
				txt.append("Wifi SSID: "+wifiinfo.getSSID().toString()+"\r\n");
				txt.append("Wifi BSSID: "+wifiinfo.getBSSID().toUpperCase().toString()+"\r\n");
				txt.append("Wifi MAC: "+wifiinfo.getMacAddress().toUpperCase().toString()+"\r\n");
				txt.append("Wifi RSSID: "+wifiinfo.getRssi()+"\r\n");
				txt.append("Wifi LINK SPEED: "+wifiinfo.getLinkSpeed()+" Mbps");
				}
				catch(Exception e){
				txt.setText("");
				txt.append("Not Connect Wifi......");
			    }
			}
		};
		View.OnClickListener clear=new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TextView txt=(TextView)findViewById(R.id.textView1);
				txt.setText("Developer By HackEr9A"+"\r\n"+"Twitter:https://twitter.com/HuangKtpss96034"+"\r\n"+"Github:https://github.com/andrew98450"+"\r\n"+"Version 1.0");
			}
		};
		View.OnClickListener exit=new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		};
		bt1.setOnClickListener(reload);
		bt2.setOnClickListener(clear);
		bt3.setOnClickListener(exit);
	}
}
