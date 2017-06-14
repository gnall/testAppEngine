package washo.gmd.app.server;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import washo.gmd.app.client.model.Game;
import washo.gmd.app.client.services.GetGameService;

public class GameServiceImpl extends RemoteServiceServlet implements GetGameService 
{
	private static final long serialVersionUID = -1805383559935107006L;

	private static final Logger log = Logger.getLogger(GameServiceImpl.class.getName());
	
	@Override
	public List<Game> getGames() {

		List<Game> gameList = new ArrayList<Game>();
		
		Game game1 = new Game(1, "Weston Field", "Scranton, PA", "Today 3:00pm", "B. Reid", "color-secondary-2-0-bg");
		Game game2 = new Game(2, "Fitzpatrick Field", "Scranton, PA", "July 15 4:15pm", "C. Wileage", "color-complement-1-bg");
		Game game3 = new Game(3, "South Side Complex", "Scranton, PA", "July 17 4:15pm", "J. Washo", "color-secondary-1-2-bg");
		
		
		gameList.add(game1);
		gameList.add(game2);
		gameList.add(game3);
		
		return gameList;	
	}

}
