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
    <title>New game</title>
</head>
<body>
<#include "Menu.ftl">
<div class="content">
    <form action='' method='post' id="gameForm">
        <div>
            <label for='name'>Name of game</label>
            <p>
                <input type='text' id='name' name='name' placeholder='Enter name of game'>
            </p>
        </div>
        <div>
            <label for='genre'>Genre of game</label>
            <p>
                <input type='text' id='genre' name='genre' placeholder='Enter genre of game'>
            </p>
        </div>
        <div>
            <label for='dateofrelise'>Date of relise</label>
            <p>
                <input type='date' id='dateofrelise' name='dateofrelise' placeholder='Enter date of relise'>
            </p>
        </div>
        <div>
            <label for='developer'>Developer of game</label>
            <p>
                <input type='text' id='developer' name='developer' placeholder='Enter developer of game'>
            </p>
        </div>
        <div>
            <label for='publisher'>publisher of game</label>
            <p>
                <input type='text' id='publisher' name='publisher' placeholder='Enter publisher of game'>
            </p>
        </div>
        <p>
            <button type='submit'>Create</button>
        </p>
    </form>
</div>
</body>
</html>