package washo.gmd.app.client.local.firebase.auth;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = "firebase.auth", name = "AuthCredential")
public class AuthCredential 
{
    @JsProperty
    public native String getProvider();

    @JsProperty
    public native void setProvider(String provider);
}