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
	//����SIM����״̬
	private String[] simState = {"״̬δ֪", "��SIM��", "��PIN����", "��PUK����",
			"��Network PIN����", "��׼����"};
	//�����ֻ�����ʽ
	private String[] phoneTypes = {"δ֪", "GSM", "CDMA"};
	
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
				//����豸�ı��
				String deviceId = tm.getDeviceId();
				//���SIM�Ĺ���
				String Country = tm.getSimCountryIso();
				//��ȡSIM�����к�
				String SimSerial = tm.getSimSerialNumber();
				//��ȡSIM��״̬
				String SimState = simState[tm.getSimState()];
				//���������Ӫ�̴���
				String networkOperator = tm.getNetworkOperator();
				//��ȡ��Ӫ������
				String networkOperatorName = tm.getNetworkOperatorName();
				//����ֻ�����ʽ
				String phoneType = phoneTypes[tm.getPhoneType()];
				
				String strSiminfo = "�豸��ţ�" + deviceId +
						"\nSIM���Ĺ���" + Country +
						"\nSIM�����кţ�" + SimSerial +
						"\nSIM��״̬��" + SimState +
						"\n������Ӫ�̴��ţ�" + networkOperator +
						"\n������Ӫ�����ƣ�" + networkOperatorName +
						"\n�ֻ�����ʽ��" + phoneType;
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