package ficha3;

import java.util.Vector;

public class Customer {
    private String _name;
    private Vector<Rental> _rentals = new Vector<Rental>();

    public Customer(String _name) {
        this._name = _name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    // Novo método para calcular pontos de frequent renter
    private int getFrequentRenterPoints(Rental rental) {
        int points = 1; // 1 ponto por cada aluguer
        if ((rental.getMovie().getPriceCode() == Movie.Code.NEW_RELEASE) && rental.getDaysRented() > 1) {
            points++; // ponto extra para novos lançamentos alugados mais de 1 dia
        }
        return points;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        String result = "Rental Record for " + getName() + "\n";

        for (Rental each : _rentals) {
            // Inline do cálculo do valor do aluguer
            result += "\t" + each.getMovie().getTitle() + "\t" + each.getAmount() + "\n";
            totalAmount += each.getAmount();

            // calcular pontos de frequent renter usando o método extraído
            frequentRenterPoints += getFrequentRenterPoints(each);
        }

        // footer
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";

        return result;
    }
}
