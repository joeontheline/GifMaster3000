package logic;

import java.util.concurrent.TimeUnit;

public class ConCalcs {
	public static String millisToHMS(long millis) {
//		Alert.consoleLog(millis);
		String hms = String.format("%02d:%02d:%02d.%02d", TimeUnit.MILLISECONDS.toHours(millis),
				TimeUnit.MILLISECONDS.toMinutes(millis) % TimeUnit.HOURS.toMinutes(1),
				TimeUnit.MILLISECONDS.toSeconds(millis) % TimeUnit.MINUTES.toSeconds(1),
				TimeUnit.MILLISECONDS.toMillis(millis) % TimeUnit.SECONDS.toMillis(1));
//		Alert.consoleLog(hms);
		return hms;
	}

	protected static long hmsToMillis(String hms) {
		long r = 0;

		r += Long.valueOf(Long.parseLong(hms.substring(3, 5)) * 60000);
		r += Long.valueOf(Long.parseLong(hms.substring(6, 8)) * 1000);
		r += Long.valueOf(Long.parseLong(hms.substring(9, 11)) * 10);

		// Alert.consoleLog("string in: " + hms + " long out: " + r);

		return r;
	}
}
