package washo.gmd.app.client.local.page.main;

import javax.inject.Inject;

import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.user.client.ui.Anchor;

import washo.gmd.app.client.local.page.base.Page;

@Templated
@org.jboss.errai.ui.nav.client.local.Page(path = "main", role = DefaultPage.class)
public class MainPage extends Page 
{
	@Inject
    @DataField
    Anchor find, profile, field, favorite;
	
    @Override
    public void onPostConstruct() 
    {
        super.onPostConstruct();

        setId("main-page");
    }
}