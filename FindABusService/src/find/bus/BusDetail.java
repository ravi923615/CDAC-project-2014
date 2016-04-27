package find.bus;

public class BusDetail {
	
	public String BusNumber;
	public String Source;
	public String Destination;
	public int NumberofDaysRunning;
	public int StartTime;
	public int EndTime;
	public int SeatAvailability;
	
	
	public BusDetail() {
	}
	public BusDetail(String busNumber, String source, String destination,
			int numberofDaysRunning, int startTime, int endTime,
			int seatAvailability) {
		super();
		BusNumber = busNumber;
		Source = source;
		Destination = destination;
		NumberofDaysRunning = numberofDaysRunning;
		StartTime = startTime;
		EndTime = endTime;
		SeatAvailability = seatAvailability;
	}
	public String getBusNumber() {
		return BusNumber;
	}
	public void setBusNumber(String busNumber) {
		BusNumber = busNumber;
	}
	public String getSource() {
		return Source;
	}
	public void setSource(String source) {
		Source = source;
	}
	public String getDestination() {
		return Destination;
	}
	public void setDestination(String destination) {
		Destination = destination;
	}
	public int getNumberofDaysRunning() {
		return NumberofDaysRunning;
	}
	public void setNumberofDaysRunning(int numberofDaysRunning) {
		NumberofDaysRunning = numberofDaysRunning;
	}
	public int getStartTime() {
		return StartTime;
	}
	public void setStartTime(int startTime) {
		StartTime = startTime;
	}
	public int getEndTime() {
		return EndTime;
	}
	public void setEndTime(int endTime) {
		EndTime = endTime;
	}
	public int getSeatAvailability() {
		return SeatAvailability;
	}
	public void setSeatAvailability(int seatAvailability) {
		SeatAvailability = seatAvailability;
	}
	@Override
	public String toString() {
		return "BusNumber=" + BusNumber + "\n--- Source=" + Source
				+ "\n--- Destination=" + Destination + "\n--- NumberofDaysRunning="
				+ NumberofDaysRunning + "\n--- StartTime=" + StartTime
				+ "\n --- EndTime=" + EndTime + "\n--- SeatAvailability="
				+ SeatAvailability;
	}

}
