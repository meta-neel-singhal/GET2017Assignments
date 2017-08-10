function init_count(){
	document.getElementById("logout").style.display = "none";
	if(localStorage.getItem("key1") === null){
		localStorage.setItem("key1", 0);
	}
}

function logIn(){
	var userName = document.getElementById("username").value;
	var pass = document.getElementById("password").value;
	var count = localStorage.getItem("key1");
	if(userName == "Neel" && pass == "nks") {
		localStorage.setItem("key1", parseInt(count) + 1);
		document.getElementById("msg").innerHTML = "Your login count is: " + localStorage.getItem("key1");
		username.value = "";
		password.value = "";
		document.getElementById("user").style.display = "none";
		document.getElementById("pass").style.display = "none";
		document.getElementById("login").style.display = "none";
		document.getElementById("logout").style.display = "inline";
	} else {
		username.value = "";
		password.value = "";
		document.getElementById("msg").innerHTML = "Enter valid credentials.";
	}
}

function logOut(){
	document.getElementById("logout").style.display = "none";
	document.getElementById("user").style.display = "block";
	document.getElementById("pass").style.display = "block";
	document.getElementById("login").style.display = "inline";
}