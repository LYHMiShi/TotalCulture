package culture.totalculture.utils;


import android.widget.Toast;

import culture.totalculture.app.App;

public class ToastUtils {

    public static void toa(String msg){
        Toast.makeText(App.context, msg, Toast.LENGTH_SHORT).show();
    }
}
