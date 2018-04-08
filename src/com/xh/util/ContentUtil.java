package com.xh.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.app.Application;

/**
 * Hook com.xh.util 2018 2018-4-4 下午3:16:34 instructions： author:liuhuiliang
 * email:825378291@qq.com
 **/

public class ContentUtil {
	/**
	 * 
	 * 2018 2018-4-4 下午3:16:53 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @return Application
	 */
	public static Application getApplication2Field() {
		Application application = null;
		Class<?> activityThreadClass;
		try {
			activityThreadClass = Class.forName("android.app.ActivityThread");
			Field appField = activityThreadClass
					.getDeclaredField("mInitialApplication");
			// Object object = activityThreadClass.newInstance();
			final Method method = activityThreadClass.getMethod(
					"currentActivityThread", new Class[0]);
			// 得到当前的ActivityThread对象
			Object localObject = method.invoke(null, (Object[]) null);
			appField.setAccessible(true);
			application = (Application) appField.get(localObject);
			// appField.
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return application;
	}

	/**
	 * 
	 * 2018 2018-4-4 下午3:18:50 annotation： author：liuhuiliang email
	 * ：825378291@qq.com
	 * 
	 * @return Application
	 */
	public static Application getApplication2Method() {
		Application application = null;
		Class<?> activityThreadClass;
		try {
			activityThreadClass = Class.forName("android.app.ActivityThread");
			final Method method2 = activityThreadClass.getMethod(
					"currentActivityThread", new Class[0]);
			// 得到当前的ActivityThread对象
			Object localObject = method2.invoke(null, (Object[]) null);

			final Method method = activityThreadClass
					.getMethod("getApplication");
			application = (Application) method.invoke(localObject,
					(Object[]) null);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return application;
	}
}
