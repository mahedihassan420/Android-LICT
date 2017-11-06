package com.hisoft.ovi.islamicorganization;

import java.util.List;

/**
 * Created by Invariant on 10/8/17.
 */

public class GooglePlace extends DTOBase {

    private List<GooglePlaces> results;


    public List<GooglePlaces> getResults() {
        return results;
    }

    public void setResults(List<GooglePlaces> results) {
        this.results = results;
    }
}
