import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ticketsForMatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal budget = new BigDecimal(scanner.nextLine());
        String ticketsCategory = scanner.nextLine();
        int peopleInGroup = Integer.parseInt(scanner.nextLine());

        BigDecimal moneyForTransport = new BigDecimal("0.00");
        BigDecimal moneyForTickets = new BigDecimal("0.00");
        BigDecimal moneyDifference = new BigDecimal("0.00");


        if (peopleInGroup <= 4){
            moneyForTransport = new BigDecimal("0.75").multiply(budget);
        } else if (peopleInGroup <= 9){
            moneyForTransport = new BigDecimal("0.60").multiply(budget);
        } else if (peopleInGroup <= 24){
            moneyForTransport = new BigDecimal("0.50").multiply(budget);
        } else if (peopleInGroup <= 49){
            moneyForTransport = new BigDecimal("0.40").multiply(budget);
        } else if (peopleInGroup >= 50){
            moneyForTransport = new BigDecimal("0.25").multiply(budget);
        }

        switch (ticketsCategory) {
            case "Normal":
                moneyForTickets = new BigDecimal(peopleInGroup).multiply(new BigDecimal("249.99"));
                break;
            case "VIP":
                moneyForTickets = new BigDecimal(peopleInGroup).multiply(new BigDecimal("499.99"));
                break;
            default:
                moneyForTickets = new BigDecimal(peopleInGroup).multiply(new BigDecimal("249.99"));
                break;
        }

        DecimalFormat decimalFormatter = new DecimalFormat("0.00");
        moneyDifference = budget.subtract(moneyForTransport.add(moneyForTickets));

        String result = String.format("Yes! You have %s leva left.",
                decimalFormatter.format(
                        moneyDifference.setScale(2, BigDecimal.ROUND_HALF_EVEN)));

        if(moneyDifference.compareTo(BigDecimal.valueOf(0)) < 0 ) {
            result = String.format("Not enough money! You need %s leva.",
                    decimalFormatter.format(
                            moneyDifference.setScale(2, BigDecimal.ROUND_HALF_EVEN).abs()));
        }

        System.out.println(result);


    }
}
