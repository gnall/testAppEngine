package washo.gmd.app.client.local.firebase;

public interface HandlerRegistration {
    <R extends HandlerRegistration> R on();

    <R extends HandlerRegistration> R off();
}