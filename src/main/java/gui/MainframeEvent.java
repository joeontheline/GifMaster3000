package gui;

public class MainframeEvent {
		private String type = null;
		public static enum EventType {
			REPAINT
		}

		public MainframeEvent(EventType type) {
			this.type = type.toString();
		}

		public String getType() {
			return this.type;
		}
}
