package log4JExamples;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class FileAppenderExample {

	static Logger logger = Logger.getLogger(FileAppenderExample.class);

	public static void main(String[] args) {

		// BasicConfigurator.configure();
		// PropertyConfigurator.configure("log4JConsoleAppender.properties");
		// PropertyConfigurator.configure("log4jFileAppender.properties");
		// PropertyConfigurator.configure("log4JFileAndConsoleAppender.properties");
		DOMConfigurator.configure("log4JAppender.xml");
		logger.debug("This is debug log Message");
		logger.info("This is info Log Message");
		logger.warn("This is Warn log Message");
		logger.error("This is erro log Message");
		logger.fatal("This is fatal log Message");

	}

}
