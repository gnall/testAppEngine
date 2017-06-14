package washo.gmd.app.client.local.page.field;

import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.errai.ui.nav.client.local.PageState;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.dom.client.SpanElement;

import washo.gmd.app.client.local.ClientUtilities;
import washo.gmd.app.client.local.page.base.Page;

@Templated
@org.jboss.errai.ui.nav.client.local.Page(path = "field/{fieldId}")
public class FieldPage extends Page 
{
	@PageState
	private int fieldId;
	
	//@Inject @DataField @Named("h1") HeadingElement fieldName;
	//@Inject @DataField SpanElement location, capacity, coach;
	
    @Override
    public void onPostConstruct() 
    {
        super.onPostConstruct();
        
        setId("field-page");
    }
    
    @Override
    public void onPageShown()
    {
    	super.onPageShown();
    	
    //	capacity.setInnerText("17 / 41 attending");
    	//coach.setInnerText("J. Washo");
    //	fieldName.setInnerText("PooP");
    //	location.setInnerText("123 Main St, Scranton, PA 18503");

    	ClientUtilities.consoleLog("fieldId: " + fieldId);
    }
}
