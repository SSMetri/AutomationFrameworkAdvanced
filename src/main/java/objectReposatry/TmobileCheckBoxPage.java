package objectReposatry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TmobileCheckBoxPage {
    @FindBy(xpath="//label[@for='mat-checkbox-10-input']//span[@class='mat-checkbox-inner-container']")
    private WebElement apple;
    
    @FindBy(xpath="//label[@for='mat-checkbox-11-input']//span[@class='mat-checkbox-inner-container']")
    private WebElement google;
    
    @FindBy(xpath="//label[@for='mat-checkbox-12-input']//span[@class='mat-checkbox-inner-container']")
    private WebElement motorola;
    
    @FindBy(xpath="//label[@for='mat-checkbox-13-input']//span[@class='mat-checkbox-inner-container']")
    private WebElement nokia;
    
    @FindBy(xpath="//label[@for='mat-checkbox-14-input']//span[@class='mat-checkbox-inner-container']")
    private WebElement onePlus;
    
    @FindBy(xpath="//label[@for='mat-checkbox-15-input']//span[@class='mat-checkbox-inner-container']")
    private WebElement samsung; // Corrected name
    
    @FindBy(xpath="//label[@for='mat-checkbox-16-input']//span[@class='mat-checkbox-inner-container']")
    private WebElement sonim;
    
    @FindBy(xpath="//label[@for='mat-checkbox-17-input']//span[@class='mat-checkbox-inner-container']")
    private WebElement tMobile;
    
    @FindBy(xpath="//label[@for='mat-checkbox-18-input']//span[@class='mat-checkbox-inner-container']")
    private WebElement tcl;

    public TmobileCheckBoxPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectCheckBoxes(String... checkBoxNames) {
        if (checkBoxNames.length == 1 && checkBoxNames[0].equals("all")) {
            selectAllCheckBoxes();
        } else {
            for (String checkBoxName : checkBoxNames) {
                selectCheckBox(checkBoxName);
            }
        }
    }

    public void selectCheckBox(String checkBoxName) {
        WebElement checkbox = getCheckbox(checkBoxName);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
        System.out.println("Selected checkbox: " + checkBoxName);
    }

    public void selectAllCheckBoxes() {
        selectCheckBox("apple");
        selectCheckBox("google");
        selectCheckBox("motorola");
        selectCheckBox("nokia");
        selectCheckBox("onePlus");
        selectCheckBox("samsung");
        selectCheckBox("sonim");
        selectCheckBox("tMobile");
        selectCheckBox("tcl");
        System.out.println("Selected all checkboxes");
    }

    private WebElement getCheckbox(String checkBoxName) {
        switch (checkBoxName) {
            case "apple":
                return apple;
            case "google":
                return google;
            case "motorola":
                return motorola;
            case "nokia":
                return nokia;
            case "onePlus":
                return onePlus;
            case "samsung":
                return samsung;
            case "sonim":
                return sonim;
            case "tMobile":
                return tMobile;
            case "tcl":
                return tcl;
            default:
                throw new IllegalArgumentException("Invalid checkbox name: " + checkBoxName);
        }
    }
}

