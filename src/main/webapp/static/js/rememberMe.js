function getCookie(name) {
    let value = "; " + document.cookie;
    let s = value.split("; " + name + "=");
    if (s.length === 2){
        s = s[1].split(";")[0];
        return s;
    }
    s = s[0].split(";")[0];
    return s;
}
const rememberMeInput = document.querySelector("#rememberMe");
const emailInput = document.querySelector("#email");
const passwordInput = document.querySelector("#password");
const email = getCookie("email");
const password = getCookie("password");
const rememberMe = getCookie("rememberMe")
window.onload = () => {
    if (email !== null && password !== null && rememberMe !== null) {
        emailInput.value = email;
        passwordInput.value = password;
        rememberMeInput.checked = rememberMe;
    }
}


