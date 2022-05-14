package pages;

import Enums.WorkOrderPriority;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import utils.BaseTest;

public class WorkOrderPage extends BaseTest {

//    @AndroidFindBy(id="action_item_create_work_order")
    @AndroidFindBy(xpath = "//*[@text='Work Order']")
    private WebElement createWorkOrderBtn;

    @AndroidFindBy(id="work_order_title")
    private WebElement workOrderTitle;

    @AndroidFindBy(id="additional_notes")
    private WebElement workOrderDesc;

    @AndroidFindBy(id="none")
    private WebElement nonePriority;

    @AndroidFindBy(id="one")
    private WebElement lowPriority;

    @AndroidFindBy(id="two")
    private WebElement mediumPriority;

    @AndroidFindBy(id="three")
    private WebElement highPriority;

    @AndroidFindBy(id="save")
    private WebElement saveWorkOrderBtn;

    public WorkOrderPage clickOnWorkOrderBtn(){
        click(createWorkOrderBtn);
        return this;
    }

    public WorkOrderPage enterWorkOrderTitle(String workOrderTitleStr){
//        workOrderTitle.click();
//        workOrderTitle.sendKeys(workOrderTitleStr);
        click(workOrderTitle);
        sendKeys(workOrderTitle,workOrderTitleStr);
        return this;
    }
    public WorkOrderPage enterWorkOrderDesc(String workOrderDescStr){
        click(workOrderDesc);
        sendKeys(workOrderDesc,workOrderDescStr);
        return this;
    }

    public WorkOrderPage selectWorkOrderPriority(WorkOrderPriority workOrderPriorityEnum){
        switch (workOrderPriorityEnum){
            case LOW:
                click(lowPriority);
                break;
            case MEDIUM:
                click(mediumPriority);
                break;
            case HIGH:
                click(highPriority);
                break;
            default:
                click(nonePriority);
                break;
        }

        return this;
    }

    public WorkOrderPage clickOnSaveWorkOrder(){
        click(saveWorkOrderBtn);
        return this;
    }

}
