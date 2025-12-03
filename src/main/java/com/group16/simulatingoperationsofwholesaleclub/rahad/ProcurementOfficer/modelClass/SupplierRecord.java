package com.group16.simulatingoperationsofwholesaleclub.rahad.ProcurementOfficer.modelClass;

import java.io.Serializable;


public class SupplierRecord implements Serializable {
    // Unique ID for version control during deserialization.
    private static final long serialVersionUID = 1L;

    private String supplierId;
    private String name;
    private String contact;
    private String address;

    public SupplierRecord(String supplierId, String name, String contact, String address) {
        this.supplierId = supplierId;
        this.name = name;
        this.contact = contact;
        this.address = address;
    }

    // --- Getters ---
    public String getSupplierId() { return supplierId; }
    public String getName() { return name; }
    public String getContact() { return contact; }
    public String getAddress() { return address; }

    // --- Setters (Used when updating an existing record) ---
    public void setName(String name) { this.name = name; }
    public void setContact(String contact) { this.contact = contact; }
    public void setAddress(String address) { this.address = address; }

    @Override
    public String toString() {
        return "SupplierRecord{" +
                "supplierId='" + supplierId + '\'' +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}