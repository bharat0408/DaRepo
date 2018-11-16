<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction</title>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box}

/* Full-width input fields */
input[type=text] {
     width: 100%;
    padding: 15px;
    margin: 5px 0 22px 0;
    display: inline-block;
    border: none;
    background: #f1f1f1;
}

input[type=text]:focus{
    background-color: #ddd;
    outline: none;
}
.btn {
  width: 25;
  padding: 12px;
  border: none;
  border-radius: 4px;
  margin: 5px 0;
  opacity: 0.85;
  display: inline-block;
  font-size: 17px;
  line-height: 20px;
  text-decoration: none; /* remove underline from anchors */
}

hr {
    border: 1px solid #f1f1f1;
    margin-bottom: 25px;
}

/* Set a style for all buttons */
submit {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
    opacity: 0.9;
}

submit:hover {
    opacity:1;
}
.deposit {
    padding: 14px 20px;
    background-color: #f44336;
}

.deposit {
       width: 100%;
    }
.deposit{
  float: left;
  width: 50%;
}

/* Add padding to container elements */
.container {
    padding: 16px;
}

</style>
</head>
<body>

<form action="TransactionServlet">
    <label for="RegNo"><b>Enter Your Registration Number<i class="fa fa-user icon"></i></b></label>
    <input type="text" placeholder="Enter RegNo" name="rno" required><br>
    
    <label for="Balance"><b>Enter Deposit Amount<i class="fa fa-user icon"></i></b></label>
    <input type="text" placeholder="Enter Amount" name="ball" required><br>
   
    <input type="submit" value="Deposit" class="deposit">

</form>

</body>
</html>