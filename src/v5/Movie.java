package v5;

public class Movie {

	public double getAmount(Rental rental)
	{
		double result = 0;

		switch (rental.getMovie().getPriceCode())
		{
			case REGULAR:
				result += 2;
				if (rental.getDaysRented() > 2)
					result += (rental.getDaysRented() - 2) * 1.5;
				break;
			case NEW_RELEASE:
				result += rental.getDaysRented() * 3;
				break;
			case CHILDRENS:
				result += 1.5;
				if (rental.getDaysRented() > 3)
					result += (rental.getDaysRented() - 3) * 1.5;
				break;
		}
		return result;
	}

	public int getFrequentRentalPoints(Rental rental)
	{
		return (rental.getMovie().getPriceCode() == Code.NEW_RELEASE) && rental.getDaysRented() > 1 ? 2 : 1;
	}

	public enum Code {REGULAR, CHILDRENS, NEW_RELEASE};
	
	private String _title;
	private Code _priceCode;
	
	public Movie(String title, Code priceCode) {
		_title = title;
		_priceCode = priceCode;
	}

	public String getTitle() {
		return _title;
	}

	public Code getPriceCode() {
		return _priceCode;
	}
}
