function currentYPosition() {
    // Firefox, Chrome, Opera, Safari
    if (self.pageYOffset) return self.pageYOffset;
    // Internet Explorer 6 - standards mode
    if (document.documentElement && document.documentElement.scrollTop)
        return document.documentElement.scrollTop;
    // Internet Explorer 6, 7 and 8
    if (document.body.scrollTop) return document.body.scrollTop;
    return 0;
};


function elmYPosition(eID) {
    var elm = document.getElementById(eID);
    var y = elm.offsetTop;
    var node = elm;
    while (node.offsetParent && node.offsetParent != document.body) {
        node = node.offsetParent;
        y += node.offsetTop;
    } return y;
};


function smoothScroll(eID) {
    var startY = currentYPosition();
    var stopY = elmYPosition(eID)-130;
    var distance = stopY > startY ? stopY - startY : startY - stopY;
    if (distance < 100) {
        scrollTo(0, stopY); return;
    }
    var speed = Math.round(distance / 20);
    if (speed >= 20) speed = 25;
    var step = Math.round(distance / 25);
    var leapY = stopY > startY ? startY + step : startY - step;
    var timer = 0;
    if (stopY > startY) {
        for ( var i=startY; i<stopY; i+=step ) {
            setTimeout("window.scrollTo(0, "+leapY+")", timer * speed);
            leapY += step; if (leapY > stopY) leapY = stopY; timer++;
        } return;
    }
    for ( var i=startY; i>stopY; i-=step ) {
        setTimeout("window.scrollTo(0, "+leapY+")", timer * speed);
        leapY -= step; if (leapY < stopY) leapY = stopY; timer++;
    }
};

function displayTopPageButton(actualYPosition){
    let button = document.getElementById("top-page-button");
    if(actualYPosition>100){
        button.style.display = "block";
    }else{
        button.style.display = "none";
    };
};

function setText(textID,text) {

    document.getElementById("text"+textID).innerHTML = text;


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



