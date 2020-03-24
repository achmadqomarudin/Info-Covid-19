package com.example.infocovid_19.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created .
 */

public class PrefManager {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "sharedPreference";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    //menuProfile
    private static final String EMAIL = "email";
    private static final String NAME = "name";
    private static final String TOKEN = "token";
    //menuCategory
    private static final String CATEGORY_ID = "categoryId";
    private static final String SOURCE_ID = "sourceId";
    //menuProfile
    private static final String IMAGE_PROFILE = "imageProfile";
    //itemCount badgeCart
    private static final String ITEM_COUNT = "itemCount";
    private static final String SORT_BY_SHOPCIETY = "sortByShopciety";
    private static final String SORT_BY_AMAZON = "sortByAmazon";
    //bottomSheet urutkan
    private static final String SELECT = "select";
    //fragment
    private static final String SELECT_FRAGMENT = "select_fragment";
    //bottomSheet filter
    private static final String SELECT_FILTER_CATEGORY = "select_filter_category";
    private static final String SELECT_FILTER_SOURCE = "select_filter_source";

    //Response Category Fragment
    private static final String RESPONSE_CATEGORY_FRAGMENT = "response_category_fragment";
    private static final String RESPONSE_FECH_CATEGORY_DATA_SHOPCIETY = "response_fech_category_data_shopciety";
    private static final String RESPONSE_FECH_CATEGORY_DATA_AMAZON = "response_fech_category_data_amazon";
    private static final String RESPONSE_FECH_CATEGORY_DATA_CARTER = "response_fech_category_data_carter";
    private static final String RESPONSE_FECH_CATEGORY_DATA_LEGO = "response_fech_category_data_lego";
    private static final String RESPONSE_FECH_CATEGORY_DATA_MACYS = "response_fech_category_data_macys";
    private static final String RESPONSE_FECH_CATEGORY_DATA_SAKS = "response_fech_category_data_saks";
    private static final String RESPONSE_FECH_CATEGORY_DATA_TARGET = "response_fech_category_data_target";
    private static final String CHECK_VALIDATION_LOGIN_CATEGORY = "check_validation_login_category";


    public PrefManager(Context _context) {
        this._context = _context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setIsFirstTimeLaunch(boolean isFirstTimeLaunch) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTimeLaunch);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    //email
    public void setEmail(String email) {
        editor.putString(EMAIL, email);
        editor.commit();
    }

    public String getEmail() {
        return pref.getString(EMAIL, "");
    }

    //name
    public void setName(String name) {
        editor.putString(NAME, name);
        editor.commit();
    }

    public String getName() {
        return pref.getString(NAME, "");
    }

    //token
    public void setToken(String token) {
        editor.putString(TOKEN, token);
        editor.commit();
    }

    public String getToken() {
        return pref.getString(TOKEN, "");
    }

    //categoryId
    public void setCategoryId(int category_id) {
        editor.putInt(CATEGORY_ID, category_id);
        editor.commit();
    }

    public int getCategoryId() {
        return pref.getInt(CATEGORY_ID, 0);
    }

    //sourceId
    public void setSourceId(int source_id) {
        editor.putInt(SOURCE_ID, source_id);
        editor.commit();
    }

    public int getSourceId() {
        return pref.getInt(SOURCE_ID, 0);
    }

    //imageProfile
    public void setImageProfile(String image_profile) {
        editor.putString(IMAGE_PROFILE, image_profile);
        editor.commit();
    }

    public String getImageProfile() {
        return pref.getString(IMAGE_PROFILE, "");
    }

    //itemCount
    public void setItemCount(int item_count) {
        editor.putInt(ITEM_COUNT, item_count);
        editor.apply();
    }

    public int getItemCount() {
        return pref.getInt(ITEM_COUNT, 0);
    }

    //sortByShopciety
    public void setSortByShopciety(String sort_by_shopciety) {
        editor.putString(SORT_BY_SHOPCIETY, sort_by_shopciety);
        editor.apply();
    }

    public String getSortByShopciety() {
        return pref.getString(SORT_BY_SHOPCIETY, "");
    }

    //sortByAmazon
    public void setSortByAmazon(String sort_by_amazon) {
        editor.putString(SORT_BY_AMAZON, sort_by_amazon);
        editor.apply();
    }

    public String getSortByAmazon() {
        return pref.getString(SORT_BY_AMAZON, "");
    }

    //BottomSheetUrutan
    public void setSelect(String select) {
        editor.putString(SELECT, select);
        editor.commit();
    }

    public String getSelect() {
        return pref.getString(SELECT, "");
    }

    public void setSelectFilterCategory(int CategoryIDs) {
        editor.putInt(SELECT_FILTER_CATEGORY, CategoryIDs);
        editor.commit();
    }

    public int getSelectFilterCategory() {
        return pref.getInt(SELECT_FILTER_CATEGORY, 0);
    }

    public void setSelectFilterSource(int SourceIDs) {
        editor.putInt(SELECT_FILTER_SOURCE, SourceIDs);
        editor.commit();
    }

    public int getSelectedFilterSource() {
        return pref.getInt(SELECT_FILTER_SOURCE, 0);
    }

    //Response Content Fragment
    public void setContentFragment(Boolean responseCheckOutActivity) {
        editor.putBoolean(RESPONSE_CATEGORY_FRAGMENT, responseCheckOutActivity);
        editor.commit();
    }

    public Boolean getContentFragment() {
        return pref.getBoolean(RESPONSE_CATEGORY_FRAGMENT, true);
    }

    //Response Data Category Fragment
    public void setFectDataCategoryFragment(int position, String data) {
        if (position == 1){

            /*Response Data Shopciety*/
            editor.putString(RESPONSE_FECH_CATEGORY_DATA_SHOPCIETY, data);
            editor.commit();

        } else if (position == 2){

            /*Response Data Amazon*/
            editor.putString(RESPONSE_FECH_CATEGORY_DATA_AMAZON, data);
            editor.commit();

        } else if (position == 3){

            /*Response Data Carter*/
            editor.putString(RESPONSE_FECH_CATEGORY_DATA_CARTER, data);
            editor.commit();

        } else if (position == 4){

            /*Response Data Lego*/
            editor.putString(RESPONSE_FECH_CATEGORY_DATA_LEGO, data);
            editor.commit();

        } else if (position == 5){

            /*Response Data Macys*/
            editor.putString(RESPONSE_FECH_CATEGORY_DATA_MACYS, data);
            editor.commit();

        } else if (position == 6){

            /*Response Data Saks*/
            editor.putString(RESPONSE_FECH_CATEGORY_DATA_SAKS, data);
            editor.commit();

        } else if (position == 7){

            /*Response Data Target*/
            editor.putString(RESPONSE_FECH_CATEGORY_DATA_TARGET, data);
            editor.commit();

        } else if (position == 8){

            /*Response Data Validation Login*/
            editor.putString(CHECK_VALIDATION_LOGIN_CATEGORY, data);
            editor.commit();

        }
    }

    public String getFectDataCategoryShopciety() {
        return pref.getString(RESPONSE_FECH_CATEGORY_DATA_SHOPCIETY, "");
    }

    public String getFectDataCategoryAmazon() {
        return pref.getString(RESPONSE_FECH_CATEGORY_DATA_AMAZON, "");
    }

    public String getFectDataCategoryCarter() {
        return pref.getString(RESPONSE_FECH_CATEGORY_DATA_CARTER, "");
    }

    public String getFectDataCategoryLego() {
        return pref.getString(RESPONSE_FECH_CATEGORY_DATA_LEGO, "");
    }

    public String getFectDataCategoryMacys() {
        return pref.getString(RESPONSE_FECH_CATEGORY_DATA_MACYS, "");
    }

    public String getFectDataCategorySaks() {
        return pref.getString(RESPONSE_FECH_CATEGORY_DATA_SAKS, "");
    }

    public String getFectDataCategoryTarget() {
        return pref.getString(RESPONSE_FECH_CATEGORY_DATA_TARGET, "");
    }

    public String getCheckValidationLoginCategory() {
        return pref.getString(CHECK_VALIDATION_LOGIN_CATEGORY, "");
    }

}