<#import "Comments.ftl" as comment>
<style>
        .post-info-text {
            justify-content: space-between;
            align-items: center;
            text-align: center;
        }
        .poster-info {
            display: flex;
            justify-content: left;
            align-items: flex-start;
            text-align: left;
            width: 20%;
        }
        .post-info {
            width: 100%;
            text-align: center;
            align-content: center;
            border-bottom: #0e1545 solid;
            margin-bottom: 20px;
        }
        .comment-info {
            border-bottom: #184521 solid;
            margin-bottom: 10px ;
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
    <div class="post-info">
        <div class="poster-info">
            <section>
                <p>Posted by:
                    ${posterName}
            </section>
        </div>
        <div class="post-info-text">
            <section>
                <p>Theme:
                    ${name}
            </section>
            <section style="word-break: break-all">
                <p>
                    ${content!"none"}
            </section>
            <section>
                <p>
                    ${dateOfPost}
            </section>
        </div>
        <p>
        <form name="comment" action="" method="post">
            <button type="submit" id="id" value="${id}">Comment</button>
        </form>
    </div>
    <div>
        <@comment.comment></@comment.comment>
    </div>
    </body>
    </html>