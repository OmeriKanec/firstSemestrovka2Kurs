<style>
body {
    background-color: black;
    color: white;
}
.content{
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
    <title>Change info</title>
</head>
<body>
<#include "Menu.ftl">
<div class="content">
    <form method="post" action="" id="changeUserInfo" enctype="multipart/form-data">
        <div>
            <p>
            <label for="bio">Bio</label>
            </p>
            <textarea name="bio" id="bio" rows="10" cols="40">${bio}</textarea>
        </div>
        <div>
            <p>
            <label for='file'>Profile picture</label>
            </p>
            <input type='file' id='file' name='file' accept="image/png, image/jpeg, image/jpg">
        </div>
        <p>
            <button type='submit'>Change</button>
        </p>
    </form>
</div>