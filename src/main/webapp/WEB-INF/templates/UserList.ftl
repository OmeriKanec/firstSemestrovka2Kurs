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
        border: greenyellow solid 2px;
        margin-bottom: 15px;
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
    <title>User list</title>
</head>
<body>
<#include "Menu.ftl">
<#list users as user>
    <div class="user-info" onclick="location.href='userpage?username=${user.userName}'">
        <img class="profilePicture" src="${user.profilePicture!"../static/pictures/vod.jpg"}" alt="profilePicture">
        <div class="user-info-text">
            <section>
                <p>Username:
                    ${user.userName}
            </section>
            <section>
                <p>Bio:
                    ${user.bio!"none"}
            </section>
        </div>
    </div>
</#list>
</body>
</html>

