<style>
    .post-info-text {
        justify-content: space-between;
        align-items: center;
        text-align: center;
        margin-left: 30%;
    }
    .poster-info {
        display: flex;
        justify-content: left;
        align-items: flex-start;
        text-align: left;
        width: 20%;
    }
    .post-info {
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
<#list posts as post>
    <div class="post-info" onclick="location.href='post?id=${post.id}'">
        <div class="poster-info">
            <section>
                <p>Posted by:
                    ${post.posterName}
            </section>
        </div>
        <div class="post-info-text">
            <section>
                <p>Theme:
                    ${post.name}
            </section>
            <section>
                <p>
                    ${post.dateOfPost}
            </section>
        </div>
    </div>
</#list>
</body>
</html>
