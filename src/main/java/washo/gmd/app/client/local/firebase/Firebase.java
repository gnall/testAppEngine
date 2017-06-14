package washo.gmd.app.client.local.firebase;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;
import washo.gmd.app.client.local.firebase.auth.Auth;

@JsType(isNative = true, namespace = "firebase.app", name = "App")
public class Firebase {

    @JsMethod(namespace = "firebase")
    public static native Firebase initializeApp(Config config);

    public native Auth auth();

    //public native Database database();
}