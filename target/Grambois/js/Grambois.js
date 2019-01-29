
window.onload = function(){
    document.getElementById("accueil-button").onclick = function(){
        smoothScroll("accueilText1");
    };
    document.getElementById("gite-button").onclick = function(){
    	smoothScroll("accueilText2");
    };
    document.getElementById("chambres-button").onclick = function(){
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

};

window.onscroll = function(){
    displayTopPageButton(currentYPosition());
};