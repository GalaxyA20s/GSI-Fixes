package com.tbm13.a20sfingerprintfix;

import android.content.Context;
import android.util.Log;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class MainHook implements IXposedHookLoadPackage {
    private static final String TAG = "FingerprintFix";

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam)  {
        if (!"android".equals(lpparam.packageName)) {
            return;
        }

        Class<?> authServiceClass = XposedHelpers.findClass(
                "com.android.server.biometrics.AuthService",
                lpparam.classLoader
        );

        Log.d(TAG, "Hooking on package " + lpparam.packageName);
        XposedHelpers.findAndHookMethod(
                authServiceClass,
                "registerFingerprintSensors",
                String[].class,
                String[].class,
                Context.class,
                "android.hardware.fingerprint.IFingerprintService",
                "com.android.server.biometrics.BiometricHandlerProvider",
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) {
                        Log.d(TAG, "registerFingerprintSensors()");
                        param.args[0] = new String[] { };
                        param.args[1] = new String[] { "0:2:15" };
                    }
                }
        );
    }
}