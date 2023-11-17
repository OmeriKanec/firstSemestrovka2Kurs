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
    <title>New post</title>
</head>
<body>
<#include "Menu.ftl">
<div class="content">
    <form action='' method='post' id="postForm">
        <div>
            <label for='name'>Name of post</label>
            <p>
                <input type='text' id='name' name='name' placeholder='Enter name of post'>
            </p>
        </div>
        <div>
            <p>
                <label for="content">Post</label>
            </p>
            <textarea name="content" id="content" rows="10" cols="40"></textarea>
        </div>
        <div>
            <label for='allowcomments'>Allow comments</label>
            <input type='checkbox' id='allowcomments' name='allowcomments' checked>
        </div>
        <p>
            <button type='submit'>Post</button>
        </p>
    </form>
</div>
</body>
</html>