/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Inventory.InventoryDirectory;
import Business.Roles.PharmacyAdminRole;
import Business.Roles.Role;
import java.util.ArrayList;

/**
 *
 * @author Vinay Limbare
 */
public class PharmacyEnterprise extends Enterprise {

    private InventoryDirectory inventoryDirectory;
    private String registrationStatus = "";

    public PharmacyEnterprise(String name) {
        super(name, EnterpriseType.Pharmacy);
        inventoryDirectory = new InventoryDirectory();
    }

    public InventoryDirectory getInventoryDirectory() {
        return inventoryDirectory;
    }

    public void setInventoryDirectory(InventoryDirectory inventoryDirectory) {
        this.inventoryDirectory = inventoryDirectory;
    }

    public String getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(String registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new PharmacyAdminRole());
        return roles;
    }

}
