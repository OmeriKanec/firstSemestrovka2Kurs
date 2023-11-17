<style>
    .game-info-text {
        justify-content: space-between;
        align-items: center;
        text-align: center;
    }
    .game-info {
        width: 100%;
        text-align: center;
        align-content: center;
        border: #45141a solid 2px;
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
<#list games as game>
    <div class="game-info" onclick="location.href='game?id=${game.id}'">
        <div class="game-info-text">
            <section>
                <p>Name:
                    ${game.name}
            </section>
            <section>
                <p>Genre:
                    ${game.genre!"not specifed"}
            </section>
            <section>
                <p>Date of Relise:
                    ${game.dateofrelise!"not specifed"}
            </section>
            <section>
                <p>developer:
                    ${game.developer!"not specifed"}
            </section>
            <section>
                <p>Name:
                    ${game.publisher!"not specifed"}
            </section>
        </div>
    </div>
</#list>
</body>
</html>