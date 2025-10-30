package v5;

public class Movie {

    public double getRentalAmount(int daysRented)
    {
        double result = 0;

        switch (getPriceCode())
        {
            case REGULAR:
                result += 2;
                if (daysRented > 2)
                    result += ( - 2) * 1.5;
                break;
            case NEW_RELEASE:
                result += daysRented * 3;
                break;
            case CHILDRENS:
                result += 1.5;
                if (daysRented > 3)
                    result += (daysRented - 3) * 1.5;
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
