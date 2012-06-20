package hms

import org.apache.log4j.AppenderSkeleton
import org.apache.log4j.spi.LoggingEvent;

class CustomLogAppender extends AppenderSkeleton {

	@Override
	public void close() {
		if (this.closed) {
			return;
		}
		this.closed = true;
	}

	@Override
	public boolean requiresLayout() {
		return false;
	}

	@Override
	protected void append(LoggingEvent logEvent) {
		print logEvent
	}
}