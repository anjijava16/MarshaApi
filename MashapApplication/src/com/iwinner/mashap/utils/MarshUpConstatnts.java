package com.iwinner.mashap.utils;

import java.util.ResourceBundle;

public class MarshUpConstatnts {
	public static ResourceBundle CONFIG = ResourceBundle.getBundle("Config");
    public static String INSERT_QUERY=CONFIG.getString("INSERT_QUERY");
    public static String SELECT_CURRENCY=CONFIG.getString("SELECT_CURRENCY");
    public static String INSERT_DEPLOYEMENT_QUERY=CONFIG.getString("INSERT_DEPLOY_QUERY");
    public static String SELECT_DEPLOYE_QUERY=CONFIG.getString("SELECT_DEPLOYE_QUERY");
    public static String COUNTRY_NAME="COUNTRY_NAME";
    public static String COUNTRY_CAPITAL_NAME="CAPITAL_NAME";
    public static String COUNTRY_REGION_NAME="REGION_NAME";
    public static String COUNTRY_CURRENCY_NAME="CURRENCY_NAME";
    public static String COUNTRY_LANGUAGES="COUNTRY_LANGUAGES";
    public static String COUNTRY_CALLINGCODE="CALLINGCODE";
    public static String COUNTRY_NATIONALITY="NATIONALITY";
    public static String COUNTRY_TIMEZONES="TIMEZONE";
    public static String COUNTRY_POPULATION="POPULATION";
    public static String COUNTRY_ALPHA2CODE="ALPHA2CODE";
    public static String COUNTRY_ALPHA3CODE="ALPHA3CODE";

    public static String COUNTRY_GINI="GINI";
    public static String COUNTRY_AREA="AREA";
    public static String COUNTRY_ALTRA_SPELLING="ALTSPELLING";
    public static String COUNTRY_ISO_CODE="ISOCODE";
    public static String LANLAT="LANLAT";
    public static String EMPTY_BRACKET="";

    
    /*
	`languages` VARCHAR(100) NOT NULL DEFAULT '0',
	`callingcode` VARCHAR(100) NOT NULL DEFAULT '0',
	`alpha2Code` VARCHAR(100) NOT NULL DEFAULT '0',
	`alpha3Code` VARCHAR(100) NOT NULL DEFAULT '0',
	`nationality` VARCHAR(100) NOT NULL DEFAULT '0',
	`timezones` VARCHAR(100) NOT NULL DEFAULT '0',
	`population` VARCHAR(100) NOT NULL DEFAULT '0',
*/
    
    public static String FACEBOOK_YOUTUBE="https://graph.facebook.com/youtube";
    public static String FACEBOOK_YOUTUBE_FIELDS="https://graph.facebook.com/youtube?fields=likes,name";
    public static String GOOGLE_MAP_LOCATION="http://maps.googleapis.com/maps/api/geocode/json?address=chicago&senspr=false";
}
