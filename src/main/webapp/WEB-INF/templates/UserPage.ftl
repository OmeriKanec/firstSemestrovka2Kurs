<#macro content></#macro>
<style>
    .user-info-text {
        justify-content: space-between;
        align-items: center;
        text-align: center;
        margin-left: 30%;
    }
    .profilePicture {
        display: flex;
        justify-content: left;
        align-items: flex-start;
        text-align: left;
        width: 20%;
    }
    .user-info {
        display: flex;
        width: 100%;
        text-align: center;
        align-content: center;
    }
    body {
        background-color: black;
        color: white;
    }
</style>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User page</title>
</head>
<body>
<#include "Menu.ftl">
<div class="user-info">
    <img class="profilePicture" src="${profilePicture!"../static/pictures/vod.jpg"}" alt="profilePicture">
    <div class="user-info-text">
    <section>
        <p>Username:
        ${username}
    </section>
    <@content></@content>
    <section>
        <p>Bio:
        ${bio!"none"}
    </section>
    </div>
</div>
</body>
</html>