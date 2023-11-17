<#macro comment>
<#list comments as comment>
    <div class="comment-info">
        <div class="poster-info">
            <section>
                <p>Commented by:
                    ${comment.posterName}
            </section>
        </div>
        <div class="post-info-text">
            <section>
                <p>${comment.name}
            </section>
            <section style="word-break: break-all">
                <p>
                    ${comment.content!"none"}
            </section>
            <section>
                <p>
                    ${comment.dateOfComment}
            </section>
        </div>
    </div>
</#list>
</#macro>