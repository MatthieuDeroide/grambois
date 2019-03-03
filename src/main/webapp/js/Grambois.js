
window.onload = function(){
    document.getElementById("accueil-button").onclick = function(){
        smoothScroll("accueilText1");
    };
    document.getElementById("gite-button").onclick = function(){
    	smoothScroll("accueilText2");
    };
    document.getElementById("activite-button").onclick = function(){
    	smoothScroll("accueilText3");
    };
    document.getElementById("contact-button").onclick = function(){
        document.getElementById("overlay").style.display = "block";
    };
    document.getElementById("top-page-button").onclick = function(){
        smoothScroll("header");
    };
    document.getElementById("overlay").onclick = function(){
        document.getElementById("overlay").style.display = "none";
    };
    document.getElementById("connexion-button").onclick = function(){
        document.getElementById("login-overlay").style.display = "block";
    };

    document.getElementById("log-back").onclick = function(){
        document.getElementById("login-overlay").style.display = "none";
    };


    getText(0);
    getText(1);
    getText(2);
    getText(3);

};

window.onscroll = function(){
    displayTopPageButton(currentYPosition());
};