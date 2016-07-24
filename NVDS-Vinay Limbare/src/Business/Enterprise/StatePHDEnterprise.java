/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Roles.Role;
import Business.Roles.StatePHDAdminRole;
import java.util.ArrayList;

/**
 *
 * @author Vinay Limbare
 */
public class StatePHDEnterprise extends Enterprise {

    public StatePHDEnterprise(String name) {
        super(name, EnterpriseType.StatePHD);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new StatePHDAdminRole());
        return roles;
    }
}
