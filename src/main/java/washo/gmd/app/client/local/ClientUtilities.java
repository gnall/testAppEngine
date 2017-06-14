package washo.gmd.app.client.local;

public class ClientUtilities 
{
	public native static void consoleLog(String message) /*-{
		console.log(message);
	}-*/;

	public native static void consoleError(String message) /*-{
		console.error(message);
	}-*/;
}