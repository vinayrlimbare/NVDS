/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Roles.ClinicAdminRole;
import Business.Roles.Role;
import java.util.ArrayList;

/**
 *
 * @author Vinay Limbare
 */
public class ClinicOrganization extends Organization {

    public ClinicOrganization() {
        super(OrderOrganization.Type.Clinic.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ClinicAdminRole());
        return roles;
    }

}
