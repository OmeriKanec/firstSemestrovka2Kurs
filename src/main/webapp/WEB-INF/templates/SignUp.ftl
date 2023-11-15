<#--<html><body>-->
<#--<form action='' method='post' >-->
<#--    <div class="container">-->
<#--        <label>Username</label>-->
<#--        <input type='text' id='username' name='username' required placeholder='Enter Username' style="display: inline-block; width: 100% ">-->
<#--        <label>Email</label>-->
<#--        <input type='email' id='email' name='email' required placeholder='Enter Email' style="display: inline-block; width: 100%">-->
<#--        <label>Password</label>-->
<#--        <input type='password' id='password' name='password' required placeholder='Enter Password' style="display: inline-block">-->
<#--        <button type='submit'>Sign Up</button>-->
<#--    </div>-->
<#--</form>-->
<#--<form action='login' method='get'>-->
<#--    <button type='submit'>Log in</button>-->

<#--</form>-->

<#--</body></html>-->

<#import "Login.ftl" as login>
<@login.login "SignUp" "Sign Up" "login" "Log in"><label for="username">Username</label>
    <input type='text' id='username' name='username' placeholder='Enter Username'>
</@login.login>