package com.mycompany.myapp;


import java.io.IOException;

import com.codename1.location.Location;
import com.codename1.location.LocationManager;
import com.codename1.ui.Button;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.util.EventDispatcher;

import userclasses.StateMachine;

public class MyApplication {
   
    private static final LocationManager LM = null;
	private Form current;
	private Location location;
	private static final EventDispatcher ED = null;
    public void init(Object context) {
    }

    public void start() throws IOException {
        if(current != null){
            current.show();
            return;
        }
        
        new StateMachine("/theme");
        Button loginbtn = new Button();
        loginbtn.addActionListener(l);
        ED.addListener(loginbtn.l)
        
    }
    public Location LocationGetter() {
    	if (LM.getStatus()==1||LM.getStatus()==0) {
            location = LM.getLastKnownLocation();	
            } else
    			location = LM.getCurrentLocationSync();
    	return location;
    }
    

    public void stop() {
        current = Display.getInstance().getCurrent();
    }
    
    public void destroy() {
    }
}
