<#import "UserPage.ftl" as userPage>
<@userPage.page>
    <section>
        <p>email:
            ${email}
    </section>
    <button type="button" class="btn" id="change" onclick="location.href='change'">Change info</button>
</@userPage.page>

