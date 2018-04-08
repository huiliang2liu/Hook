package com.xh.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

/**
 * Hook com.xh.util 2018 2018-4-4 下午3:20:17 instructions： author:liuhuiliang
 * email:825378291@qq.com
 **/

@SuppressLint("NewApi")
public class ContentManage implements ActivityLifecycleCallbacks {
	private static ContentManage manage;
	private Application mApplication;
	private Activity mActivity;

	public Activity getActivity() {
		return mActivity;
	}

	private ContentManage() {
		// TODO Auto-generated constructor stub
		mApplication = ContentUtil.getApplication2Method();
		mApplication.registerActivityLifecycleCallbacks(this);
	}

	/**
	 * 
	 * 2018 2018-4-4 下午3:25:07 annotation：在application中初始化 author：liuhuiliang
	 * email ：825378291@qq.com
	 * 
	 * @return ContentManage
	 */
	public static ContentManage init() {
		if (manage == null) {
			synchronized ("manage") {
				if (manage == null)
					manage = new ContentManage();
			}
		}
		return manage;
	}

	public static ContentManage getContentManage() {
		if (manage == null)
			throw new RuntimeException("You must initialize it in application");
		return manage;
	}

	@Override
	public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onActivityStarted(Activity activity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onActivityResumed(Activity activity) {
		// TODO Auto-generated method stub
		mActivity = activity;
	}

	@Override
	public void onActivityPaused(Activity activity) {
		// TODO Auto-generated method stub
		mActivity = null;
	}

	@Override
	public void onActivityStopped(Activity activity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onActivityDestroyed(Activity activity) {
		// TODO Auto-generated method stub

	}
}
