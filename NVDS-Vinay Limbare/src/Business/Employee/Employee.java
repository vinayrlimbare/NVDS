/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.MasterOrder.MasterOrderCatalog;

/**
 *
 * @author Vinay Limbare
 */
public class Employee {

    private String name;
    private int id;
    private static int count = 1;
    private MasterOrderCatalog masterOrderCatalog;

    public Employee() {
        id = count;
        count++;
        masterOrderCatalog = new MasterOrderCatalog();
    }

    public MasterOrderCatalog getMasterOrderCatalog() {
        return masterOrderCatalog;
    }

    public void setMasterOrderCatalog(MasterOrderCatalog masterOrderCatalog) {
        this.masterOrderCatalog = masterOrderCatalog;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}
