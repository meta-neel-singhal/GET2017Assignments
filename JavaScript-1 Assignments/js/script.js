function Contact() {
   window.location = "contact.html";
}
function Home() {
   window.location = "index.html";
}

function validateName(){
	var x;
	if ((x = document.forms["contact-us"]["username"].value) == "" || !x.match( /^[a-zA-z]+$/)){
		document.forms["contact-us"]["username"].style.border = "2px solid red";
		return false;
	} else{
        document.forms["contact-us"]["username"].style.border = "2px solid green";
        return true;
	}
}

function validateEmail(){
	var x;	
	if((x = document.forms["contact-us"]["useremail"].value) == "" || !x.match(/[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$/)){
		document.forms["contact-us"]["useremail"].style.border = "2px solid red";
		return false;
	} else{
	    document.forms["contact-us"]["useremail"].style.border = "2px solid green";
	    return true;
	}
}

function validateOrganization(){
	var x;
	if((x = document.forms["contact-us"]["userorg"].value) == "" || !x.match(/^[a-zA-z]+$/)){
	    document.forms["contact-us"]["userorg"].style.border = "2px solid red";
		return false;
	} else{
		document.forms["contact-us"]["userorg"].style.border = "2px solid green";
	    return true;
	}		
}

function validatePhoneNumber(){
	var x;
    if((x = document.forms["contact-us"]["usercontact"].value) == "" || !x.match(/^[0-9]{6,12}$/)){
        document.forms["contact-us"]["usercontact"].style.border = "2px solid red";
        return false;
	} else{
		document.forms["contact-us"]["usercontact"].style.border = "2px solid green";
	    return true;
	}	
}

function validateMessage(){

    if(document.getElementById("usermessage").value == "" || document.getElementById("message").value.length>250){
        document.getElementById("usermessage").style.border = "2px solid red";
        return false;
	} else{
		document.getElementById("usermessage").style.border = "2px solid green";
	    return true;
	}	
}

function validateForm(){
    if(!validateName() || !validateEmail() || !validateOrganization() || !validateMessage() || !validatePhoneNumber()){
        validateName();
        validateEmail();
        validateOrganization();
        validatePhoneNumber();
        validateMessage();
        cityOption();
        return false;
    }
    return true;
}

function cityOption(){
	document.getElementById("selectedcity").style.visibility = "visible";
	var element = document.getElementById("usercity");
	var selectedValue = element.options[element.selectedIndex].value;

	if(selectedValue == "default"){
		document.getElementById("usercity").style.border = "2px solid red";
		document.getElementById("selectedcity").value = "No option selected";
	} else{
	    document.getElementById("selectedcity").value = selectedValue;
	}
}