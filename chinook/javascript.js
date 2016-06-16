/**
 * Created by bendz on 20. 04. 2016.
 */




/*function login() {

    var xhttp = CreateXhttpObject();

        if (xhttp != false) {

            xhttp.onreadystatechange = function() {
                if (xhttp.readyState == 4 && xhttp.onreadystatechange() == 200) {
                    document.getElementById("error").innerHTML = xhttp.responseText;
                }
            }
        }

            //geting values from login form
        var username = encodeURIComponent(document.getElementById("username").value);
        var password = encodeURIComponent(document.getElementById("password").value);


        console.log(username,password);

            //sending values to login script
        xhttp.open("POST","login.php",true);
        xhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xhttp.send("username="+username,"&password="+password);
}

function CreateXhttpObject() {
     var xhttp;

    try {
         xhttp = new XMLHttpRequest();
    }catch(e) {
        try {
            xhttp = new ActiveXObject("Microsoft.HTTP");
        }catch(e) {
            return false;
        }
    }
}*/