package com.xh;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Hook com.bolex.androidhookstartactivity 2018 2018-4-4 下午12:33:51
 * instructions： author:liuhuiliang email:825378291@qq.com
 **/

public class HostService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Log.e("HostService", "我是未注册的服务");
	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.e("HostService", "未注册服务关闭");
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Intent parcelab=intent.getParcelableExtra("originallyIntent");
		if(parcelab!=null)
			Log.e("HostService", "拿到数据了");
		return super.onStartCommand(intent, flags, startId);
	}
}
