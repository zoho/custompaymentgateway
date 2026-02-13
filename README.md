# Payment Gateway Connector Development Kit

This Payment Gateway Connector development kit built using gradle, will allow you simulate the interation between zoho books and payment gateway. To use this development kit kindly familiarize yourself with Payment Gateway Connector from our Help Documantation.

## What you'll need

 - Java installed in your system
 - Gradle installed in your system
 

## How to get Started

  - Clone this repository to your machine.
  - use `gradle appRun` in the cloned path to start payment gateway server in your machine.
  - check if the server is up using `https://localhost:8550`.

## How to use in IntelliJ IDEA

### Importing the Project

1. **Open IntelliJ IDEA**
   - Launch IntelliJ IDEA on your machine.

2. **Import the Project**
   - Click on **File → Open** (or **File → New → Project from Existing Sources** in older versions).
   - Navigate to the directory where you cloned this repository.
   - Select the root folder of the project (the one containing `build.gradle`).
   - Click **OK**.

3. **Import as Gradle Project**
   - IntelliJ IDEA will automatically detect the Gradle project.
   - If prompted, select **Import Gradle project** or **Use auto-import**.
   - Accept the default Gradle settings and click **OK**.
   - Wait for IntelliJ to download dependencies and index the project.

### Building the Project

1. **Using Gradle Tool Window**
   - Open the **Gradle** tool window (View → Tool Windows → Gradle).
   - Expand your project name → **Tasks → build**.
   - Double-click on **build** to compile the project.

2. **Using Terminal**
   - Open the terminal in IntelliJ (View → Tool Windows → Terminal).
   - Run: `./gradlew build` (Linux/Mac) or `gradlew.bat build` (Windows).

### Running the Application

1. **Using Gradle Tool Window**
   - Open the **Gradle** tool window.
   - Expand your project name → **Tasks → gretty**.
   - Double-click on **appRun** to start the payment gateway server.
   - The server will start at `https://localhost:8550`.

2. **Using Terminal**
   - Open the terminal in IntelliJ.
   - Run: `./gradlew appRun` (Linux/Mac) or `gradlew.bat appRun` (Windows).

3. **Creating a Run Configuration**
   - Click on **Run → Edit Configurations**.
   - Click the **+** button and select **Gradle**.
   - Name: `Payment Gateway Server`.
   - Gradle project: Select your project.
   - Tasks: `appRun`.
   - Click **OK**.
   - Now you can run the server using the Run button or **Run → Run 'Payment Gateway Server'**.

### Debugging the Application

1. **Set Breakpoints**
   - Open any Java source file (e.g., `src/main/java/ZohoPay/ZohoPayPaymentRequestServlet.java`).
   - Click on the left gutter next to the line number where you want to set a breakpoint.

2. **Start Debug Mode**
   - Use the Debug icon (bug icon) next to your run configuration.
   - Or expand **Gradle → Tasks → gretty** and right-click **appRun**, then select **Debug**.
   - The server will start in debug mode, and execution will pause at your breakpoints.

### Additional Configuration

- **JDK Setup**: Ensure Java SDK 8 or higher is configured (File → Project Structure → Project → Project SDK).
- **Gradle JVM**: Configure Gradle to use the correct JVM (File → Settings → Build, Execution, Deployment → Build Tools → Gradle → Gradle JVM).
- **Hot Reload**: The Gretty plugin supports hot reload. Make changes to your code, and they will be automatically reloaded without restarting the server.

### Troubleshooting

- If dependencies are not downloading, try **File → Invalidate Caches / Restart**.
- If the Gradle tool window is not visible, enable it via **View → Tool Windows → Gradle**.
- For SSL certificate issues when accessing `https://localhost:8550`, accept the self-signed certificate in your browser.
  
## Creating a Payment Gateway Connector in Zoho Books.

You need to be granted access to custom payment gateways, for requesting access kindly write to ***support[at]zohobooks[dot]com***
Once you have been granted access to custom payment gateways 

  - Move to  Settings ---> Integrations ---> Customer Payments ---> Custom Payment Gateway ---> Create New Gateway.
  
  - Enter the following details in the creation page
  
    - Gateway Name - Any name for your gateway
    - Gateway Name formatted - Formatted name for your gateway
    - Live API URL - `https://localhost:8550`
    - Test API URL - `https://localhost:8550`
    - type - choose 'Client for Redirection' option from dropdown
    - Payment Request Path = `/zhpay/createpaypage`
    - Identifier Label Name - Any Label
    - Password Label Name - Any Label
    - Supported Currencies - Any set of currencies
	
  - Then move to Integrated gateway tab. Find you gateway from the listed gateways and click set-up gateway.
  
  - Enter the following credentials
  
    - **Identifier** - ***dummy_accountid***
    - **Password** - ***dummy_password***

## Collect payment from the connected Gateway
    
  - Create an Invoice from your devlopment org and choose this gateway as your payment option.
  
  - Click on  ***Pay Now*** button for the created invoice from client portal or use charge customer option from admin console.
  
  - You will be redirected to the payment page of this gateway.
  
  - Pay your gateway using success/failure cards
  
  - After payment this gateway will redirect you back to zoho books which will process your transaction and land you to payment success/failure pages.
    
    
    

 
