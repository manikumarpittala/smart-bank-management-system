<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Smart Bank</title>
</head>
<body>
    <h1>Create an Account</h1>
    <form action="/admin/createaccount" method="post">
        Customer Name:<input type="text" name="name" placeholder="enter Name"><br><br>
        Customer AadharNumber:<input type="number" name="aadharNumber" placeholder="enter aadhar number"><br><br>
        Customer PanCard Number<input type="text" name="panNumber" placeholder="enter pan number"><br><br>
        Customer Address<input type="text" name="address" placeholder="enter address"><br><br>
        Customer PhoneNumber<input type="number" name="phoneNumber" placeholder="enter phone number"><br><br>
        Customer Email<input type="email" name="email" placeholder="enter email"><br><br>
        Customer Balance<input type="text" name="openingBalance" placeholder="enter opening balance"><br><br>
        <button type="submit">Submit</button>
    </form>
</body>
</html>