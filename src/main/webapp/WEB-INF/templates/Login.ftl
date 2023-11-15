<#macro login title mainButtonText redirectAction redirectButtonText>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <link rel="stylesheet" type="text/css" href="./static/css/styleForForms.css">
</head>
<body>
        <form action='' method='post' id="userInfoForm">
            <#nested>
            <label for='email'>Email</label>
            <input type='email' id='email' name='email' placeholder='Enter email'>
   <div>
       <label for='password'>Password</label>
       <input type='password' id='password' name='password' placeholder='Enter password'>
   </div>
 <button type='submit'>${mainButtonText}</button>
  </form>
<form action='${redirectAction}' method='get'>
  <button type='submit'>${redirectButtonText}</button>
  </form>
</body>
<script type="module" src="./static/js/validation.js"></script>
</html>
</#macro>
<@login "LogIn" "Log in" "signup" "Sign Up"></@login>