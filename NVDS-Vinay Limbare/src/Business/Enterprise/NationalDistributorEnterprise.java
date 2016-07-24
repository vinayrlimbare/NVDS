/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Roles.NationalDistributorAdminRole;
import Business.Roles.Role;
import java.util.ArrayList;

/**
 *
 * @author Vinay Limbare
 */
public class NationalDistributorEnterprise extends Enterprise {

    public NationalDistributorEnterprise() {
        super("ND", EnterpriseType.NationalDistrubuter);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new NationalDistributorAdminRole());
        return roles;
    }
}
