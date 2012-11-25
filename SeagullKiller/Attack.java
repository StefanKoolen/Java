import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.wrappers.interactive.NPC;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

public class Attack extends Node {

	private final static int seaGullID[] = { 6115, 6116 };

	@Override
	public boolean activate() {
		return true;
	}

	@Override
	public void execute() {

		if (Players.getLocal().isInCombat() == false) {
			NPC seaGull = NPCs.getNearest(seaGullID);
			seaGull.interact("Attack");
		} else {
			WidgetChild piercingShot = Widgets.get(640).getChild(32);
			WidgetChild snapShot = Widgets.get(640).getChild(37);
			WidgetChild snipe = Widgets.get(640).getChild(43);
			int randomCase = Random.nextInt(1, 5);

			switch (randomCase) {

			case 1:
				if (randomCase == 1) {
					piercingShot.click(true);
					Task.sleep(Random.nextInt(700, 1200));
				}
			case 2:
				Task.sleep(Random.nextInt(1500, 2500));
			case 3:
				if (randomCase == 3) {
					snapShot.click(true);
					Task.sleep(Random.nextInt(3200, 3700));
				}
			case 4:
				Task.sleep(Random.nextInt(500, 1000));
			case 5:
				if (randomCase == 5) {
					snipe.click(true);
					Task.sleep(Random.nextInt(2500, 3000));
				}

			}
		}
	}
}
