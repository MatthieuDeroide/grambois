
let createUser = function () {
    let user = {
        mail: document.getElementById("mailinput").value,
        pwd: document.getElementById("passwdinput").value,
    };
    let saveRequest = new XMLHttpRequest();
    saveRequest.open("POST", "ws/usrcontrol", true);

    saveRequest.onload = function () {
        console.log("here");
        if (this.status === 201) {
            alert("Utilisateur créé")
        } else if (this.status === 204) {
            alert("The city creation should return a CREATED response status!");
        } else if (this.status === 409) {
            alert("The city code already exists!");
        }
    };
    saveRequest.setRequestHeader("content-type", "application/json");
    saveRequest.send(JSON.stringify(user));
};

window.onload = function () {

    document.getElementById("sendbutton").onclick = function () {
        mail = document.getElementById("mailinput").value;
        pwd = document.getElementById("passwdinput").value;
        console.log(mail+pwd);
        createUser();

    };
};