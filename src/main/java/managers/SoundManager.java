package alphaitems.managers;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class SoundManager {
	@ForgeSubscribe
	public void onSound(SoundLoadEvent event) {
		// Crawler
		this.addSound(event, "crawler/say1.ogg");
		this.addSound(event, "crawler/say2.ogg");
		this.addSound(event, "crawler/say3.ogg");
		this.addSound(event, "crawler/hurt1.ogg");
		this.addSound(event, "crawler/hurt2.ogg");
		this.addSound(event, "crawler/heartbeat.ogg");
		this.addSound(event, "crawler/scarysound.ogg");
		this.addSound(event, "crawler/horror.ogg");
		
		// Duck
		this.addSound(event, "duck/say1.ogg");
		this.addSound(event, "duck/say2.ogg");
		this.addSound(event, "duck/say3.ogg");
		this.addSound(event, "duck/say4.ogg");
		this.addSound(event, "duck/hurt1.ogg");
		this.addSound(event, "duck/hurt2.ogg");
		this.addSound(event, "duck/die.ogg");
		
		// Mummy
		this.addSound(event, "mummy/say1.ogg");
		this.addSound(event, "mummy/say2.ogg");
		this.addSound(event, "mummy/say3.ogg");
		this.addSound(event, "mummy/say4.ogg");
		this.addSound(event, "mummy/hurt.ogg");
		this.addSound(event, "mummy/die.ogg");
	}
	
	public void addSound(SoundLoadEvent event, String sound) {
		sound = "awei:" + sound;
		event.manager.addSound(sound);
	}
}