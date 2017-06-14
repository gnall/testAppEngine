package washo.gmd.app.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import washo.gmd.app.client.model.Game;

public interface GetGameServiceAsync {
	void getGames(AsyncCallback<List<Game>> callback);
}