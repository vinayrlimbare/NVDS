/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Roles.ManufactureAdminRole;
import Business.Roles.Role;
import java.util.ArrayList;

/**
 *
 * @author Vinay Limbare
 */
public class ManufacturerEnterprise extends Enterprise {

    public ManufacturerEnterprise(String name) {
        super(name, EnterpriseType.Manufacturer);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(new ManufactureAdminRole());
        return roles;
    }
}
