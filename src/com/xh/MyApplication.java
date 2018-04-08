package com.xh;

import java.lang.Thread.UncaughtExceptionHandler;

import android.app.Application;
import android.os.Process;

import com.xh.hook.AMSHook;

/**
 * Hook com.bolex.androidhookstartactivity 2018 2018-4-3 下午6:55:50 instructions：
 * author:liuhuiliang email:825378291@qq.com
 **/

public class MyApplication extends Application implements
		UncaughtExceptionHandler {
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		// AMSHookUtil.hookStartActivity(this);

		super.onCreate();
		Thread.setDefaultUncaughtExceptionHandler(this);
		new AMSHook();
	}

	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		// TODO Auto-generated method stub
		ex.printStackTrace();
		System.exit(0);
		Process.killProcess(Process.myPid());
	}
}
