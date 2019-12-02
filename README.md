# Payment Gateway Connector Development Kit

This Payment Gateway Connector development kit built using gradle, will allow you simulate the interation between zoho books and payment gateway. To use this development kit kindly familiarize yourself with Payment Gateway Connector from our Help Documantation.

## What you'll need

 - Java installed in your system
 - Gradle installed in your system
 

## How to get Started

  - Clone this repository to your machine.
  - use `gradle appRun` in the cloned path to start payment gateway server in your machine.
  - check if the server is up using `http://localhost:8099`.
  
## Creating a Payment Gateway Connector in Zoho Books.

You need to be granted access to custom payment gateways, for requesting access kindly write to ***support[at]zohobooks[dot]com***
Once you have been granted access to custom payment gateways 

  - Move to  Settings ---> Integrations ---> Customer Payments ---> Custom Payment Gateway ---> Create New Gateway.
  
  - Enter the following details in the creation page
  
    - Gateway Name - Any name for your gateway
    - Gateway Name formatted - Formatted name for your gateway
    - Live API URL - `http://localhost:8099/zhpay`
    - Test API URL - `http://localhost:8099/zhpay`
    - type - choose 'Client for Redirection' option from dropdown
    - Payment Request Path = `/createpaypage`
    - Identifier Label Name - Any Label
    - Password Label Name - Any Label
    - Supported Currencies - Any set of currencies
	
  - Then move to Integrated gateway tab. Find you gateway from the listed gateways and click set-up gateway.
  
  - Enter the following credentials
  
    - **Identifier** - ***8719992***
    - **Password** - ***uRIj0837FYjk***

## Collect payment from the connected Gateway
    
  - Create an Invoice from your devlopment org and choose this gateway as your payment option.
  
  - Click on  ***Pay Now*** button for the created invoice from client portal or use charge customer option from admin console.
  
  - You will be redirected to the payment page of this gateway.
  
  - Pay your gateway using success/failure cards
  
  - After payment this gateway will redirect you back to zoho books which will process your transaction and land you to payment success/failure pages.
    
    
    

 
