/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

/**
 * class that represents credit release type, can be common or credit line
 * @author Тарановский
 */
public class ReleaseType {
    /**
     * list of state names
     * @pdOid f8faca63-13cf-49f9-b556-7657f9e5b55b
     */
    public static final String[] releaseTypeName = {"common", "credit line"};
    /*
     * if the credit is credit line or is common
     * @pdOid ac8a1cb2-a7b7-4749-af1b-e4bffea7da1b
     */
    boolean releaseType = false;
    /**
     * empty constructor
     */
    public ReleaseType() {}

    /**
     * set credit release type
     * @param newReleaseType credit release type
     * @pdOid 2180852b-27e9-42b0-9e23-f6d85f2d8ed2
     */
    public void setReleaseType(boolean newReleaseType) {
        releaseType = newReleaseType;
    }

    /**
     * get credit release type
     * @return credit release type
     * @pdOid a7b2d918-2b78-47c8-af0e-5c9ef1591837
     */
    public boolean getReleaseType() {
        return releaseType;
    }
    
}
