/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Roles.DistributorAdminRole;
import Business.Roles.Role;
import java.util.ArrayList;

/**
 *
 * @author Vinay Limbare
 */
public class DistributorEnterprise extends Enterprise {

    public DistributorEnterprise(String name) {
        super(name, EnterpriseType.Distributor);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(new DistributorAdminRole());
        return roles;
    }

}
