/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Roles.HospitalOrderRole;
import Business.Roles.PharmacyOrderRole;
import Business.Roles.Role;
import java.util.ArrayList;

/**
 *
 * @author Vinay Limbare
 */
public class OrderOrganization extends Organization {

    public OrderOrganization() {
        super(Organization.Type.Order.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new HospitalOrderRole());
        roles.add(new PharmacyOrderRole());
        return roles;
    }
}
