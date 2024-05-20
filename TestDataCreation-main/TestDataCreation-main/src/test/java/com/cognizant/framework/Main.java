package com.cognizant.framework;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.VGs.BusinessFlow;

public class Main {

	public JFrame testdata;
	public static String testcasename;
	public static String itr;
	public static String applicationname;
	public static int index;
	public JComboBox<String> SFTypes;

	public Font LF8;
	public JButton path;

	public JComboBox<String> VGDropDown;
	public JComboBox<String> IterationDropDown;
	public JComboBox<String> EnvDropDown;
	public JComboBox<String> ApplicationDropDown;

	public static String ResultsFile;
	static BusinessFlow VG = new BusinessFlow();
	static ExtentReport ext = new ExtentReport();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.testdata.setVisible(true);
					;
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		});
	}

	public Main() {
		initialize();
	}

	private void initialize() {
		testdata = new JFrame();
		testdata.getContentPane().setBackground(new Color(176, 196, 222));
		testdata.setTitle("VG Test Data Creation tool");
		testdata.setBounds(100, 100, 800, 400);
		testdata.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testdata.getContentPane().setLayout(null);

		JLabel VG = new JLabel("Select VG to create test data :");
		LF8 = new Font(VG.getFont().getName(), Font.BOLD, 20);
		VG.setFont(LF8);
		VG.setBounds(50, 50, 300, 23);
		testdata.add(VG);
		VGDropDown = new JComboBox<String>();
		VGDropDown.setBounds(360, 50, 300, 23);
		VGDropDown.addItem("VGC");
		VGDropDown.addItem("VG11");
		VGDropDown.addItem("VG14");
		VGDropDown.addItem("VG11_2SIMO");
		VGDropDown.addItem("VG10");
		VGDropDown.addItem("VG7");
		VGDropDown.addItem("VG11_U");
		VGDropDown.addItem("VG14_U");
		VGDropDown.addItem("VG25");
		VGDropDown.addItem("VG26");
		VGDropDown.addItem("VG76.1");
		VGDropDown.addItem("VG11_MBB");
		VGDropDown.addItem("VG55");
		VGDropDown.addItem("VG13");
		VGDropDown.addItem("VG55_5GBolton");
		VGDropDown.addItem("VG_11_SIMO_Order_Broadband");
		VGDropDown.addItem("VG3");
		VGDropDown.addItem("VG1");
		VGDropDown.addItem("VG84");
		VGDropDown.addItem("VG24");
		VGDropDown.addItem("VG45");
		VGDropDown.addItem("VG46");
		VGDropDown.addItem("BroadbandOrder");
//		

		JLabel iteration = new JLabel("Select no. of iterations :");
		LF8 = new Font(iteration.getFont().getName(), Font.BOLD, 20);
		iteration.setFont(LF8);
		iteration.setBounds(50, 100, 300, 23);
		testdata.add(iteration);
		IterationDropDown = new JComboBox<String>();
		IterationDropDown.setBounds(360, 100, 300, 23);
		IterationDropDown.addItem("1");
		IterationDropDown.addItem("2");
		IterationDropDown.addItem("3");
		IterationDropDown.addItem("4");
		IterationDropDown.addItem("5");
		IterationDropDown.addItem("6");
		IterationDropDown.addItem("7");
		IterationDropDown.addItem("8");
		IterationDropDown.addItem("9");
		IterationDropDown.addItem("10");

		JLabel env = new JLabel("Select Environment :");
		LF8 = new Font(iteration.getFont().getName(), Font.BOLD, 20);
		env.setFont(LF8);
		env.setBounds(50, 150, 300, 23);
		testdata.add(env);
		EnvDropDown = new JComboBox<String>();
		EnvDropDown.setBounds(360, 150, 300, 23);
		EnvDropDown.addItem("E2E1");
		EnvDropDown.addItem("E2E2");
		EnvDropDown.addItem("E2E3");
		EnvDropDown.addItem("UAT");

		JLabel application = new JLabel("Select Application :");
		LF8 = new Font(application.getFont().getName(), Font.BOLD, 20);
		application.setFont(LF8);
		application.setBounds(50, 200, 300, 23);
		testdata.add(application);
		ApplicationDropDown = new JComboBox<String>();
		ApplicationDropDown.setBounds(360, 200, 300, 23);
		ApplicationDropDown.addItem("CSRD");
		ApplicationDropDown.addItem("ECOM");

		testdata.add(VGDropDown);
		testdata.add(IterationDropDown);
		testdata.add(EnvDropDown);
		testdata.add(ApplicationDropDown);

		final JButton btn = new JButton("Create Test Data");
		Font LF10 = new Font(btn.getFont().getName(), Font.BOLD, 15);
		btn.setFont(LF10);
		btn.setBounds(250, 260, 180, 50);
		testdata.getContentPane().add(btn);

		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					Main.this.TestData();
					btn.setEnabled(true);
					Thread.sleep(2000);
				} catch (Exception e1) {
					e1.printStackTrace();

				}

			}
		});

	}

	protected void TestData() throws NumberFormatException, Exception {

		testcasename = (String) VGDropDown.getSelectedItem();
		itr = (String) IterationDropDown.getSelectedItem();

		applicationname = (String) ApplicationDropDown.getSelectedItem();
		if (testcasename.equals("VG11") && applicationname.equals("CSRD")) {
			VG11(Integer.parseInt(itr), (String) EnvDropDown.getSelectedItem(),
					(String) ApplicationDropDown.getSelectedItem());
		} else if (testcasename.equals("VGC") && applicationname.equals("CSRD")) {
			VGC(Integer.parseInt(itr), (String) EnvDropDown.getSelectedItem(),
					(String) ApplicationDropDown.getSelectedItem());
		} else if (testcasename.equals("VG11_2SIMO") && applicationname.equals("CSRD")) {
			VG112SIMO(Integer.parseInt(itr), (String) EnvDropDown.getSelectedItem(),
					(String) ApplicationDropDown.getSelectedItem());
		} else if (testcasename.equals("VG7") && applicationname.equals("CSRD")) {
			VG7(Integer.parseInt(itr), (String) EnvDropDown.getSelectedItem(),
					(String) ApplicationDropDown.getSelectedItem());
		} else if (testcasename.equals("VG11_U") && applicationname.equals("CSRD")) {
			VG11U(Integer.parseInt(itr), (String) EnvDropDown.getSelectedItem(),
					(String) ApplicationDropDown.getSelectedItem());
		} else if (testcasename.equals("VG11_MBB") && applicationname.equals("CSRD")) {
			VG11_MBB(Integer.parseInt(itr), (String) EnvDropDown.getSelectedItem(),
					(String) ApplicationDropDown.getSelectedItem());
		} else if (testcasename.equals("VG55") && applicationname.equals("CSRD")) {
			VG55(Integer.parseInt(itr), (String) EnvDropDown.getSelectedItem(),
					(String) ApplicationDropDown.getSelectedItem());
		} else if (testcasename.equals("VG10") && applicationname.equals("CSRD")) {
			VG10(Integer.parseInt(itr), (String) EnvDropDown.getSelectedItem(),
					(String) ApplicationDropDown.getSelectedItem());
		} else if (testcasename.equals("VG14") && applicationname.equals("CSRD")) {
			VG14(Integer.parseInt(itr), (String) EnvDropDown.getSelectedItem(),
					(String) ApplicationDropDown.getSelectedItem());
		} else if (testcasename.equals("VG14") && applicationname.equals("ECOM")) {
			VG14_Ecommerce(Integer.parseInt(itr), (String) EnvDropDown.getSelectedItem(),
					(String) ApplicationDropDown.getSelectedItem());
		}else if (testcasename.equals("VG14_U") && applicationname.equals("CSRD")) {
			VG14_U(Integer.parseInt(itr), (String) EnvDropDown.getSelectedItem(),
					(String) ApplicationDropDown.getSelectedItem());
		} else if (testcasename.equals("VG25") && applicationname.equals("CSRD")) {
			VG25(Integer.parseInt(itr), (String) EnvDropDown.getSelectedItem(),
					(String) ApplicationDropDown.getSelectedItem());
		} else if (testcasename.equals("VG26") && applicationname.equals("CSRD")) {
			VG26(Integer.parseInt(itr), (String) EnvDropDown.getSelectedItem(),
					(String) ApplicationDropDown.getSelectedItem());
		} else if (testcasename.equals("VG76.1") && applicationname.equals("CSRD")) {
			VG76_1(Integer.parseInt(itr), (String) EnvDropDown.getSelectedItem(),
					(String) ApplicationDropDown.getSelectedItem());
		} else if (testcasename.equals("VG_11_SIMO_Order_Broadband") && applicationname.equals("CSRD")) {
			VG_11_SIMO_Order_Broadband(Integer.parseInt(itr), (String) EnvDropDown.getSelectedItem(),
					(String) ApplicationDropDown.getSelectedItem());
		} else if (testcasename.equals("BroadbandOrder") && applicationname.equals("CSRD")) {
			BroadbandOrder(Integer.parseInt(itr), (String) EnvDropDown.getSelectedItem(),
					(String) ApplicationDropDown.getSelectedItem());
		} else if (testcasename.equals("VG11") && applicationname.equals("ECOM")) {
			VG11_Ecommerce(Integer.parseInt(itr), (String) EnvDropDown.getSelectedItem(),
					(String) ApplicationDropDown.getSelectedItem());
		} else if (testcasename.equals("VG13") && applicationname.equals("CSRD")) {
			VG13(Integer.parseInt(itr), (String) EnvDropDown.getSelectedItem(),
					(String) ApplicationDropDown.getSelectedItem());
		} else if (testcasename.equals("VG55_5GBolton") && applicationname.equals("CSRD")) {
			VG55_5GBolton(Integer.parseInt(itr), (String) EnvDropDown.getSelectedItem(),
					(String) ApplicationDropDown.getSelectedItem());
		} else if (testcasename.equals("VG3") && applicationname.equals("CSRD")) {
			VG3(Integer.parseInt(itr), (String) EnvDropDown.getSelectedItem(),
					(String) ApplicationDropDown.getSelectedItem());
		} else if (testcasename.equals("VG1") && applicationname.equals("CSRD")) {
			VG1(Integer.parseInt(itr), (String) EnvDropDown.getSelectedItem(),
					(String) ApplicationDropDown.getSelectedItem());
		} else if (testcasename.equals("VG84") && applicationname.equals("CSRD")) {
			VG84(Integer.parseInt(itr), (String) EnvDropDown.getSelectedItem(),
					(String) ApplicationDropDown.getSelectedItem());
		} else if (testcasename.equals("VG24") && applicationname.equals("CSRD")) {
			VG24(Integer.parseInt(itr), (String) EnvDropDown.getSelectedItem(),
					(String) ApplicationDropDown.getSelectedItem());
		} else if (testcasename.equals("VG45") && applicationname.equals("CSRD")) {
			VG45(Integer.parseInt(itr), (String) EnvDropDown.getSelectedItem(),
					(String) ApplicationDropDown.getSelectedItem());
		}else if (testcasename.equals("VG46") && applicationname.equals("CSRD")) {
			VG46(Integer.parseInt(itr), (String) EnvDropDown.getSelectedItem(),
					(String) ApplicationDropDown.getSelectedItem());
		}
	}

	// New RCA Customer through CSRD
	public static void VGC(int iteration, String env, String app) throws Exception {

		for (int curriteration = 1; curriteration <= iteration; curriteration++) {

			System.out.println("Current iteration:" + curriteration);
			try {

				ext.startReport();

				ExtentReport.createTest("VGC", "Creating Residental Customer");
				VG.invokeBrowser(env, app);
				VG.VGC_CSRD(curriteration, iteration);
				VG.quit();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ext.tearDown();
			}
		}

	}

	// New RCA Customer with SIMO Plan through CSRD
	public static void VG11(int iteration, String env, String app) throws Exception {
		for (int curriteration = 1; curriteration <= iteration; curriteration++) {
			System.out.println("Current iteration:" + curriteration);
			try {

				ext.startReport();
				ExtentReport.createTest("VG11", "Creating Residental Customer with SIMO Plan");
				VG.invokeBrowser(env, app);
				VG.VG11_CSRD(curriteration, iteration);
				VG.quit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ext.tearDown();
			}

		}

	}

	// New RCA Customer with 2 SIMO Plans associated to one billing account Plan
	// through CSRD
	public static void VG112SIMO(int iteration, String env, String app) throws Exception {
		for (int curriteration = 1; curriteration <= iteration; curriteration++) {
			System.out.println("Current iteration:" + curriteration);
			try {
				ext.startReport();
				ExtentReport.createTest("VG11_2SIMO",
						"Creating Residental Customer with 2 SIMO Plans associated to one billing account");
				VG.invokeBrowser(env, app);
				VG.VG112SIMO_CSRD(curriteration, iteration);
				VG.quit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ext.tearDown();
			}

		}

	}

	// New RCA Customer with SIMO Plan and cafeyn extra through CSRD
	public static void VG7(int iteration, String env, String app) throws Exception {
		for (int curriteration = 1; curriteration <= iteration; curriteration++) {
			System.out.println("Current iteration:" + curriteration);
			try {
				ext.startReport();
				ExtentReport.createTest("VG7", "Creating Residental Customer with SIMO Plan and cafeyn extra");
				VG.invokeBrowser(env, app);
				VG.VG7_CSRD(curriteration, iteration);
				VG.quit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ext.tearDown();
			}

		}

	}

	// New RCA Customer with Ultimate SIMO Plan through CSRD
	public static void VG11U(int iteration, String env, String app) throws Exception {
		for (int curriteration = 1; curriteration <= iteration; curriteration++) {
			System.out.println("Current iteration:" + curriteration);
			try {

				ext.startReport();
				ExtentReport.createTest("V11_U", "Creating Residental Customer with Utlimate SIMO Plan");
				VG.invokeBrowser(env, app);
				VG.VG11U_CSRD(curriteration, iteration);
				VG.quit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ext.tearDown();
			}

		}

	}

	// New RCA Customer with SIMO Data Plan Only through CSRD
	public static void VG11_MBB(int iteration, String env, String app) throws Exception {
		for (int curriteration = 1; curriteration <= iteration; curriteration++) {
			System.out.println("Current iteration:" + curriteration);
			try {

				ext.startReport();
				ExtentReport.createTest("VG11_MBB", "Creating Residental Customer with SIMO Data Plan Only");
				VG.invokeBrowser(env, app);
				VG.VG11MBB_CSRD(curriteration, iteration);
				VG.quit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ext.tearDown();
			}

		}

	}

	// New RCA Customer with Sim Free Financing through CSRD
	public static void VG55(int iteration, String env, String app) throws Exception {
		for (int curriteration = 1; curriteration <= iteration; curriteration++) {
			System.out.println("Current iteration:" + curriteration);
			try {

				ext.startReport();
				ExtentReport.createTest("VG55", "Creating Residental Customer with Sim Free Financing");
				VG.invokeBrowser(env, app);
				VG.VG55_CSRD(curriteration, iteration);
				VG.quit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ext.tearDown();
			}

		}

	}

	public static void VG14(int iteration, String env, String app) throws Exception {

		for (int curriteration = 1; curriteration <= iteration; curriteration++) {
			System.out.println("Current iteration:" + curriteration);
			try {
				ext.startReport();
				ExtentReport.createTest("VG14", "Creating Residental Customer with Custom Plan");
				VG.invokeBrowser(env, app);
				VG.VG14_CSRD(curriteration, iteration);
				VG.quit();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ext.tearDown();
			}
		}

	}

	public static void VG14_U(int iteration, String env, String app) throws Exception {

		for (int curriteration = 1; curriteration <= iteration; curriteration++) {
			System.out.println("Current iteration:" + curriteration);
			try {
				ext.startReport();
				ExtentReport.createTest("VG14_U", "Creating Residental Customer with Ultimate Custom with CCA plan");
				VG.invokeBrowser(env, app);
				VG.VG14_U_CSRD(curriteration, iteration);
				VG.quit();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ext.tearDown();
			}
		}

	}

	public static void VG10(int iteration, String env, String app) throws Exception {

		for (int curriteration = 1; curriteration <= iteration; curriteration++) {

			System.out.println("Current iteration:" + curriteration);
			try {
				ext.startReport();
				ExtentReport.createTest("VG10", "Creating Residental Customer with Standard Plan");
				VG.invokeBrowser(env, app);
				VG.VG10_CSRD(curriteration, iteration);
				VG.quit();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ext.tearDown();
			}
		}

	}

	public static void VG25(int iteration, String env, String app) throws Exception {

		for (int curriteration = 1; curriteration <= iteration; curriteration++) {
			System.out.println("Current iteration:" + curriteration);
			try {
				ext.startReport();
				ExtentReport.createTest("VG25",
						"Creating Residental Customer with Custom Plan Disney,Amazon Prime Video+ and O2 damage cover");
				VG.invokeBrowser(env, app);
				VG.VG25_CSRD(curriteration, iteration);
				VG.quit();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ext.tearDown();
			}
		}

	}

	public static void VG26(int iteration, String env, String app) throws Exception {

		for (int curriteration = 1; curriteration <= iteration; curriteration++) {
			System.out.println("Current iteration:" + curriteration);
			try {
				ext.startReport();
				ExtentReport.createTest("VG26", "Creating Residental Customer with Custom plan with CCA + Companion");
				VG.invokeBrowser(env, app);
				VG.VG26_CSRD(curriteration, iteration);
				VG.quit();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ext.tearDown();
			}
		}

	}

	public static void VG76_1(int iteration, String env, String app) throws Exception {
		for (int curriteration = 1; curriteration <= iteration; curriteration++) {
			System.out.println("Current iteration:" + curriteration);
			try {
				ext.startReport();
				ExtentReport.createTest("VG76.1", "Creating Residental Customer with Custom plan with CCA *2");
				VG.invokeBrowser(env, app);
				VG.VG76_1_CSRD(curriteration, iteration);
				VG.quit();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ext.tearDown();
			}
		}

	}

	public static void VG_11_SIMO_Order_Broadband(int iteration, String env, String app) throws Exception {
		for (int curriteration = 1; curriteration <= iteration; curriteration++) {
			System.out.println("Current iteration:" + curriteration);
			try {
				ext.startReport();
				ExtentReport.createTest("VG11",
						"Creating Residental Customer with customer premise address details and placing a SIMO order");
				VG.invokeBrowser(env, app);
				VG.VG_11_SIMO_Order_Broadband_CSRD(curriteration, iteration);
				VG.quit();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ext.tearDown();
			}
		}

	}

	public static void BroadbandOrder(int iteration, String env, String app) throws Exception {
		for (int curriteration = 1; curriteration <= iteration; curriteration++) {
			System.out.println("Current iteration:" + curriteration);
			try {
				ext.startReport();
				ExtentReport.createTest("Broadband", "Placing a broadband order");
				VG.invokeBrowser(env, app);
				VG.BroadbandOrder_CSRD(curriteration, iteration);
				VG.quit();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ext.tearDown();
			}
		}

	}

	// New Residential Customer with Custom Plan with CCA and O2 Recycle
	public static void VG13(int iteration, String env, String app) throws Exception {
		for (int curriteration = 1; curriteration <= iteration; curriteration++) {
			System.out.println("Current iteration:" + curriteration);
			try {
				ext.startReport();
				ExtentReport.createTest("VG13", "New Residential CUstomer with Custom Plan with CCA and O2 Recycle");
				VG.invokeBrowser(env, app);
				VG.VG13_CSRD(curriteration, iteration);
				VG.quit();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ext.tearDown();
			}
		}

	}

	// New Residential Customer with Custom Plan with CCA and 5G Bolton Access
	public static void VG55_5GBolton(int iteration, String env, String app) throws Exception {
		for (int curriteration = 1; curriteration <= iteration; curriteration++) {
			System.out.println("Current iteration:" + curriteration);
			try {
				ext.startReport();
				ExtentReport.createTest("VG55_5GBolton",
						"New Residential CUstomer with Custom Plan with CCA and 5G Bolton Access");
				VG.invokeBrowser(env, app);
				VG.VG55_5GBolton_CSRD(curriteration, iteration);
				VG.quit();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ext.tearDown();
			}
		}

	}

	// New RCA Customer with Difficulty flag and SIMO Plan through CSRD
	public static void VG3(int iteration, String env, String app) throws Exception {
		for (int curriteration = 1; curriteration <= iteration; curriteration++) {
			System.out.println("Current iteration:" + curriteration);
			try {

				ext.startReport();
				ExtentReport.createTest("VG3", "Creating Residental Customer with SIMO Plan");
				VG.invokeBrowser(env, app);
				VG.VG11_CSRD(curriteration, iteration);
				VG.quit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ext.tearDown();
			}

		}

	}

	// New RCA Customer with Platinum flag and Custom Plan with CCA through CSRD

	public static void VG1(int iteration, String env, String app) throws Exception {

		for (int curriteration = 1; curriteration <= iteration; curriteration++) {
			System.out.println("Current iteration:" + curriteration);
			try {
				ext.startReport();
				ExtentReport.createTest("VG1", "Creating Residental Customer with Custom Plan");
				VG.invokeBrowser(env, app);
				VG.VG14_CSRD(curriteration, iteration);
				VG.quit();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ext.tearDown();
			}
		}

	}

	// New RCA Customer with SIMO Plan and Companion device through CSRD
	public static void VG84(int iteration, String env, String app) throws Exception {
		for (int curriteration = 1; curriteration <= iteration; curriteration++) {
			System.out.println("Current iteration:" + curriteration);
			try {

				ext.startReport();
				ExtentReport.createTest("VG84", "Creating Residental Customer with SIMO Plan and Companion device");
				VG.invokeBrowser(env, app);
				VG.VG84_CSRD(curriteration, iteration);
				VG.quit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ext.tearDown();
			}

		}

	}

	// New RCA Customer with Ipad and Custom Plan with CCA through CSRD
	public static void VG24(int iteration, String env, String app) throws Exception {
		for (int curriteration = 1; curriteration <= iteration; curriteration++) {
			System.out.println("Current iteration:" + curriteration);
			try {

				ext.startReport();
				ExtentReport.createTest("VG24", "Creating Residental Customer with Ipad and Custom Plan with CCA");
				VG.invokeBrowser(env, app);
				VG.VG24_CSRD(curriteration, iteration);
				VG.quit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ext.tearDown();
			}

		}

	}
	
	//New RCA Customer with Custom plan and full upfront
	public static void VG45(int iteration, String env, String app) throws Exception {

		for (int curriteration = 1; curriteration <= iteration; curriteration++) {
			System.out.println("Current iteration:" + curriteration);
			try {
				ext.startReport();
				ExtentReport.createTest("VG45", "Creating Residental Customer with Custom Plan with Full Upront");
				VG.invokeBrowser(env, app);
				VG.VG45_CSRD(curriteration, iteration);
				VG.quit();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ext.tearDown();
			}
		}

	}
	
	//New RCA Customer with Simo and Custom Plan with CCA
		public static void VG46(int iteration, String env, String app) throws Exception {

			for (int curriteration = 1; curriteration <= iteration; curriteration++) {
				System.out.println("Current iteration:" + curriteration);
				try {
					ext.startReport();
					ExtentReport.createTest("VG46", "Creating Residental Customer with Simo and Custom Plan with CCA");
					VG.invokeBrowser(env, app);
					VG.VG46_CSRD(curriteration, iteration);
					VG.quit();

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					ext.tearDown();
				}
			}

		}

	// New SIMO Plan through ECOM
	public static void VG11_Ecommerce(int iteration, String env, String app) throws Exception {
		for (int curriteration = 1; curriteration <= iteration; curriteration++) {
			System.out.println("Current iteration:" + curriteration);

			try {
				ext.startReport();
				ExtentReport.createTest("VG11", "Creating Residental Customer with SIMO Plan");
				VG.invokeBrowser(env, app);
				VG.VG11_ECOM(curriteration, iteration);
				VG.quit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ext.tearDown();
			}
		}

	}
	
	
	public static void VG14_Ecommerce(int iteration, String env, String app) throws Exception {

		for (int curriteration = 1; curriteration <= iteration; curriteration++) {
			System.out.println("Current iteration:" + curriteration);
			try {
				ext.startReport();
				ExtentReport.createTest("VG14", "Creating Residental Customer with Custom Plan");
				VG.invokeBrowser(env, app);
				VG.VG14_ECOM(curriteration, iteration);
				VG.quit();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ext.tearDown();
			}
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
