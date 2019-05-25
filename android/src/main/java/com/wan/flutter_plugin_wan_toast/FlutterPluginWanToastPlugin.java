package com.wan.flutter_plugin_wan_toast;

import android.content.Context;
import android.widget.Toast;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/**
 * FlutterPluginWanToastPlugin
 */
public class FlutterPluginWanToastPlugin implements MethodCallHandler {

    private Context mContext;

    public FlutterPluginWanToastPlugin(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * Plugin registration.
     */
    public static void registerWith(Registrar registrar) {
        final MethodChannel channel = new MethodChannel(registrar.messenger(), "flutter_plugin_wan_toast");
        channel.setMethodCallHandler(new FlutterPluginWanToastPlugin(registrar.context()));
    }

    @Override
    public void onMethodCall(MethodCall call, Result result) {
        if (call.method.equals("getPlatformVersion")) {
            result.success("Android " + android.os.Build.VERSION.RELEASE);
        } else if (call.method.equals("toast")) {
            String text = call.argument("text");
            Toast.makeText(mContext, text, Toast.LENGTH_SHORT).show();
        } else {
            result.notImplemented();
        }
    }
}
