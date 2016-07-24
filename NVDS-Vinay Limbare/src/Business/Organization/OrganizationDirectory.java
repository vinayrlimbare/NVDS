/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import java.util.ArrayList;

/**
 *
 * @author Vinay Limbare
 */
public class OrganizationDirectory {

    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public Organization createOrganization(Organization.Type type) {
        Organization organization = null;
        if (type.getValue().equals(Organization.Type.Order.getValue())) {
            organization = new OrderOrganization();
            organizationList.add(organization);
        }
        if (type.getValue().equals(Organization.Type.Finance.getValue())) {
            organization = new FinanceOrganization();
            organizationList.add(organization);
        }
        if (type.getValue().equals(Organization.Type.Inventory.getValue())) {
            organization = new InventoryOrganization();
            organizationList.add(organization);
        }
        if (type.getValue().equals(Organization.Type.Clinic.getValue())) {
            organization = new ClinicOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
}
