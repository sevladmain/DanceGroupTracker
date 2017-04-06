function checkPass()
{
    //Store the password field objects into variables ...
    var pass1 = document.getElementById('register-password');
    var pass2 = document.getElementById('confirm-password');
    //Store the Confimation Message Object ...
    var message = document.getElementById('checkinpassword.errors');
    //Set the colors we will be using ...
    //var goodColor = "#66cc66";
    //var badColor = "#ff6666";
    //Compare the values in the password field
    //and the confirmation field
    var confirmButton = document.getElementById('register-submit');
    if(pass1.value == pass2.value){
        confirmButton.disabled = false;
        //The passwords match.
        //Set the color to the good color and inform
        //the user that they have entered the correct password
        /*pass2.style.backgroundColor = goodColor;
        message.style.color = goodColor;
        message.innerHTML = "Passwords Match!"*/
        message.style.display = "none";
    }else{
        //The passwords do not match.
        //Set the color to the bad color and
        //notify the user.
        /*pass2.style.backgroundColor = badColor;
        message.style.color = badColor;
        message.innerHTML = "Passwords Do Not Match!"*/
        message.style.display = "";
    }
}