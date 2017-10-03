function expand() {
    var x = document.getElementById("myTopnav");
    if (x.className === "topnav") {
        x.className += " responsive";
        $("#navigationbar").css("margin-bottom", 225);
        $("#centralblock").css("height", "+=225px");
    } else {
        x.className = "topnav";
        $("#navigationbar").css("margin-bottom", 10);
        $("#centralblock").css("height", "-=225px");
    }
}