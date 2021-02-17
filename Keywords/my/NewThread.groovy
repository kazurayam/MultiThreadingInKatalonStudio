package my

import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class NewThread extends Thread{
	static Logger logger = Logger.getLogger("my.NewThread");
	static FileHandler fh;
	static {
		fh = new FileHandler("./mylog.txt");
		logger.addHandler(fh);
		SimpleFormatter formatter = new SimpleFormatter();
		fh.setFormatter(formatter);
		// remove console output
		logger.setUseParentHandlers(false);
	}
	public void run() {
		long startTime = System.currentTimeMillis();
		int i = 0;
		while (i < 10) {
			logger.info("${this.getName()}: New Thread is running... ${i}")
			try {
				// Wait for 0.1 second so it doesn't print too fast
				Thread.sleep(100);
			} catch (Exception e) {
				logger.info("run() was interrupted at i=${i}")
				e.printStackTrace()
			}
			i += 1
		}
		logger.info("${this.getName()}: run() finished with i=${i}")
	}
}
