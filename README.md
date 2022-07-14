# Telecom Customer Portal
	For this project you will be making a customer portal for a telecommunications company. Think of any one of your mobile carriers (ATT, Verizon, Sprint, etc.). You will be making a website so that users will be able to create and manage their accounts.![image](https://user-images.githubusercontent.com/107573463/179091535-74c5598e-892b-4146-9d4f-5045c09b5fc3.png)


# Functional Requirements
•	Users must be able to add and remove phone plans from their account
	o	There must be at least three different plans
	o	Users can have multiple plans on their account
		♣	Create a new user_plan
			•	When adding a device to a plan, user fills out form with device info
			•	User picks phone number for device based on user’s phone numbers, add a new row in the user_plan table user_id, plan_id, phone_number_id
		♣	User removes a plan --> remove all rows in the user_plan table with plan_id = <input plan_id>
				•	*have an option to show users their registered devices that are not tied to any plan 
•	The plans must all have different device limits, prices, names, etc
	o	Make all device limits, prices, names, UNIQUE columns
	
•	Users can add and remove devices from their account
	o	Users cannot add more devices than their plans allow
		♣	Get device limit for user’s plans 
		♣	Get number of devices per plan
		♣	Use backend logic to compare, if there is an error rollback the transaction
		♣	If pass –  add the device to the table (user inputs device info + unique phone #)
		
•	Devices should have a unique phone number and users can assign any of their phone numbers to any of their devices

•	Users should be able to see a breakdown of their monthly bill based on their plans
	o	Grab user_plans for this user, and then look up the info for those plan_ids in the plans table
	
•	Users should be able to sign into their account, and only be able to manage that account
	o	User A should not be able to view/ edit user B’s account
		♣	Query user_plans for this user and display that data
		♣	Make usernames unique
		♣	Add in columns with information like age, gender etc. so we can display it on the frontend 
![image](https://user-images.githubusercontent.com/107573463/179091766-2e71195a-6e5a-4758-b900-79442555bef7.png)


# Technologies
You will make the project using these technologies
•	Angular
•	CSS
•	Spring Boot
•	Spring Data JPA
•	MySQL
•	Azure DevOps
What you use for authentication/ how you set it up is up to you, but you will lose points if your code presents a major security risk.

# Due: Friday July 29th
