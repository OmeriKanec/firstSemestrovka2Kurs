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
    <title>Post page</title>
</head>
<body>
<#include "Menu.ftl">
<div class="game-info">
    <div class="game-info-text">
        <section>
            <p>Name:
                ${name}
        </section>
        <section>
            <p>Genre:
                ${genre!"not specifed"}
        </section>
        <section>
            <p>Date of Relise:
                ${dateofrelise!"not specifed"}
        </section>
        <section>
            <p>developer:
                ${developer!"not specifed"}
        </section>
        <section>
            <p>Name:
                ${publisher!"not specifed"}
        </section>
    </div>
</div>
</body>
</html>