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
public class ShippingAddress {
    private String city;
    private int postalcode;
    private boolean isAddressSharingConfidential;
    private String stateOrRegion;
    private String countryCode;

    public ShippingAddress(String city, int postalcode, boolean isAddressSharingConfidential, String stateOrRegion, String countryCode) {
        this.city = city;
        this.postalcode = postalcode;
        this.isAddressSharingConfidential = isAddressSharingConfidential;
        this.stateOrRegion = stateOrRegion;
        this.countryCode = countryCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(int postalcode) {
        this.postalcode = postalcode;
    }

    public boolean isIsAddressSharingConfidential() {
        return isAddressSharingConfidential;
    }

    public void setIsAddressSharingConfidential(boolean isAddressSharingConfidential) {
        this.isAddressSharingConfidential = isAddressSharingConfidential;
    }

    public String getStateOrRegion() {
        return stateOrRegion;
    }

    public void setStateOrRegion(String stateOrRegion) {
        this.stateOrRegion = stateOrRegion;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    
}
