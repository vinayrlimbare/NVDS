/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Roles;

import Business.Ecosystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.Pharmacy.PharmacyAdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Vinay Limbare
 */
public class PharmacyAdminRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Ecosystem system) {
        return new PharmacyAdminWorkAreaJPanel(userProcessContainer, account, enterprise, system);
    }
}
