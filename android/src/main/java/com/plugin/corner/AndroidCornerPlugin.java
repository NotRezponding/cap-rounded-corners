package com.plugin.corner;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;

@CapacitorPlugin(name = "AndroidCorner")
public class AndroidCornerPlugin extends Plugin {

    @PluginMethod
    public void getCornerRadius(PluginCall call) {
        JSObject ret = new JSObject();
        
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            try {
                int cornerRadius = getActivity().getResources()
                    .getDimensionPixelSize(
                        getActivity().getResources()
                        .getIdentifier("rounded_corner_radius", "dimen", "android")
                    );
                
                ret.put("cornerRadius", cornerRadius);
                ret.put("success", true);
                call.resolve(ret);
            } catch (Exception e) {
                ret.put("cornerRadius", 0);
                ret.put("success", false);
                ret.put("error", "Could not get corner radius: " + e.getMessage());
                call.resolve(ret);
            }
        } else {
            ret.put("cornerRadius", 0);
            ret.put("success", false);
            ret.put("error", "Android version does not support corner radius detection");
            call.resolve(ret);
        }
    }
}
