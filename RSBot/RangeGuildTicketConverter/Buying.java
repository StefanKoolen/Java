import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.wrappers.interactive.NPC;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

public class Buying extends Node {

	private static final int ticketID = 1464;
	public static boolean run = true;

	@Override
	public boolean activate() {
		if(run = false){
		return false;
		}
		
		return true;
	}

	@Override
	public void execute() {

		if (Inventory.getItem(ticketID).getStackSize() >= 2000) {
			NPC Merchant = NPCs.getNearest(694);
			run = false; 
			if (Merchant.isIdle() == true && Merchant != null) {
				Merchant.click(true);
				Task.sleep(Random.nextInt(300, 700));
				WidgetChild runeArrow = Widgets.get(278, 16).getChild(2);

				do{
					if(Inventory.getItem(ticketID).getStackSize() >= 2000){					
						runeArrow.interact("Buy");
						Task.sleep(Random.nextInt(1000, 2000));
					}else {
						System.out.println("Converted all your tickets into rune arrows!");
						
					}
				} while (Inventory.getItem(ticketID).getStackSize() >= 2000);
			}

		} else {
			System.out.println("Not enough tickets to buy arrows.");
		}
	}
}
