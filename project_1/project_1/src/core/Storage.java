/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.List;
import java.util.LinkedList;

/**
 * class that represents a list of many credit proposals
 * @author Alex
 */
public class Storage {

    /*
     * initial credit proposal list
     */
    private List<CreditChoise> initialList = new LinkedList<>();
    /*
     * filtered credip proposal list
     */
    private List<CreditChoise> filteredList = new LinkedList<>();
    
    private List<CreditChoise> tempList = new LinkedList();
    /*
     * filters
     */
    private String filterName = null;
    private int filterType = -1;
    private int filterTimeLength = -1;
    private boolean filterEarlyReturn;
    private boolean filterReleaseType;
    private boolean filterLineExpandable;
    private boolean filterIsCash;
    private boolean filterIsDifferential;

    /*
     * filter apply detection
     */
    private final int filter[] = new int[7];

    /**
     * constructor
     */
    public Storage() {
        initialise();
        setFilteredList(initialList);

    }

    /**
     * function to fill the list of credit proposal
     */
    public void initialise() {
        initialList.add(new CreditChoise("safs", 0, 2, true, true, true, true, 94, 12, false));
        initialList.add(new CreditChoise("sadfasdf", 2, 2, true, false, false, false, 79, 12, true));
        initialList.add(new CreditChoise("ertw", 0, 2, true, true, false, false, 99, 14, false));
        initialList.add(new CreditChoise("fgdf", 0, 2, true, false, false, false, 8, 12, true));
        initialList.add(new CreditChoise("fghdfh", 0, 2, true, true, false, true, 27, 19, true));
        initialList.add(new CreditChoise("tyeyer", 1, 1, true, false, false, true, 64, 12, true));
        initialList.add(new CreditChoise("rtyer", 0, 1, false, false, false, false, 99, 11, true));
        initialList.add(new CreditChoise("ghgdh", 2, 2, true, true, false, true, 17, 11, true));
        initialList.add(new CreditChoise("dfgh", 1, 2, false, false, true, true, 58, 17, false));
        initialList.add(new CreditChoise("gfhd", 1, 1, false, true, true, false, 17, 18, true));
        initialList.add(new CreditChoise("hjgk", 2, 0, false, true, false, true, 81, 12, false));
        initialList.add(new CreditChoise("gh", 0, 1, false, false, false, true, 23, 14, true));
        initialList.add(new CreditChoise("bcvn", 0, 1, true, true, false, false, 22, 11, true));
        initialList.add(new CreditChoise("eygbvc", 1, 1, true, true, false, true, 41, 13, true));
        initialList.add(new CreditChoise("hdghjfvbc", 0, 0, false, true, false, false, 15, 12, true));
    }

    /**
     * get the initial credit proposal list
     * @return the initial list
     */
    public List<CreditChoise> getInitialList() {
        return initialList;
    }

    /**
     * set the initial credit proposal list
     * @param initialList the initial list 
     */
    public void setInitialList(List<CreditChoise> initialList) {
        this.initialList = initialList;
    }

    /**
     * get the filtered credit proposal list
     * @return the filteredList
     */
    public List<CreditChoise> getFilteredList() {
        return filteredList;
    }

    /**
     * set the filtered credit proposal list
     * @param filteredList the filteredList to set
     */
    public void setFilteredList(List<CreditChoise> filteredList) {
        this.filteredList = filteredList;
    }

    /**
     * get bank name filter
     * @return the bank name filter
     */
    public String getFilterName() {
        return filterName;
    }

    /**
     * get the filter by credit type
     * @return the filterType
     */
    public int getFilterType() {
        return filterType;
    }

    /**
     * get the filter by credit time length
     * @return the filterTimeLength
     */
    public int getFilterTimeLength() {
        return filterTimeLength;
    }

    /**
     * set the filter by credit time length
     * @param filterTimeLength the filterTimeLength to set
     */
    public void setFilterTimeLength(int filterTimeLength) {
        this.filterTimeLength = filterTimeLength;
        filter[2] = 1;
    }

    /**
     * get the filter if credit can be returned early
     * @return the filterEarlyReturn
     */
    public boolean isFilterEarlyReturn() {
        return filterEarlyReturn;
    }

    /**
     * set the filter if credit can be returned early
     * @param filterEarlyReturn the filterEarlyReturn to set
     */
    public void setFilterEarlyReturn(boolean filterEarlyReturn) {
        this.filterEarlyReturn = filterEarlyReturn;
        filter[2] = 1;
    }

    /**
     * get the filter release type
     * @return the filter release type
     */
    public boolean isFilterReleaseType() {
        return filterReleaseType;
    }

    /**
     * set the filter release type
     * @param filterReleaseType the filterReleaseType to set
     */
    public void setFilterReleaseType(boolean filterReleaseType) {
        this.filterReleaseType = filterReleaseType;
        filter[3] = 1;
    }

    /**
     * get the filter if credit's line is expandable
     * @return the filterLineExpandable
     */
    public boolean isFilterLineExpandable() {
        return filterLineExpandable;
    }

    /**
     * set the filter if credit's line is expandable
     * @param filterLineExpandable the filterLineExpandable to set
     */
    public void setFilterLineExpandable(boolean filterLineExpandable) {
        this.filterLineExpandable = filterLineExpandable;
        filter[4] = 1;
    }

    /**
     * get the filter if credit is given by cash
     * @return if the filter is cash
     */
    public boolean isFilterIsCash() {
        return filterIsCash;
    }

    /**
     * set the filter if credit is given by cash
     * @param filterIsCash the filterIsCash to set
     */
    public void setFilterIsCash(boolean filterIsCash) {
        this.filterIsCash = filterIsCash;
        filter[5] = 1;
    }

    /**
     * get the filter if the credit is differential
     * @return if the filter is differential
     */
    public boolean isFilterIsDifferential() {
        return filterIsDifferential;
    }

    /**
     * set the filter if the credit is differential
     * @param filterIsDifferential the filterIsDifferential to set
     */
    public void setFilterIsDifferential(boolean filterIsDifferential) {
        this.filterIsDifferential = filterIsDifferential;
        filter[6] = 1;
    }

    /**
     * function that clears all filters
     */
    public void clearFilter() {
        for (int i = 0; i < 7; i++) {
            filter[i] = 0;
        }
        setFilteredList(initialList);
    }

    /**
     * set the filter by bank name
     * @param filterName the filter back name to set
     */
    public void setFilterName(String filterName) {
        this.filterName = filterName;
        filter[0] = 1;
    }

    /**
     * set the filter by credit type
     * @param filterType the filter credit type to set
     */
    public void setFilterType(int filterType) {
        this.filterType = filterType;
        filter[1] = 1;
    }

    /**
     * check if this credit proposal passes through the filter
     * @param creditChoise credit proposal to check
     * @return if this credit proposal passes through the filter
     */
    public boolean matchFilter(CreditChoise creditChoise) {
        
        if (filter[0] == 1 & !(creditChoise.getBankName().equals(filterName))) {
            return false;
        }
        if (filter[1] == 1 & !(creditChoise.getType() == filterType)) {
            return false;
        }
        if (filter[2] == 1 & !(creditChoise.getTimeLength() == filterTimeLength)) {
            return false;
        }
        if (filter[3] == 1 & (creditChoise.getEarlyReturn() != filterEarlyReturn)) {
            return false;
        }
        if (filter[4] == 1 & (creditChoise.getReleaseType() != filterReleaseType)) {
            return false;
        }
        if (filter[5] == 1 & (creditChoise.getLineExpandable() != filterLineExpandable)) {
            return false;
        }

        return !(filter[6] == 1 & (creditChoise.getIsDifferential() != filterIsDifferential));
    }

    /**
     * function that applies filters to credit proposal list
     */
    public void filterList() {
        for (int i = 0; i < filteredList.size(); i++) {
            if (matchFilter(filteredList.get(i))) {
                getTempList().add(filteredList.get(i));
            }
        }
        setFilteredList(getTempList());
    }

    /**
     * @return the tempList
     */
    public List<CreditChoise> getTempList() {
        return tempList;
    }

    /**
     * @param tempList the tempList to set
     */
    public void setTempList(List<CreditChoise> tempList) {
        this.tempList = tempList;
    }
}
