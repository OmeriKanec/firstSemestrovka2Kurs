<style>
    body {
        background-color: black;
        color: white;

    }
    .content {
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
    <title>New comment</title>
</head>
<body>
<#include "Menu.ftl">
<div class="content">
    <form action='' method='post' id="commentForm">
        <div>
            <label for='name'>Name of comment</label>
            <p>
                <input type='text' id='name' name='name' placeholder='Enter name of comment'>
            </p>
        </div>
        <div>
            <p>
                <label for="content">Comment</label>
            </p>
            <textarea name="content" id="content" rows="10" cols="40"></textarea>
        </div>
        <p>
            <button type='submit' id="id" value="${id}">Comment</button>
        </p>
    </form>
</div>
</body>
</html>