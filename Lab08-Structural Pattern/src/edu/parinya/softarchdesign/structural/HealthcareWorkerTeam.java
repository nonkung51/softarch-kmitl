package edu.parinya.softarchdesign.structural;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class HealthcareWorkerTeam implements HealthcareServiceable {
    public Set<HealthcareServiceable> members;
    private static DecimalFormat fmt = new DecimalFormat("#.#");

    private Set<HealthcareServiceable> getMembers() {
        if (members == null) {
            members = new LinkedHashSet<>();
        }
        return members;
    }

    public void addMember(HealthcareServiceable member) {
        getMembers().add(member);
    }

    public void removeMember(HealthcareServiceable member) {
        getMembers().remove(member);
    }

    public void service() {
        Iterator<HealthcareServiceable> it = this.getMembers().iterator();

        while (it.hasNext()) {
            HealthcareServiceable healthcareServiceable = it.next();
            healthcareServiceable.service();
        }
    }

    public double getPrice() {
        double totalPrice = 0.0f;
        for (HealthcareServiceable member : this.getMembers()) {
            totalPrice += member.getPrice();
        }
        return Double.parseDouble(fmt.format(totalPrice));
    }
}
