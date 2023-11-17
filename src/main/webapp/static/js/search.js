const searchbar = document.getElementById("query");
searchbar.addEventListener("input" , function f() {
    const userinfo = document.querySelector(".users")
    if (searchbar.value.length >= 0) {
        $.ajax({
            url: "search",
            method: "GET",
            data: {"query": searchbar.value},
            dataType: "json",
            success: (data) =>  {
                userinfo.innerHTML = "";
                if (data.length > 0) {
                    for (let i = 0; i < data.length; i++) {
                        let username = data[i]["userName"];
                        let profilePicture = "../static/pictures/vod.jpg";
                        if (data[i]["profilePicture"] !== undefined) {
                            profilePicture = data[i]["profilePicture"];
                        }
                        let bio = "none";
                        if (data[i]["bio"] !== undefined) {
                            bio = data[i]["bio"];
                        }
                        userinfo.innerHTML += '<div class="user-info" onclick="location.href=`userpage?username=${username}`">\n' +
                            `        <img class="profilePicture" src=${profilePicture} alt="profilePicture">\n` +
                            '        <div class="user-info-text">\n' +
                            '            <section>\n' +
                            '                <p>Username:\n' +
                            `                    ${username}\n` +
                            '            </section>\n' +
                            '            <section>\n' +
                            '                <p>Bio:\n' +
                            `                    ${bio}\n` +
                            '            </section>\n' +
                            '        </div>\n' +
                            '    </div>'
                    }
                }

            }
    })
    }
})