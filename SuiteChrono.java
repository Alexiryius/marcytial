package marcytial;

public class SuiteChrono {
	
	private String date;
	private double open, high, low, close;

	public SuiteChrono() {
		
	}
		public SuiteChrono(String date, double open) {
		this.date = date;
		this.open = open;
		
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getOpen() {
		return open;
	}

	public void setOpen(double open) {
		this.open = open;
	}



	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}



	public double getClose() {
		return close;
	}



	public void setClose(double close) {
		this.close = close;
	}

	public String toString()
    {
        return getDate() +" | " + getOpen() ;
    }

	

}


