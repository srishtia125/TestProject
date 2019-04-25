
<h1><a id="Customer_Phone_Number_Assignment_2"></a>Customer Phone Number Assignment</h1>
<p>This assignment is designed on spring-boot framework.</p>
<h2><a id="Installation_6"></a>Installation</h2>
<ol>
<li>Clone the source code<pre><code class="language-sh">git <span class="hljs-built_in">clone</span> https://github.com/srishtia125/TestProject.git
</code></pre>
</li>
<li>Go to the checked out source code and start the server locally (Server will start on port 8081 , make sure no other is using the same port)<pre><code class="language-bash">mvn spring-boot:run
</code></pre>
</li>
<li>Once the server is started , access swagger-ui<br>
<a href="http://localhost:8081/swagger-ui.html">http://localhost:8081/swagger-ui.html</a></li>
</ol>
<h2><a id="Usage_20"></a>Usage</h2>
<p>When the server starts , internally following data is stored:</p>
<table class="table table-striped table-bordered">
<thead>
<tr>
<th>CustomerId</th>
<th>Phone Number</th>
<th>Activated</th>
</tr>
</thead>
<tbody>
<tr>
<td>1</td>
<td>111111111</td>
<td>No</td>
</tr>
<tr>
<td>2</td>
<td>222222222</td>
<td>No</td>
</tr>
<tr>
<td>2</td>
<td>333333333</td>
<td>Yes</td>
</tr>
<tr>
<td>3</td>
<td>444444444</td>
<td>Yes</td>
</tr>
<tr>
<td>3</td>
<td>555555555</td>
<td>No</td>
</tr>
<tr>
<td>3</td>
<td>666666666</td>
<td>Yes</td>
</tr>
</tbody>
</table>
<h2><a id="APIs_33"></a>APIs</h2>
<ul>
<li>
<p>Get All Phone Numbers  <a href="http://localhost:8081/phone">http://localhost:8081/phone</a><br>
This Api returns the phine number deetails.We have also included the customerId and isActivated flag to make response more useful.</p>
</li>
<li>
<p>Get all phone numbers for a customer <a href="http://localhost:8081/customer/3/phone">http://localhost:8081/customer/3/phone</a> – This returns the phone numbers of customer with id : 3</p>
</li>
<li>
<p>Activate a phone number. This is a POST call since action is being performed. <a href="http://localhost:8081/swagger-ui.html#/customer-controller/activateCustomerPhoneNumberUsingPOST">http://localhost:8081/swagger-ui.html#/customer-controller/activateCustomerPhoneNumberUsingPOST</a></p>
</li>
</ul>
<h2><a id="Exceptions_42"></a>Exceptions</h2>
<ul>
<li>CustomerNotFoundException : if the api input consis of the customer is which is not availble in the system.</li>
<li>PhoneAlreadyActivatedException : if we try to activate the already activated phone for a customer</li>
<li>PhoneNumberNotFoundException : if phone number which we try to activate is not associated with that customer</li>
</ul>
<h1><a id="Test_Cases_47"></a>Test Cases</h1>
<p>Execute <strong>mvn test</strong> command to run test cases:</p>
<ul>
<li>test if all phone numbers are returned from the system</li>
<li>test if activation of number is working for a non-activated number</li>
<li>test if exception is thrown when wrong customer id is provided</li>
<li>test if exception is thrown if wrong phone number for a customer is provided</li>
<li>test if already activated phone is tried for activation</li>
</ul>
