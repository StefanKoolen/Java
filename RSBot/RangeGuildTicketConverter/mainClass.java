import org.powerbot.core.script.ActiveScript;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.core.script.job.state.Tree;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.util.Random;

@Manifest(authors = { "NaStezZ" }, name = "RangeGuildTicketConverter")
public class mainClass extends ActiveScript {

	private Tree jobs = null;

	@Override
	public int loop() {
		if (jobs == null) {
			jobs = new Tree(new Node[] { new Buying() });
		}
		final Node job = jobs.state();
		if (job != null) {
			jobs.set(job);
			getContainer().submit(job);
			job.join();
			return 100;
		}
		return Random.nextInt(200, 5000);
	}

}
