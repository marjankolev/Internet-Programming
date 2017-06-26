function setCookie(c_ime, c_vrednost, traenje_denovi) {
    var d = new Date();
    d.setTime(d.getTime() + (traenje_denovi*24*60*60*1000));
    var istekuva = "expires="+d.toUTCString();
    document.cookie = c_ime + "=" + c_vrednost + "; " + istekuva;
}

function getCookie(c_ime) {
    var ime = c_ime + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1);
        if (c.indexOf(ime) == 0) return c.substring(ime.length,c.length);
    }
    return "";
}

function checkCookie() {
    var username=getCookie("username");
    if (username!="") {
        alert("Welcome again " + username);
    }else{
        username = prompt("Please enter your name:", "");
        if (username != "" && username != null) {
            setCookie("username", username, 365);
        }
    }
}