const userInfoForm = document.querySelector("#userInfoForm");
const emailInput = document.querySelector("#email");
const passwordInput = document.querySelector("#password");
const userNameInput = document.querySelector("#username");
emailInput.addEventListener("input", (event) =>{
    const regularExp = RegExp('([A-Za-z0-9][A-Za-z0-9-_.+!()]+)@([A-Za-z.]+)\\.([a-z]+)');
    if (regularExp.exec(emailInput.value) === null || regularExp.exec(emailInput.value)[0] !== emailInput.value){
        emailInput.classList.add('invalid');
        emailInput.classList.remove('valid');
    }else {
        emailInput.classList.add('valid');
        emailInput.classList.remove('invalid');
    }
})
passwordInput.addEventListener("input", (event) =>{
    const regularExp = RegExp('[^\\s]*[A-Za-z0-9!]+[^\\s]*');
    if (regularExp.exec(passwordInput.value) === null || regularExp.exec(passwordInput.value)[0] !== passwordInput.value){
        passwordInput.classList.add('invalid');
        passwordInput.classList.remove('valid');
    }else {
        passwordInput.classList.add('valid');
        passwordInput.classList.remove('invalid');
    }
})
userInfoForm.addEventListener('submit', (event) =>{
    // event.preventDefault();
    // console.log(event)
    if (emailInput.value=="" || passwordInput.value=="" || userNameInput.value == ""
        || emailInput.classList.contains('invalid')){
        event.preventDefault();
        alert('Заполните все поля правильными данными');
    }
})
userNameInput.addEventListener("input", (event) =>{
    setTimeout(() => $.ajax({
        url: "usernametaken",
        method: "GET",
        data: {"username": userNameInput.value},
        dataType: "json",
        success: (data) => {
            if (data){
                alert("Username already taken")
            }
        }
    }), 1500)
})

emailInput.addEventListener("input", (event) =>{
    setTimeout(() => $.ajax({
        url: "emailtaken",
        method: "GET",
        data: {"email": emailInput.value},
        dataType: "json",
        success: (data) => {
            if (data){
                alert("Email already in use")
            }
        }
    }), 1500)
})

