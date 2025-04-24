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
import android.util.TypedValue;

@CapacitorPlugin(name = "RoundedCorners")
public class AndroidCornerPlugin extends Plugin {

    @PluginMethod
    public void getCornerRadius(PluginCall call) {
        JSObject ret = new JSObject();
        
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            try {
                // Get the corner radius in pixels
                int cornerRadiusPx = getActivity().getResources()
                    .getDimensionPixelSize(
                        getActivity().getResources()
                        .getIdentifier("rounded_corner_radius", "dimen", "android")
                    );
                
                // Convert pixels to DP
                float cornerRadiusDp = TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_PX,
                    cornerRadiusPx,
                    getActivity().getResources().getDisplayMetrics()
                );
                
                ret.put("cornerRadius", cornerRadiusDp);
                ret.put("cornerRadiusPx", cornerRadiusPx);
                ret.put("success", true);
                call.resolve(ret);
            } catch (Exception e) {
                ret.put("cornerRadius", 0);
                ret.put("cornerRadiusPx", 0);
                ret.put("success", false);
                ret.put("error", "Could not get corner radius: " + e.getMessage());
                call.resolve(ret);
            }
        } else {
            ret.put("cornerRadius", 0);
            ret.put("cornerRadiusPx", 0);
            ret.put("success", false);
            ret.put("error", "Android version does not support corner radius detection");
            call.resolve(ret);
        }
    }
}
