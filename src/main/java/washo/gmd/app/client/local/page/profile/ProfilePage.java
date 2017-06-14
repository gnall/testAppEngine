package washo.gmd.app.client.local.page.profile;

import org.jboss.errai.ui.shared.api.annotations.Templated;

import washo.gmd.app.client.local.page.base.Page;

@Templated
@org.jboss.errai.ui.nav.client.local.Page(path = "profile")
public class ProfilePage extends Page 
{     	 
	@Override
    public void onPostConstruct() 
    {
        super.onPostConstruct();

        setId("profile-page");
    }
}