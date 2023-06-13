package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class Project3Page {
    public Project3Page(){ PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(css = ".ml-0")
    public WebElement oneWayButtonLabel;

    @FindBy(xpath = "//input[@value='One way']")
    public WebElement oneWayButtonInput;

    @FindBy(xpath = "//div[@class='is-flex']/label[1]")
    public WebElement roundTripButtonLabel;

    @FindBy(xpath = "//input[@value='Round trip']")
    public WebElement roundTripButtonInput;

    @FindBy(xpath = "//label[text()='Cabin Class']")
    public WebElement cabinClassLabel;

    @FindBy(xpath = "//option[text()='Select cabin class...']/..")
    public WebElement cabinClassDropdown;

    @FindBy(xpath = "//label[text()='From']")
    public WebElement fromLabel;

    @FindBy(xpath = "//label[text()='From']/../div/select")
    public WebElement fromDropdown;

    @FindBy(xpath = "//label[text()='To']")
    public WebElement toLabel;

    @FindBy(xpath = "//label[text()='To']/../div/select")
    public WebElement toDropdown;

    @FindBy(xpath = "//label[text()='Depart']")
    public WebElement departLabel;

    @FindBy(xpath = "//label[text()='Depart']/../div")
    public WebElement datePicker;

    @FindBy(name = "month")
    public WebElement datePickerMonth;

    @FindBy(name = "day")
    public WebElement datePickerDay;

    @FindBy(name = "year")
    public WebElement datePickerYear;

    @FindBy(xpath = "//label[text()='Return']")
    public WebElement returnLabel;

    @FindBy(xpath = "//label[text()='Return']/../div")
    public WebElement returnDatePicker;

    @FindBy(xpath = "//label[text()='Number of passengers']")
    public WebElement numberOfPassengerLabel;

    @FindBy(xpath = "//label[text()='Number of passengers']/../div")
    public WebElement passengerDropdown;
}
