package feature;

import Enums.WorkOrderPriority;
import pages.HomePage;
import pages.WorkOrderPage;

public class WorkOrderFeature {

    WorkOrderPage workOrderPage;

     public void createWorkOrder(String workOrderTitle, String workOrderDesc, WorkOrderPriority workOrderPriority){
         WorkOrderPage workOrderPage = new WorkOrderPage();
         workOrderPage
                 .clickOnWorkOrderBtn()
                 .enterWorkOrderTitle(workOrderTitle)
                 .enterWorkOrderDesc(workOrderDesc)
                 .selectWorkOrderPriority(workOrderPriority)
                 .clickOnSaveWorkOrder();
     }



}
