
package vista;


import java.applet.AudioClip;
import java.net.URL;


public class Audio{
	

	private AudioClip unClip;
	
	
	public Audio(String archivo){
		
		
        URL direccion = getClass().getClassLoader().getResource("util/"+ archivo);
        
		unClip = java.applet.Applet.newAudioClip( direccion );
	    
	    
	}
	
	
	public void play(boolean loopear){
		
		if(!loopear){
			
			unClip.play();
			
		} else{
			
			unClip.stop();	
		}
		
	}
	
	
	public void stop(){
		
		unClip.stop();
		
	}
}
