<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Smart Bank</title>
</head>
<body>
    <h1>Hi "${name}"</h1>
    <h1>Enter Your Secret Key</h1>
    <form action="/admin/secretkey" method="post">
        <label for="secret"></label>
       Secret Key:<input type="text" name="secretkey" id="secret" placeholder="Please enter your secret key"><br><br>
       <button type="submit">Submit</button>
    </form>
</body>
</html>