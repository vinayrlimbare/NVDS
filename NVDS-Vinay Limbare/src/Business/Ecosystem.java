package Business;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.NationalDistributorEnterprise;
import Business.Inventory.InventoryDirectory;
import Business.Network.Network;
import Business.Network.NetworkDirectory;
import Business.Order.Order;
import Business.Organization.Organization;
import Business.Roles.Role;
import Business.Roles.SystemAdminRole;
import Business.UserAccount.UserAccount;
import Business.Vaccine.VaccineDirectory;
import java.util.ArrayList;

/**
 *
 * @author Vinay Limbare
 */
public class Ecosystem extends Enterprise {

    private static Ecosystem business;
    private float ratio = (float) 0.4;
    private NetworkDirectory networkDirectory;
    private VaccineDirectory vaccineDirectory;
    private NationalDistributorEnterprise nationalDistributorEnterprise;
    private InventoryDirectory inventoryDirectory;

    public static Ecosystem getInstance() {
        if (business == null) {
            business = new Ecosystem();
        }
        return business;
    }

    private Ecosystem() {
        super(null, null);
        networkDirectory = new NetworkDirectory();
        vaccineDirectory = new VaccineDirectory();
        nationalDistributorEnterprise = new NationalDistributorEnterprise();
        inventoryDirectory = new InventoryDirectory();
    }

    public NetworkDirectory getNetworkDirectory() {
        return networkDirectory;
    }

    public void setNetworkDirectory(NetworkDirectory networkDirectory) {
        this.networkDirectory = networkDirectory;
    }

    public VaccineDirectory getVaccineDirectory() {
        return vaccineDirectory;
    }

    public void setVaccineDirectory(VaccineDirectory vaccineDirectory) {
        this.vaccineDirectory = vaccineDirectory;
    }

    public NationalDistributorEnterprise getNationalDistributorEnterprise() {
        return nationalDistributorEnterprise;
    }

    public void setNationalDistributorEnterprise(NationalDistributorEnterprise nationalDistributorEnterprise) {
        this.nationalDistributorEnterprise = nationalDistributorEnterprise;
    }

    public InventoryDirectory getInventoryDirectory() {
        return inventoryDirectory;
    }

    public void setInventoryDirectory(InventoryDirectory inventoryDirectory) {
        this.inventoryDirectory = inventoryDirectory;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

    public boolean checkIfUsernameIsUnique(String username) {
        if (username.equals("sys") || username.equals("nd")) {
            return false;
        }
        for (Network network : getNetworkDirectory().getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (UserAccount userAccount : enterprise.getUserAccountDirectory().getUserAccountList()) {
                    if (userAccount.getUsername().equals(username)) {
                        return false;
                    }
                }
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    for (UserAccount userAccount : organization.getUserAccountDirectory().getUserAccountList()) {
                        if (userAccount.getUsername().equals(username)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public int getOrderId() {
        int count = 0;
        for (Network network : getNetworkDirectory().getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    for (UserAccount userAccount : organization.getUserAccountDirectory().getUserAccountList()) {
                        Employee employee = userAccount.getEmployee();
                        for (Order order : employee.getMasterOrderCatalog().getOrderCatalog()) {
                            System.out.println(order.getOrderNumber());
                            if (order != null) {
                                count++;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
