package com.codeup.adlister.dao;


import java.sql.SQLException;
import java.util.List;

import com.codeup.adlister.models.Ad;

public interface Ads {
    // get a list of all the ads
    List<Ad> all() throws SQLException;
    // insert a new ad and return the new ad's id
    Long insert(Ad ad) throws SQLException;
}
