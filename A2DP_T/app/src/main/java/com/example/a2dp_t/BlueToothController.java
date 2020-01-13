package com.example.a2dp_t;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;

/**
 * Created by 小新 on 2016/6/11.
 */
public class BlueToothController {
    //蓝牙适配器
    private BluetoothAdapter mAdapter;
    public BlueToothController() {
        //获取手机的蓝牙适配器，如果不为空手机支持蓝牙，为空不支持蓝牙
        mAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    /**
     * 是否支持蓝牙
     * @return true 支持, false 不支持
     */
    public boolean isSupportBlueTooth() {
        if( mAdapter != null ){
            return true;
        }
        else {
            return false;
        }
    }
    /**
     * 判断当前蓝牙状态
     * @return true 打开,false 关闭
     */
    public boolean getBlueToothStatus() {
        //assert断言：只有为true才会执行下去
        assert (mAdapter != null);
        return mAdapter.isEnabled();
    }
    /**
     * 打开蓝牙
     * @param activity
     * @param requestCode
     */
//    我们一般打开蓝牙会使用到系统提供的一个Activity。这个Activity的action为：
//      BluetoothAdapter.ACTION_REQUEST_ENABLE。
//    然后我们要使用startActivityForResult()这个方法来启动它。
//    这个Activity是有返回值的，如果用户选择的是打开，我们应该可以收到一个RESULT_OK
//    如果用户选择的是取消，我们应该可以收到一个RESULT_CANCELED。
    public void turnOnBlueTooth(Activity activity, int requestCode) {
        Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        activity.startActivityForResult(intent, requestCode);
//        mAdapter.enable();
    }

    /**
     * 关闭蓝牙
     */
    public void turnOffBlueTooth() {
        mAdapter.disable();
    }
}
