package gui;

public class MainframeEvent {
		private String type = null;
		private int seekbarPosition;
		public static enum EventType {
			REPAINT, SEEKBARPOSITION
		}

		public MainframeEvent(EventType type) {
			this.type = type.toString();
		}
		
		public MainframeEvent(EventType type, int sbp) {
			this.type = type.toString();
			this.seekbarPosition=sbp;
		}

		public String getType() {
			return this.type;
		}

		public int getSeekbarPosition() {
			return seekbarPosition;
		}
}
