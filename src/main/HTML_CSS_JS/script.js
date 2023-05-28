function clickMe() {
    var var1 = "abc";
    var var2 = 5;
    var var3 = false;
    //alert("hello !!!");
    //readInputText();
}

function readInputText() {
    var usernameText = document.getElementById("username").value;
    var result = "";
        if (usernameText.length > 10)
        {
            //alert("The max size of 10 has been exceeded");
            result = "The max size of 10 has been exceeded";
            //document.getElementById("username").style.color="red";
        }
    //alert("The username is " + usernameText);
    document.getElementById("result").innerHTML = "the username is " + usernameText;
}