package com.prestacukes.pages;

import com.prestacukes.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MedalTable {
    public MedalTable ( ) {
        PageFactory.initElements ( Driver.getDriver ( ) , this );
    }

    @FindBy ( xpath = "(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[2])[position()<11]" )
    public WebElement sortedGoldMedals;

    @FindBy ( xpath = "(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[3])[position()<11]" )
    public WebElement sortedSilverMedals;

    @FindBy ( xpath = "(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[4])[position()<11]" )
    public WebElement sortedBronzeMedals;

    @FindBy ( xpath = "(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[1])[position()<11]" )
    public WebElement sortedRanks;

    @FindBy ( xpath = "(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/td[5])[position()<11]" )
    public WebElement sortedCountryTotals;

    @FindBy ( xpath = "(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th[1])[position()<11]" )
    public WebElement sortedCountries;

    @FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/thead/tr/th[1]")
    public WebElement rank;

    @FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/thead/tr/th[2]")
    public WebElement countries;

    @FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/thead/tr/th[3]")
    public WebElement gold;

    @FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/thead/tr/th[4]")
    public WebElement silver;

    @FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/thead/tr/th[5]")
    public WebElement bronze;

    @FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/thead/tr/th[6]")
    public WebElement total;



}
