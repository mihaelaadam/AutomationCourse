function readInputText(event) {
    event.preventDefault();

    var usernameText = document.getElementById("username").value;
    var passText = document.getElementById("pass").value;
    var passrepeatText = document.getElementById("passrepeat").value;
    var emailText = document.getElementById("email").value;
    var verifEmail = "";
    var result = "";
    var funny = "";

      var VerifAt = -1;
      var VerifDot = -1;
      var i = 0;

        if (usernameText.length > 20)
        {
            alert("The max size of 20 has been exceeded.");
            document.getElementById("username").style.color="red";
        }
        else if (usernameText == " " || usernameText == "")
        {
            alert("The username must contain at least one character.");
        }
        else if (passText.length < 8 || passText.length > 30)
        {
            alert("The password must contain between 8 and 20 characters.");
        }
        else if (passText != passrepeatText)
        {
            alert("Passwords do not match. Please try again.");
        }
        else if (!emailText.includes("@") || !emailText.includes(".") || emailText == "")
         {
            alert("Email adress is incomplete.");
         }
        else
        {
            document.getElementById("result").innerHTML = "Welcome " + usernameText;
        }
}

function funnyButton() {
    var usernameText = document.getElementById("username").value;
    var passText = document.getElementById("pass").value;
    var passrepeatText = document.getElementById("passrepeat").value;
    var emailText = document.getElementById("email").value;
    var verifEmail = "";
    var result = "";
    var funny = "";

      var VerifAt = -1;
      var VerifDot = -1;
      var i = 0;

    if (usernameText == "" && passText == "" && emailText == "")
        {
            funny = "Cook up a combination of username, password, and email for a satisfying security meal!";
        }
      else if (emailText == "")
        {
            funny = "Hey, " + usernameText + "! Your password is like a perfectly seasoned dish! Don't forget to pair it with the perfect email.";
        }
      else if (passText == "")
        {
            funny = "Hello, " + usernameText + "Your email is the secret sauce. Combine it with a password for a delightful feast of security.";
        }
      else if (usernameText == "")
        {
            funny = "Hey there, security chef! Add a little bit of username to enhance the taste.";
        }
      else
        {
            funny = "You've just prepared a delicious feast of security!";
        }
      alert(funny);
}