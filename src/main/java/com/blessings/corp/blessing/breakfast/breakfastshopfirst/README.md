# 🍳 Breakfast Shop First Management System
Problem Statement:

Design a simplified version of a breakfast shop management system. The system should be able to handle menu management, order placements, and track the available stock of breakfast items. Each item is identified by a unique ID and has a name, category, and price.

Functional Requirements:

- Add Menu Item  
Add new items to the breakfast shop menu, including specifying stock quantity.

  Input Format: ADD_ITEM itemId name category price stock

  If the item already exists (same itemId), increase the stock by the specified amount.


- Order Item  
Allow a customer to order a menu item if it is available in stock.

  Input Format: ORDER_ITEM itemId

  If the item is available, decrease the stock by one and print:

  "Ordered [name]"

  If the item is out of stock, print:

  "Item not available"


- Restock Item  
Increase the stock of a specific item.

  Input Format: RESTOCK_ITEM itemId quantity

  Print "Restocked [name]"


- List Available Items  
Print a list of all menu items that have at least one available stock, sorted by item name.

  Command: LIST_AVAILABLE_ITEMS

Sample Input:  
ADD_ITEM 101 "Pancakes" "Main" 5.99 5  
ADD_ITEM 102 "Coffee" "Drink" 2.50 10  
ORDER_ITEM 101  
RESTOCK_ITEM 101 3  
LIST_AVAILABLE_ITEMS  

Sample Output:  
Ordered Pancakes  
Restocked Pancakes  
Coffee - Drink - $2.5 - 10 available  
Pancakes - Main - $5.99 - 7 available  
