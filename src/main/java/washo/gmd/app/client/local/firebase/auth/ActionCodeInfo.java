package washo.gmd.app.client.local.firebase.auth;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = "firebase.auth", name = "ActionCodeInfo")
public interface ActionCodeInfo {

    @JsProperty
    ActionCodeInfoData getData();

    @JsProperty
    void setData(ActionCodeInfoData data);
}