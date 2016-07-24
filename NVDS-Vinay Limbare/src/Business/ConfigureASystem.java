package Business;

import Business.Employee.Employee;
import Business.Inventory.InventoryItem;
import Business.Network.Network;
import Business.Roles.NationalDistributorAdminRole;
import Business.Roles.SystemAdminRole;
import Business.UserAccount.UserAccount;
import Business.Vaccine.Vaccine;

/**
 *
 * @author Vinay Limbare
 */
public class ConfigureASystem {

    public static Ecosystem configure() {

        Ecosystem system = Ecosystem.getInstance();

        Network network = system.getNetworkDirectory().createAndAddNetwork("Massachusetts");
        network.setPopulation(10000);

        Employee employee = system.getEmployeeDirectory().createEmployee("Vinay Limbare");
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sys", "sys", employee, new SystemAdminRole());

        Employee employee1 = system.getEmployeeDirectory().createEmployee("Deepak");
        UserAccount ua2 = system.getUserAccountDirectory().createUserAccount("nd", "nd", employee1, new NationalDistributorAdminRole());

        Vaccine vaccine = system.getVaccineDirectory().addVaccine(1, "Influenza", "Flu", (float) 11.99, "08-May-2014", "01-May-2016");
        Vaccine vaccine1 = system.getVaccineDirectory().addVaccine(2, "Varicella", "Chicken Pox", (float) 10, "12-May-2014", "12-May-2016");

        InventoryItem item = network.getInventoryDirectory().addInventory(network, vaccine, 500);
        item.setAvailability(500);

        InventoryItem item1 = network.getInventoryDirectory().addInventory(network, vaccine1, 250);
        item1.setAvailability(250);

        return system;
    }

}
