package washo.gmd.app.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import washo.gmd.app.client.model.Game;

@RemoteServiceRelativePath("getGame")
public interface GetGameService extends RemoteService {
	List<Game> getGames();
}