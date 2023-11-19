# ShieldX
Rather than requesting it from customer care services, large UPI payment companies can now use a function we developed to verify the payment by transaction_id from the client side.
In order to accomplish this, we have developed an application called ShieldX, wherein we perform a straightforward transaction on our local database and produce a transaction_id on our MySQL database. The client can then utilise this ID to confirm the payment.
The verification method is most helpful when the sender pretends to be someone you don't know and shows you a phoney screenshot; in this case, you can copy the transaction_id and paste it into our app to verify.
