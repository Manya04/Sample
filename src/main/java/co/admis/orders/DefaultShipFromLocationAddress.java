/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.admis.orders;

/**
 *
 * @author manyaagarwal
 */
public class DefaultShipFromLocationAddress {
    private String City;
    private int postalCode;
    private boolean isAddressSharingConfidential; 
    private String StateOrRegion;
    private int Phone;
    private String CountryCode;
    private String Name;
    private String AddressLine1;
    private String AddressLine2;

    public DefaultShipFromLocationAddress(String City, int postalCode, boolean isAddressSharingConfidential, String StateOrRegion, int Phone, String CountryCode, String Name, String AddressLine1, String AddressLine2) {
        this.City = City;
        this.postalCode = postalCode;
        this.isAddressSharingConfidential = isAddressSharingConfidential;
        this.StateOrRegion = StateOrRegion;
        this.Phone = Phone;
        this.CountryCode = CountryCode;
        this.Name = Name;
        this.AddressLine1 = AddressLine1;
        this.AddressLine2 = AddressLine2;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public boolean isIsAddressSharingConfidential() {
        return isAddressSharingConfidential;
    }

    public void setIsAddressSharingConfidential(boolean isAddressSharingConfidential) {
        this.isAddressSharingConfidential = isAddressSharingConfidential;
    }

    public String getStateOrRegion() {
        return StateOrRegion;
    }

    public void setStateOrRegion(String StateOrRegion) {
        this.StateOrRegion = StateOrRegion;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int Phone) {
        this.Phone = Phone;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String CountryCode) {
        this.CountryCode = CountryCode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddressLine1() {
        return AddressLine1;
    }

    public void setAddressLine1(String AddressLine1) {
        this.AddressLine1 = AddressLine1;
    }

    public String getAddressLine2() {
        return AddressLine2;
    }

    public void setAddressLine2(String AddressLine2) {
        this.AddressLine2 = AddressLine2;
    }
    
}
