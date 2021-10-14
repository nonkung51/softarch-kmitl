package edu.parinya.softarchdesign.structural;

abstract public class HealthcareWorkerDecorator extends HealthcareWorker {
    HealthcareWorker worker;

    public HealthcareWorkerDecorator(HealthcareWorker worker) {
        super(worker);
        this.worker = worker;
    }

    @Override
    public void service() {
        worker.service();
    }

    @Override
    public double getPrice() {
        return worker.getPrice();
    }
}
