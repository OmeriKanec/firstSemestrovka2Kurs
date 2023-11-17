<#macro login title mainButtonText redirectAction redirectButtonText>
    <style>
        body {
            background-color: black;
            color: white;
            text-align: center;
            align-items: center;
            display: flex;
            justify-content: center;
        }

    </style>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <link rel="stylesheet" type="text/css" href="./static/css/styleForForms.css">
</head>
<body>
<div>
        <form action='' method='post' id="userInfoForm">
            <div>
            <#nested>
            <label for='email'>Email</label>
            <p>
            <input type='email' id='email' name='email' placeholder='Enter email'>
            </p>
            </div>
            <div>
                <label for='password'>Password</label>
                <p>
                    <input type='password' id='password' name='password' placeholder='Enter password'>
                </p>
            </div>
            <div>
                <label for='rememberMe'>Remember me</label>
                    <input type='checkbox' id='rememberMe' name='rememberMe'>
            </div>
            <p>
            <button type='submit'>${mainButtonText}</button>
            </p>
  </form>
<form action='${redirectAction}' method='get'>
  <button type='submit'>${redirectButtonText}</button>
</form>
</div>
</body>
<script type="module" src="./static/js/validation.js"></script>
<script type="module" src="./static/js/rememberMe.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</html>
</#macro>
<@login "LogIn" "Log in" "signup" "Sign Up"></@login>