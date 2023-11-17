<#import "Login.ftl" as login>
<@login.login "SignUp" "Sign Up" "login" "Log in"><label for="username">Username</label><p>
    <input type='text' id='username' name='username' placeholder='Enter Username'>
</p>
</@login.login>