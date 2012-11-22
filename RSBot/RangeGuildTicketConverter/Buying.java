import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.input.Keyboard;


public class Buying extends Node {

	@Override
	public boolean activate() {
				
		return true;
	}

	@Override
	public void execute() {
		
		
		Keyboard.sendText("Test", true);
		

	}

}
