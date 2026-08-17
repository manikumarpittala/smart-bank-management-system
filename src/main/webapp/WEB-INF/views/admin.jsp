<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Smart Bank</title>
    <link rel="stylesheet" href="admin.css">
</head>
<body>
    <h1>Admin Login</h1>
    <form action="/admin/login" method="post">
    <label for="email"></label>
    Email:<input type="email" name="email" id="email" placeholder="enter your email"><br><br>
    Password<label for="password"></label>
    <input type="text" name="password" id="password" placeholder="enter your password"><br><br>
    <button type="submit">Login</button>
    </form>
</body>
</html>