
window.onload = function () {
    document.getElementById("deconnexion-button").onclick = function(){
        location.href = "deconnexion";
    };


    let sendButtons = document.getElementsByClassName("send-button");
    console.log(sendButtons.length);
    for (var i=0; i<sendButtons.length; i++){
        let button = sendButtons[i];
        button.onclick =function () {
            let id = button.getAttribute("id")[16];
            changeText(id);
        };
    } ;



    getText(0);
    getText(1);
    getText(2);
    getText(3);

};

function getText(textId) {
    let text;
    let textRequest = new XMLHttpRequest();
    let url = "ws/text/"+textId;

    textRequest.open("GET",url,true);
    textRequest.responseType = "json";

    textRequest.onload = function () {
        text = this.response;
        setText(textId,text);
    };

    textRequest.send();

};

function setText(textID,text) {

    document.getElementById("text"+textID).innerHTML = text;


};

function changeText(textId) {
    let text = document.getElementById("text"+textId).value;
    let changeRequest = new XMLHttpRequest();
    changeRequest.open("POST", "ws/text/"+textId,true);

    changeRequest.onload = function () {

        alert("Texte changé !!")
        getText(textId);

    };

    changeRequest.setRequestHeader("content-type","application/json");
    changeRequest.send(text);

};