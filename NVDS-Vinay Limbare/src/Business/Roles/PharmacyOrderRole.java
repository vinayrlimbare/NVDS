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
import UserInterface.Pharmacy.OrderRole.PharmacyOrderWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Vinay Limbare
 */
public class PharmacyOrderRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Ecosystem business) {
        return new PharmacyOrderWorkAreaJPanel(userProcessContainer, account, organization, enterprise, business);
    }
}
