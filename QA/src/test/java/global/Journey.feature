Feature: Implement a test to verify the following user journey

Scenario: Verification of Item in my basket and purchase
Given Login to https://www.saucedemo.com/ using the "standard_user" account
When Sort the products by Price (high to low)
And Add the cheapest & the 2nd costliest products to your basket
And Open the basket
And Checkout
Then Enter details and Finish the purchase