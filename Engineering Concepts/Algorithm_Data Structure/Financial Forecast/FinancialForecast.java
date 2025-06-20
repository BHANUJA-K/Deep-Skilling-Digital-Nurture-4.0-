public class FinancialForecast {

    public static double futureValue(double principal, double rate, int years) {
        if (years == 0) {
            return principal;
        } else {
            return futureValue(principal, rate, years - 1) * (1 + rate);
        }
    }

    public static void main(String[] args) {
        double principal = 10000; 
        double rate = 0.07;       
        int years = 5;

        double forecast = futureValue(principal, rate, years);
        System.out.printf("Projected Future Value after %d years: %.2f%n", years, forecast);
    }
}
