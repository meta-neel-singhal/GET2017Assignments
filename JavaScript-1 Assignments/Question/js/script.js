function Contact() {
   window.location = "contact.html";
}
function Home() {
   window.location = "index.html";
}

function validateName(){
	var data;
	document.getElementById("username").maxLength="20";
	if ((data = document.forms["contact-us"]["username"].value) == "" || !data.match( /^[a-zA-z]+$/)){
		document.forms["contact-us"]["username"].style.border = "2px solid #f00";
		return false;
	} else{
        document.forms["contact-us"]["username"].style.border = "2px solid #0f0";
        return true;
	}
}

function validateEmail(){
	var data;	
	if((data = document.forms["contact-us"]["useremail"].value) == "" || !data.match(/[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,20}$/)){
		document.forms["contact-us"]["useremail"].style.border = "2px solid #f00";
		return false;
	} else{
	    document.forms["contact-us"]["useremail"].style.border = "2px solid #0f0";
	    return true;
	}
}

function validateOrganization(){
	var data;
	if((data = document.forms["contact-us"]["userorg"].value) == "" || !data.match(/^[a-zA-z]+$/)){
	    document.forms["contact-us"]["userorg"].style.border = "2px solid #f00";
		return false;
	} else{
		document.forms["contact-us"]["userorg"].style.border = "2px solid #0f0";
	    return true;
	}		
}

function validatePhoneNumber(){
	var data;
    if((data = document.forms["contact-us"]["usercontact"].value) == "" || !data.match(/^[0-9]{6,12}$/)){
        document.forms["contact-us"]["usercontact"].style.border = "2px solid #f00";
        return false;
	} else{
		document.forms["contact-us"]["usercontact"].style.border = "2px solid #0f0";
	    return true;
	}	
}

function validateMessage(){
	var data;
	document.getElementById("usermessage").maxLength="250";
    if((data = document.forms["contact-us"]["usermessage"].value) == ""){
        document.forms["contact-us"]["usermessage"].style.border = "2px solid #f00";
        return false;
	} else{
		document.forms["contact-us"]["usermessage"].style.border = "2px solid #0f0";
	    return true;
	}
}

function validateForm(){
    if(!validateName() || !validateEmail() || !validateOrganization() || !validateMessage() || !validatePhoneNumber() || !cityOption() ){
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
		document.getElementById("usercity").style.border = "2px solid #f00";
		document.getElementById("selectedcity").value = "No option selected";
		return false;
	} else{
		document.getElementById("usercity").style.border = "2px solid #0f0";
		document.getElementById("selectedcity").value = selectedValue;
		return true;
	}
}

function isNumberKey(event){
	var charCode = (event.which) ? event.which : event.keyCode;
	if (charCode > 31 && (charCode < 48 || charCode > 57)) {
		return false;
	}
	return true;
}

function isText(event){
	var charCode = (event.which) ? event.which : event.keyCode;
	if (!(charCode < 48 || charCode > 57)){
		return false;
	}
	return true;
}