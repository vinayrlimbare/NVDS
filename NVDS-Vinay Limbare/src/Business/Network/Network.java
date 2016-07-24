/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.EnterpriseDirectory;
import Business.Inventory.InventoryDirectory;

/**
 *
 * @author Vinay Limbare
 */
public class Network {

    private String name;
    private int population = 0;
    private EnterpriseDirectory enterpriseDirectory;
    private InventoryDirectory inventoryDirectory;

    public Network() {
        enterpriseDirectory = new EnterpriseDirectory();
        inventoryDirectory = new InventoryDirectory();
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InventoryDirectory getInventoryDirectory() {
        return inventoryDirectory;
    }

    public void setInventoryDirectory(InventoryDirectory inventoryDirectory) {
        this.inventoryDirectory = inventoryDirectory;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return name;
    }
}
