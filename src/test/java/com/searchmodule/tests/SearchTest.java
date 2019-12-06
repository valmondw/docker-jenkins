package com.searchmodule.tests;

import com.searchmodule.pages.SearchPage;
import com.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

public class SearchTest extends BaseTest {



    @Test
    @Parameters({"keyword"})
    public void search(String keyword){
        SearchPage searchPage = new SearchPage(driver);
        searchPage.gotoDuckHomePage()
                  .doSearch(keyword)
                  .gotoVideos();
        int size = searchPage.getResult();
        Assert.assertTrue(size > 0);
    }





}//CLASS
