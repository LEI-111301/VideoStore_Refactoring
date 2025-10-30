package ficha3;

public class Rental {
    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }


    public double getAmount() {
        double thisAmount = 0;

        // determine amounts for each line
        switch (_movie.getPriceCode()) {
            case REGULAR:
                thisAmount += 2;
                if (_daysRented > 2)
                    thisAmount += (_daysRented - 2) * 1.5;
                break;
            case NEW_RELEASE:
                thisAmount += _daysRented * 3;
                break;
            case CHILDRENS:
                thisAmount += 1.5;
                if (_daysRented > 3)
                    thisAmount += (_daysRented - 3) * 1.5;
                break;
        }
        return thisAmount;
    }


    public int getFrequentRenterPoints() {
        int points = 1;
        if ((_movie.getPriceCode() == Movie.Code.NEW_RELEASE) && _daysRented > 1)
            points++;
        return points;
    }
}
