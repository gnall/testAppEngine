package washo.gmd.app.client.local.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface AppClientBundle extends ClientBundle 
{
    AppClientBundle INSTANCE = GWT.create(AppClientBundle.class);

    @Source("css/app.css")
    TextResource appCss();
}