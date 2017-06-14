package washo.gmd.app.client.local;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.gwtphonegap.client.PhoneGap;
import com.googlecode.gwtphonegap.client.PhoneGapAvailableEvent;
import com.googlecode.gwtphonegap.client.PhoneGapAvailableHandler;
import com.googlecode.gwtphonegap.client.PhoneGapTimeoutEvent;
import com.googlecode.gwtphonegap.client.PhoneGapTimeoutHandler;
import com.googlecode.gwtphonegap.client.splashscreen.SplashScreen;

import washo.gmd.app.client.local.page.base.HasNavigation;
import washo.gmd.app.client.local.events.NavigationEvent;
import washo.gmd.app.client.local.firebase.Config;
import washo.gmd.app.client.local.firebase.Firebase;
import washo.gmd.app.client.local.firebase.Fn;
import washo.gmd.app.client.local.firebase.Fn.Arg;
import washo.gmd.app.client.local.firebase.Promise;
import washo.gmd.app.client.local.firebase.auth.Auth;
import washo.gmd.app.client.local.firebase.auth.FacebookAuthProvider;
import washo.gmd.app.client.local.firebase.auth.User;
import washo.gmd.app.client.local.firebase.auth.UserCredential;
import washo.gmd.app.client.local.resources.AppClientBundle;
import washo.gmd.app.client.local.widget.Main;
import org.jboss.errai.ioc.client.api.EntryPoint;
import org.jboss.errai.ui.nav.client.local.Navigation;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@EntryPoint
public class Client extends Composite
{
    @Inject
    Navigation navigation;

    @Inject
    Main content;
    
    PhoneGap phoneGap;

    @PostConstruct
    public void init() 
    {
    	ClientUtilities.consoleLog("app init()");
    	
		this.phoneGap = GWT.create(PhoneGap.class);
		
		this.phoneGap.addHandler(new PhoneGapAvailableHandler() 
		{
	        @Override
	        public void onPhoneGapAvailable(PhoneGapAvailableEvent event) 
	        {
	        	try
	        	{
	        		ClientUtilities.consoleLog("phone gap ready!! is device?: " + phoneGap.isPhoneGapDevice());
	        		
		        	//http://stackoverflow.com/questions/20339647/phonegap-build-ios-app-has-blank-white-screen-after-splash-screen
		        	final SplashScreen ss = GWT.create(SplashScreen.class);
		        	
		        	//FileOpener fop = (FileOpener) GWT.create(FileOpener.class); 
		        	//fop.initialize(); 
		        	//phoneGap.loadPlugin("fileOpener", fop);
		        	
		        	startApplication();
					
					ss.hide();
	        	}
	        	catch (Exception e)
	        	{
	        		Window.alert(e.getMessage());
	        	}
	        }
		});

		this.phoneGap.addHandler(new PhoneGapTimeoutHandler()
		{
	        @Override
	        public void onPhoneGapTimeout(PhoneGapTimeoutEvent event) {
	        	ClientUtilities.consoleError("PhoneGap Timeout Error");
	        }
		});
		
		this.phoneGap.initializePhoneGap();
    }
    
    private void startApplication()
    {    	
//    	Config config = new Config();
//    	config.setApiKey("AIzaSyBHw638MUKXjZIUTZO_146nxtYpmwDhWpY");
//    	config.setAuthDomain("sho-sandbox-flex.firebaseapp.com");
//    	config.setDatabaseURL("https://sho-sandbox-flex.firebaseio.com");
//    	//projectId: "sho-sandbox-flex",
//    	//messagingSenderId: "914301343729"
//    	
//    	config.setStorageBucket("sho-sandbox-flex.appspot.com");
//    	Firebase firebase = Firebase.initializeApp(config);
//    	
//    	Auth auth = firebase.auth();
//    	
//    	FacebookAuthProvider fap = new FacebookAuthProvider();
//    	
//    	Promise<Void, Error> promise = auth.signInWithRedirect(fap);
//    	
//    	promise.then(new Arg<Void>()
//    	{
//			@Override
//			public void e(Void arg) 
//			{
//				GWT.log("signInWithRedirect promise");
//				
//				Promise<UserCredential, Error> promise2 = auth.getRedirectResult();
//				
//				promise2.then(new Arg<UserCredential>()
//				{
//					@Override
//					public void e(UserCredential arg) {
//						GWT.log("getRedirectResult promise");
//						
//						GWT.log(arg.getUser().getEmail());
//						
//					}
//					
//				});
//				
//			}
//    	});
//    	
////    	Promise<User, Error> promise = auth.createUserWithEmailAndPassword("jason.washo+test5@gmail.com", "Testing@123");
////    	 
////    	promise.then(new Arg<User>()
////    	{
////			@Override
////			public void e(User arg) {
////				GWT.log("arg.getUid(): " + arg.getUid());
////			}
////	
////		});
////    	
//    	promise.katch(new Arg<Error>()
//    	{
//			@Override
//			public void e(Error arg) {
//				GWT.log(arg.getMessage());
//			}
//	
//		});

      	
    	
        StyleInjector.inject(AppClientBundle.INSTANCE.appCss().getText());
        
        this.content.getContainer().add(this.navigation.getContentPanel());

        
        
        RootPanel.get().add(this.content);
    }

    public void onNavigation(@Observes NavigationEvent event) 
    {
        RootPanel.get().getElement().setId(event.getPage().getId());
        if (event.getPage() instanceof HasNavigation) {
            //header.setVisible(true);
            //sideNav.setVisible(true);
            //$("main").css("marginLeft", "280px");
        } else {
            //$("main").css("marginLeft", "0px");
            //header.setVisible(false);
            //sideNav.setVisible(false);
        }
    }
}
