# 🍳 Breakfast Shop Second Management System
🔹 New Features

Place Multi-Item Orders

- A customer can order multiple items in one order.

  System will check stock for all items, update stock, and calculate total price.

  Command:

  PLACE_ORDER customerName itemId1 quantity1 itemId2 quantity2 ...

  Output example:
  
  Order placed for John. Total: $15.47


- View Order History

  List all previous orders with customer name, items ordered, and total cost.

  Command:

   LIST_ORDERS


- Add / Update Items (existing)


- View Menu

  Command:

  LIST_AVAILABLE_ITEMS

Sample Input  
ADD_ITEM 101 "Pancakes" "Main" 5.99 5  
ADD_ITEM 102 "Coffee" "Drink" 2.50 10  
ADD_ITEM 103 "Bagel" "Snack" 3.00 5  
PLACE_ORDER John 101 2 102 1  
PLACE_ORDER Mary 103 3 102 2  
LIST_ORDERS  
LIST_AVAILABLE_ITEMS

Sample Output  
Order placed for John. Total: $14.48

Order placed for Mary. Total: $15.00

--- Orders ---  
Customer: John | Items: Pancakes x2, Coffee x1 | Total: $14.48

Customer: Mary | Items: Bagel x3, Coffee x2 | Total: $15.00

Coffee - Drink - $2.5 - 7 available

Pancakes - Main - $5.99 - 3 available

Bagel - Snack - $3.0 - 2 available
