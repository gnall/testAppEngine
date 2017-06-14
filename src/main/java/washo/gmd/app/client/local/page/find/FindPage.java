package washo.gmd.app.client.local.page.find;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.jboss.errai.ui.nav.client.local.TransitionTo;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.HeadElement;
import com.google.gwt.dom.client.LIElement;
import com.google.gwt.dom.client.UListElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.googlecode.gwtphonegap.client.util.PhonegapUtil;

import washo.gmd.app.client.model.Game;
import washo.gmd.app.client.local.ClientUtilities;
import washo.gmd.app.client.local.page.base.Page;
import washo.gmd.app.client.local.page.field.FieldPage;
import washo.gmd.app.client.services.GetGameService;
import washo.gmd.app.client.services.GetGameServiceAsync;

@Templated
@org.jboss.errai.ui.nav.client.local.Page(path = "find")
public class FindPage extends Page 
{
	@Inject
    @DataField
    VerticalPanel upcomingGames;
		
	@Inject TransitionTo<FieldPage> fieldClicked;
	
	private GetGameServiceAsync getGameService;
	
    @Override
    public void onPostConstruct() 
    {
        super.onPostConstruct();
        
        setId("find-page");
        
        this.getGameService = GWT.create(GetGameService.class);

		//if (this.phoneGap.isPhoneGapDevice()) 			
		//	PhonegapUtil.prepareService((ServiceDefTarget) this.getGameService, SharedConstants.SERVICES_URL, "createEvent");
        
        UListElement ul = Document.get().createULElement();
        ul.setClassName("list-unstyled gameslist");
        upcomingGames.getElement().appendChild(ul);
        
        this.getGameService.getGames(new AsyncCallback<List<Game>>()
		{
			@Override
			public void onSuccess(List<Game> result) 
			{
				for (Game game: result)
				{
			        LIElement li = Document.get().createLIElement();
			        
			        li.setInnerHTML(game.getFieldName() + " <span class=\"location\">" + game.getLocation() 
			        	+ "</span><span class=\"time\">" + game.getDateTime() + "</span><span class=\"coach\">"
			        	+ "<i class=\"material-icons\">person_outline</i>" + game.getCoachName() + "</span>");
			        
			        li.setClassName(game.getColor());
			        
			        Event.sinkEvents(li, Event.ONCLICK);
			        
			        Event.setEventListener(li, new EventListener() 
			        {
			             @Override
			             public void onBrowserEvent(Event event) 
			             {
			             	HashMap<String, String> map = new HashMap<String, String>(); 
			                map.put("fieldId", game.getId().toString());
			                Multimap<String, String> mm = Multimaps.forMap(map);
			                  
			                  fieldClicked.go(mm);
			             }
			        });
			        
			        ul.appendChild(li);
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				ClientUtilities.consoleError(caught.getMessage());
			}
		});
    }
}
