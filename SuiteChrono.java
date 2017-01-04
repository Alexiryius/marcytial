package marcytial;

public class SuiteChrono {
	private String date;
	private double open, high;

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

	public String toString()
    {
        return getDate() +" | " + getOpen();
    }

	

}
