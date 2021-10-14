package edu.parinya.softarchdesign.structural;

public class TaxPayingHealthcareWorker extends HealthcareWorkerDecorator {
    public TaxPayingHealthcareWorker(HealthcareWorker worker) {
        super(worker);
        System.out.println("Decorate " + worker.getName() + " with TaxPaying.");
    }

    @Override
    public double getPrice() {
        // Add 10% on top
        return 1.1f * super.getPrice();
    }
}
