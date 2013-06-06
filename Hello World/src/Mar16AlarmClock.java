
public class Mar16AlarmClock {

		private int seconds;
		private int minutes;
		private int hours;
		private String day;
		
		private int alarmSec;
		private int alarmMin;
		private int alarmHr;
		
		private boolean alarmOn;
		
		public void soundAlarm() {
			if(seconds == alarm)
		}
		
		public void tick() {
			seconds++;
			if(seconds == 60) {
				minutes++;
				seconds = 0;
			}
			if(minutes == 60) {
				hours++;
				minutes = 0;
			}
			if(hours == 24) {
				hours = 0;
			}
		}
		
		//toString replaces ability to be printed
		public String toString() {
			String printMin = "";
			if(minutes < 9) {
				printMin = "0" + minutes;
			}
			
			return hours + ":" + printMin + ":" + seconds;
			
		}

		//source -> create getters and setters
		
		public int getSeconds() {
			return seconds;
		}

		public void setSeconds(int seconds) {
			this.seconds = seconds;
		}
		
		//public void setSeconds(int seconds_) {			might help to clarify with an underscore
			//seconds = seconds_;
		//}

		public int getMinutes() {
			return minutes;
		}

		public void setMinutes(int minutes) {
			this.minutes = minutes;
		}

		public int getHours() {
			return hours;
		}

		public void setHours(int hours) {
			this.hours = hours;
		}

		public String getDay() {
			return day;
		}

		public void setDay(String day) {
			this.day = day;
		}

		public int getAlarmSec() {
			return alarmSec;
		}

		public void setAlarmSec(int alarmSec) {
			this.alarmSec = alarmSec;
		}

		public int getAlarmMin() {
			return alarmMin;
		}

		public void setAlarmMin(int alarmMin) {
			this.alarmMin = alarmMin;
		}

		public int getAlarmHr() {
			return alarmHr;
		}

		public void setAlarmhr(int alarmHr) {
			this.alarmHr = alarmHr;
		}

		public boolean isAlarmOn() {
			return alarmOn;
		}

		public void setAlarmOn(boolean alarmOn) {
			this.alarmOn = alarmOn;
		}
		
		
		
			
}
