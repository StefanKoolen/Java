import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.input.Keyboard;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.interactive.NPC;


public class Buying extends Node {
	
	private static final int ticketID = 1464;
	
	@Override
	public boolean activate() {
				
		return true;
	}

	@Override
	public void execute() {
		
		if(Inventory.getItem(ticketID).getStackSize() >= 1020){		
		NPC Merchant = NPCs.getNearest(694);
			if(Merchant.isIdle() == true){
				Merchant.click(true);
			}
		
		}
		else Keyboard.sendText("Minder dan 1020", true);

	}

}
