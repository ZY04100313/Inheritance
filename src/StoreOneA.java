class StoreOneA extends StoreToRent {
    private static final double DISCOUNT_RATE = 0.1;
    private boolean specialCustomer;
    private double monthlyPayment;

    public StoreOneA(boolean loanRequired, double loanAmount, int loanPaymentTerm, boolean specialCustomer) {
        super(loanRequired, loanAmount, loanPaymentTerm);
        this.specialCustomer = specialCustomer;
    }

    public void showStoreInfo() {
        System.out.println(toString());
    }

    @Override
    public double calculateLoanFinancing() {
        monthlyPayment = super.calculateLoanFinancing();
        if (specialCustomer) {
            monthlyPayment -= (monthlyPayment * DISCOUNT_RATE);
        }
        return monthlyPayment;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\nLOAN DETAILS (if applicable):");
        sb.append("\nLoan Amount: ").append(getLoanAmount());
        sb.append("\nLoan Payment Term: ").append(getLoanPaymentTerm());
        sb.append("\nInterest Rate: ").append(getINTEREST_RATE());
        sb.append("\nSpecial Customer: ").append(specialCustomer);
        sb.append("\nMonthly Loan Payment: ").append(calculateLoanFinancing());
        return sb.toString();
    }
}    