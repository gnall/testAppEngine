package washo.gmd.app.client.local.firebase;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@SuppressWarnings("rawtypes")
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class Thenable<S, E> {

    public native <T extends Thenable> T then(Fn.Arg<S> onResolve, Fn.Arg<E> onReject);

	public native <T extends Thenable> T then(Fn.NoArg onResolve, Fn.Arg<E> onReject);

    public native <T extends Thenable> T then(Fn.Arg<S> onResolve);

    public native <T extends Thenable> T then(Fn.NoArg onResolve);

    public native <R, T extends Thenable> T then(Fn.ArgRet<S, R> onResolve);

    public native <R, T extends Thenable> T then(Fn.ArgRet<S, R> onResolve, Fn.Arg<E> onReject);

    public native <R, T extends Thenable> T then(Fn.ArgRet<S, R> onResolve, Fn.ArgRet<E, E> onReject);

    @JsMethod(name = "catch")
    public native <T extends Thenable> T katch(Fn.Arg<E> onReject);

    @JsMethod(name = "catch")
    public native <T extends Thenable> T katch(Fn.ArgRet<E, E> onReject);
}