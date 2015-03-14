package com.apollo.fl140_simcardinfo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Button BtnSiminfo;
	private TextView TvSiminfo;
	
	private TelephonyManager tm;
	//定义SIM卡的状态
	private String[] simState = {"状态未知", "无SIM卡", "别PIN加锁", "被PUK加锁",
			"被Network PIN加锁", "已准备好"};
	//定义手机的制式
	private String[] phoneTypes = {"未知", "GSM", "CDMA"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
		
		tm = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
		
		findView();
		setListener();
	}

	private void setListener() {
		// TODO Auto-generated method stub
		BtnSiminfo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//获得设备的编号
				String deviceId = tm.getDeviceId();
				//获得SIM的国别
				String Country = tm.getSimCountryIso();
				//获取SIM卡序列号
				String SimSerial = tm.getSimSerialNumber();
				//获取SIM卡状态
				String SimState = simState[tm.getSimState()];
				//获得网络运营商代号
				String networkOperator = tm.getNetworkOperator();
				//获取运营商名称
				String networkOperatorName = tm.getNetworkOperatorName();
				//获得手机的制式
				String phoneType = phoneTypes[tm.getPhoneType()];
				
				String strSiminfo = "设备编号：" + deviceId +
						"\nSIM卡的国别：" + Country +
						"\nSIM卡序列号：" + SimSerial +
						"\nSIM卡状态：" + SimState +
						"\n网络运营商代号：" + networkOperator +
						"\n网络运营商名称：" + networkOperatorName +
						"\n手机的制式：" + phoneType;
				TvSiminfo.setText(strSiminfo);
			}
			
		});
	}

	private void findView() {
		// TODO Auto-generated method stub
		BtnSiminfo = (Button)findViewById(R.id.btn_siminfo);
		TvSiminfo = (TextView)findViewById(R.id.tv_siminfo);
	}
	
	
}