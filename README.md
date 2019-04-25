# Customer Phone Number Assignment

This assignment is designed on spring-boot framework.

## Installation

1. Clone the source code
    ```sh
    git clone https://github.com/srishtia125/TestProject.git
    ```
2. Go to the checked out source code and start the server locally (Server will start on port 8081 , make sure no other is using the same port)
    ```bash
    mvn spring-boot:run
    ```
3. Once the server is started , access swagger-ui
   [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)


## Usage

When the server starts , internally following data is stored:
| CustomerId  | Phone Number |Activated |
| ------------- | ------------- | ------------- |
| 1  | 111111111|No|
| 2  | 222222222|No|
| 2  | 333333333|Yes|
| 3  | 444444444|Yes|
| 3  | 555555555|No|
| 3  | 666666666|Yes|


## APIs
  -  Get All Phone Numbers  [http://localhost:8081/phone](http://localhost:8081/phone)
This Api returns the phine number deetails.We have also included the customerId and isActivated flag to make response more useful.

  - Get all phone numbers for a customer [http://localhost:8081/customer/3/phone](http://localhost:8081/customer/3/phone) -- This returns the phone numbers of customer with id : 3
  - Activate a phone number. This is a POST call since action is being performed. http://localhost:8081/swagger-ui.html#/customer-controller/activateCustomerPhoneNumberUsingPOST



## Exceptions
- CustomerNotFoundException : if the api input consis of the customer is which is not availble in the system.
- PhoneAlreadyActivatedException : if we try to activate the already activated phone for a customer
- PhoneNumberNotFoundException : if phone number which we try to activate is not associated with that customer

# Test Cases
Execute **mvn test** command to run test cases:

  - test if all phone numbers are returned from the system
  - test if activation of number is working for a non-activated number
  - test if exception is thrown when wrong customer id is provided
  - test if exception is thrown if wrong phone number for a customer is provided
  - test if already activated phone is tried for activation
