package at.htlleonding.diegaertner.cc2023;

import at.htlleonding.diegaertner.cc2023.levels.Level1;
import at.htlleonding.diegaertner.cc2023.levels.Level2;
import at.htlleonding.diegaertner.cc2023.util.FileUtils;

public class Main {
	public static void main(String[] args) {
		boolean debug = args.length > 0 && args[0].equals("debug");

		Level level2 = new Level2(debug);
		level2.solve();
	}
}
