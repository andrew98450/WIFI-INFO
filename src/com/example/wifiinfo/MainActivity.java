package com.example.wifiinfo;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.*;
import android.widget.*;
import android.net.*;
import android.net.wifi.*;
public class MainActivity extends Activity {
	Handler h;
	Runnable run=new Runnable(){
		public void run(){
			EditText ed1=(EditText)findViewById(R.id.editText1);
			TextView txt1=(TextView)findViewById(R.id.textView1);
			WifiManager Manager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
			WifiInfo wifiinfo=Manager.getConnectionInfo();
			DhcpInfo dhcpinfo=Manager.getDhcpInfo();
			txt1.setText("");
			txt1.append("WIFI AP INFO:"+"\r\n");
			if(Manager.isWifiEnabled()){
			    txt1.append("Wifi Device is Enabled"+"\r\n");
			}else{
				txt1.append("Wifi Device is Disabled"+"\r\n");
			}
			try{
			    txt1.append("SSID: "+wifiinfo.getSSID().toString()+"\r\n");
			    txt1.append("BSSID: "+wifiinfo.getBSSID().toUpperCase().toString()+"\r\n");
			    txt1.append("RSSID: "+wifiinfo.getRssi()+"\r\n");
			    txt1.append("WIFI LOCAL MAC : "+wifiinfo.getMacAddress().toUpperCase().toString()+"\r\n");
			    txt1.append("WIFI LINK SPEED: "+wifiinfo.getLinkSpeed()+" Mbps"+"\r\n");
            if(wifiinfo.getHiddenSSID()){
            	txt1.append("SSID is Hidden"+"\r\n");
            }else{
            	txt1.append("SSID is No Hidden"+"\r\n");
            }
                txt1.append("DHCP INFO:"+"\r\n");
			    txt1.append(dhcpinfo.toString()+"\r\n");
			    txt1.append("SCAN FOUND WIFI:"+"\r\n");
			for(int i=0;i<Manager.getScanResults().size();i++){
				txt1.append("SSID: "+Manager.getScanResults().get(i).SSID.toString()+" BSSID: "+Manager.getScanResults().get(i).BSSID.toUpperCase().toString()+" RSSID: "+Manager.getScanResults().get(i).level+" "+Manager.getScanResults().get(i).capabilities+"\r\n");
			}
			}catch(Exception e){
				txt1.append("Please Enabled Wifi Device.....");
			}
			h.postDelayed(this, Integer.parseInt(ed1.getText().toString()));
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Button bt1=(Button)findViewById(R.id.button1);
		Button bt2=(Button)findViewById(R.id.button2);
		Button bt3=(Button)findViewById(R.id.button3);
		View.OnClickListener reload=new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				CheckBox ch1=(CheckBox)findViewById(R.id.checkBox1);
				EditText ed1=(EditText)findViewById(R.id.editText1);
				if(ch1.isChecked()){
					h=new Handler();
					bt1.setText("UnAuto");
					h.postDelayed(run,Integer.parseInt(ed1.getText().toString()));
				}else{
			    try{
			    	bt1.setText("Reload");
			    	h.removeCallbacks(run);
			    }catch(Exception e){}
	              	TextView txt1=(TextView)findViewById(R.id.textView1);
				    WifiManager Manager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
				    WifiInfo wifiinfo=Manager.getConnectionInfo();
				    DhcpInfo dhcpinfo=Manager.getDhcpInfo();
				    txt1.setText("");
				    txt1.append("WIFI AP INFO:"+"\r\n");
				if(Manager.isWifiEnabled()){
				    txt1.append("Wifi Device is Enabled"+"\r\n");
				}else{
					txt1.append("Wifi Device is Disabled"+"\r\n");
				}
				try{
				    txt1.append("SSID: "+wifiinfo.getSSID().toString()+"\r\n");
				    txt1.append("BSSID: "+wifiinfo.getBSSID().toUpperCase().toString()+"\r\n");
				    txt1.append("RSSID: "+wifiinfo.getRssi()+"\r\n");
				    txt1.append("WIFI LOCAL MAC : "+wifiinfo.getMacAddress().toUpperCase().toString()+"\r\n");
				    txt1.append("WIFI LINK SPEED: "+wifiinfo.getLinkSpeed()+" Mbps"+"\r\n");
                if(wifiinfo.getHiddenSSID()){
                	txt1.append("SSID is Hidden"+"\r\n");
                }else{
                	txt1.append("SSID is No Hidden"+"\r\n");
                }
                    txt1.append("DHCP INFO:"+"\r\n");
				    txt1.append(dhcpinfo.toString()+"\r\n");
				    txt1.append("SCAN FOUND WIFI:"+"\r\n");
				for(int i=0;i<Manager.getScanResults().size();i++){
					txt1.append("SSID: "+Manager.getScanResults().get(i).SSID.toString()+" BSSID: "+Manager.getScanResults().get(i).BSSID.toUpperCase().toString()+" RSSID: "+Manager.getScanResults().get(i).level+" "+Manager.getScanResults().get(i).capabilities+"\r\n");
				}
				}catch(Exception e){
					txt1.append("Please Enabled Wifi Device.....");
			    }
			  }
		    }
		};
		View.OnClickListener clear=new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TextView txt=(TextView)findViewById(R.id.textView1);
				txt.setText("Developer By HackEr9A"+"\r\n"+"Twitter:https://twitter.com/HuangKtpss96034"+"\r\n"+"Github:https://github.com/andrew98450"+"\r\n"+"Copyright (C) 2016"+"\r\n"+"Version 2.0");
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
