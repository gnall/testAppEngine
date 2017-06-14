package washo.gmd.app.client.local.page.favorite;

import org.jboss.errai.ui.shared.api.annotations.Templated;

import washo.gmd.app.client.local.page.base.Page;

@Templated
@org.jboss.errai.ui.nav.client.local.Page(path = "favorite")
public class FavoritePage extends Page 
{
    @Override
    public void onPostConstruct() 
    {
        super.onPostConstruct();

        setId("fav-page");
    }
}
