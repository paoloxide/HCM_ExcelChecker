package hcm.tests;

import org.testng.annotations.Test;

import common.BaseTest;
import hcm.pageobjects.FuseWelcomePage;
import hcm.pageobjects.LoginPage;
import hcm.pageobjects.TaskListManagerTopPage;
import static util.ReportLogger.log;
import static util.ReportLogger.logFailure;

import static common.ExcelUtilities.getCellData;

public class ExcelFileValidation extends BaseTest{
	
	@Test
	public void a_test() throws Exception  {
		testReportFormat();
	
	try{
		validateExcelFile();
	  
	  	}
	
        catch (AssertionError ae)
        {
            //takeScreenshot();
            logFailure(ae.getMessage());

            throw ae;
        }
        catch (Exception e)
        {
            //takeScreenshot();
            logFailure(e.getMessage());

            throw e;
        }
    }

	public void validateExcelFile() throws Exception{
		
		boolean isScrollingDown = true;
		boolean isNowClickable = false;
		boolean hasSetMainTask = false;
			
		LoginPage login = new LoginPage(driver);
		//takeScreenshot();
		//login.enterUserID(5);
		//login.enterPassword(6);
		//login.clickSignInButton();
		
		//FuseWelcomePage welcome = new FuseWelcomePage(driver);
		//takeScreenshot();
		//welcome.clickNavigator("More...");
		//clickNavigationLink("Setup and Maintenance");
			
		//TaskListManagerTopPage task = new TaskListManagerTopPage(driver);
		//takeScreenshot();
		
		//task.clickTask("Configure Offerings");
		//Thread.sleep(1500);//3000
		//takeScreenshot();
			
		//Enable task
		int mainTask = 7;
		int mainStatus = 8;
		int subTask = 9;
		int status = 10;
		String mainRef = "afrrk";
		String subRef = "afrap";
		String mainTaskCommonPath, subTaskCommonPath;
		String[][] mainTaskAttrHolder = {};
		int excelEntryCounter = -1;
		boolean hasNextExcelEntry = true;
		//NOTE: Use afrrk to identify a mainTask, succeeding subfolder use as afrap;;
		
		//Identifying referenceID for the Task group;;
		/*task.waitForElementToBeClickable(60, mainTask, subTask, "//table/tbody/tr/td/a/img[contains(@title,'View') or contains(@title, 'Feature')]");
		mainTaskAttrHolder = task.queryAllTaskMainFolders();
		
		for(int i = 0 ; i <mainTaskAttrHolder.length ;i++){
			mainTaskCommonPath = "//tr[@_"+mainRef+"='"+(String)mainTaskAttrHolder[i][1]+ "']/td/div/table/tbody/tr/td/div[text()='"+getExcelData(mainTask)+"']";
			if(is_element_visible(mainTaskCommonPath+"/span/a[contains(@title,'Collapse')]", "xpath")){
				task.clickCollapseFolder(mainTaskCommonPath);
			}
		}*/
		
		String[] validEntries = { 	
				"Coexistence for HCM", "Compensation Management", "Workforce Profiles", "Benefits", "Individual Compensation", "Workforce Compensation", "Total Compensation Statements", "Absence Management", "Human Resources Business Intelligence Analytics", "Absence and Accrual Business Intelligence Analytics", "Payroll Business Intelligence Analytics", "Workforce Effectiveness Business Intelligence Analytics", "Workforce Deployment Business Intelligence Analytics", "Customer Data Management", "Enterprise Contracts", "Financials", "Fusion Accounting Hub", "Grants Management", "Incentive Compensation", "Marketing", "Materials Management and Logistics", "Order Orchestration", "Procurement", "Product Management", "Project Execution Management", "Project Financial Management", "Risk and Controls", "Sales", "Supply Chain Financial Orchestration", "Supply Chain Managerial Accounting",
				"Procurement Contracts", "Sales Contracts",
				"Financials", "Supplier Invoice Processing", "Expenses", "Fixed Assets", "Customer Invoice Processing", "Collections", "Revenue Management", "Intercompany", "Budgetary Control and Encumbrance Accounting", "Financial Business Intelligence Analytics", "Profitability Business Intelligence Analytics", "Fixed Assets Business Intelligence Analytics", "General Ledger Business Intelligence Analytics", "Accounts Payable Business Intelligence Analytics", "Employee Expenses Business Intelligence Analytics", "Intrastat Reporting",
				"Fusion Accounting Hub", "Accounting Coexistence", "Intercompany",
				"Grants Management", "Project Integration Gateway", "Capital Projects", "Internal Project Billing", "Transaction Tax", "Project Performance Reporting",
				"Incentive Compensation",
				"Marketing", "E-mail Server for Marketing", "Lead Management", "Segmentation Server for Marketing", "Marketing Business Intelligence Analytics", "Leads Business Intelligence Analytics", "Marketing Planning Business Intelligence Analytics", "Opportunity Landscape Business Intelligence Analytics", "Sales Prediction Engine Business Intelligence Analytics", "Sales Catalog", "Data Import and Export",
				"Materials Management and Logistics", "Supply Chain and Order Management Business Intelligence Analytics", "Order Management Business Intelligence Analytics", "Logistics Business Intelligence Analytics", "Shipping", "Receiving", 
				"Order Orchestration", 
				"Procurement", "Self Service Procurement", "Supplier Portal", "Sourcing", "Supplier Qualification", "Procurement Contracts", "Supplier Invoice Processing", "Procurement and Spend Business Intelligence Analytics", "Sourcing Business Intelligence Analytics", "Procurement Business Intelligence Analytics",
				"Product Management", "Item and Catalog Management", "Inventory Organizations", "Catalogs", "Structures", "Suppliers for Product Management", "Item Mass Update", "Advanced Catalogs", "Data Governance", "New Item Requests", "Change Orders", "Product Rules", "Data Quality Rules for Products", "Audit Trail", "Data Consolidation", "Product Spoke Systems", "Item Batches", "Data Pool Integration", "Data Quality for Products", "Supplier Collaboration", "Supplier Portal", "Configurator", "Configurator Modeling Environment", "Product Development", "Change Orders", "Product Development Configuration", "Product Requirements and Ideation Management", "Concept Design Management", "Product Lifecycle Portfolio Management", "Product Management Business Intelligence Analytics",
				"Project Resource Management",
				"Project Financial Management", "Burdening", "Project Control", "Project Integration Gateway", "Project Costing", "Capital Projects", "Project Billing", "Internal Project Billing", "Transaction Tax", "Project Performance Reporting", "Project Business Intelligence Analytics", "Project Revenue and Billing Business Intelligence Analytics", "Project Performance Business Intelligence Analytics", "Project Control and Costing Business Intelligence Analytics", "Risk and Controls",
				"Sales", "Sales Prediction Engine", "Outlook Integration", "Quotas", "References", "Competitors", "Sales Forecasting", "Partners", "Partner Business Intelligence Analytics", "Partner Performance", "Partner Deals", "Partner Programs", "Territory Management", "Sales Business Intelligence Analytics", "Quota Management Business Intelligence Analytics", "Territory Management Business Intelligence Analytics", "Opportunity and Revenue Management Business Intelligence Analytics", "Customer Interactions Management", "Leads Business Intelligence Analytics", "Opportunity Landscape Business Intelligence Analytics", "Sales Prediction Engine Business Intelligence Analytics", "Sales Forecasting Management Business Intelligence Analytics", "Basic Catalogs", "Sales Cloud Integration", "Supply Chain Financial Orchestration",
				"Supply Chain Managerial Accounting", "Receipt Accounting", "Cost Accounting", "Cost and Profit Planning",
				"Workforce Deployment", "Payroll", "Absence Management", "Workforce Scheduling", "Workforce Predictions", "Individual Compensation", "Time and Labor", "Workforce Profiles", "Network at Work", "Workforce Management", "Human Resources Business Intelligence Analytics", "Absence and Accrual Business Intelligence Analytics", "Payroll Business Intelligence Analytics", "Workforce Effectiveness Business Intelligence Analytics", "Workforce Deployment Business Intelligence Analytics",
				"Workforce Development", "Worker Goal Setting", "Career Development", "Questionnaires", "Worker Performance", "Talent Review", "Succession Management", "Human Resources Business Intelligence Analytics", "Absence and Accrual Business Intelligence Analytics", "Payroll Business Intelligence Analytics", "Workforce Effectiveness Business Intelligence Analytics", "Workforce Deployment Business Intelligence Analytics",
				"Data Quality", "Data Quality Matching", "Data Quality Cleansing", "Customer Hub", "Customer Data Management Business Intelligence Analytics",
				"In Progress", "Implemented", "Not Started"
		};
		
		for(int rowNum = 2; rowNum <=21; rowNum++){
				excelEntryloop:
				for(int colNum = 7; (hasNextExcelEntry) ; colNum++){
					
					String excelEntry = (String)getExcelData(rowNum, colNum);
					System.out.println("Entry No: \nFilled excelEntry...."+excelEntry);

					if(getExcelData(rowNum, colNum).length() <= 0 && getExcelData(rowNum, colNum+1).length() > 0 ){
						log(excelEntry+" is an invalid entry!!!\n;");
						System.out.println(excelEntry+" is an invalid entry!!!\n");
						throw new IllegalArgumentException();
					}else if(getExcelData(rowNum, colNum).length() <= 0){
						 break excelEntryloop;
					}

					arrayEntryloop:
					for(int arrayInt = 0; arrayInt < validEntries.length+2; arrayInt++){
						String arrayEntry = (String)validEntries[arrayInt];
						System.out.println("Filled arrayEntry...."+arrayEntry);
						System.out.println(arrayEntry+" vs. "+excelEntry);
						if(arrayEntry.equals(excelEntry) && !excelEntry.equals("")){
							System.out.println(excelEntry+" is found to be valid...");
							break arrayEntryloop;
						}

						System.out.println(arrayInt+" vs. "+validEntries.length);
						if((int)arrayInt+1 >= (int)validEntries.length){
							log(excelEntry+" is an invalid entry!!!\n;");
							System.out.println(excelEntry+" is an invalid entry!!!\n");
							throw new IllegalArgumentException();
						}
					}
				}
		}
		
		//Ending message::
				Thread.sleep(1000);//1000
				//takeScreenshot();
				
				//task.clickSaveAndCloseButton();
				
				System.out.println("Configuration Completed\n***************\n");
				log("Configuration Completed");
				
				Thread.sleep(1500);//3000
				//takeScreenshot();
	}
}
