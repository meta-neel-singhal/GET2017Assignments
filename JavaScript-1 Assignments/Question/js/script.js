/**
 * Set up eventListeners when window is loaded.
 * Helps to se up navigation and check validations on inputs.
 */
window.onload = function() {
	document.getElementById('home').addEventListener('click',function(event){
		location.href = 'index.html';
	});
	document.getElementById('contact').addEventListener('click',function(event){
		location.href = 'contact.html';
	});
	document.getElementById('username').addEventListener('keyup',validateName);
    document.getElementById('useremail').addEventListener('keyup',validateEmail);
    document.getElementById('userorg').addEventListener('keyup',validateOrganization);
	document.getElementById('usercontact').addEventListener('keyup',validatePhoneNumber);
	document.getElementById('usercity').addEventListener('change',cityOption);
    document.getElementById('usermessage').addEventListener('keyup',validateMessage);
	document.getElementById('contact-us').addEventListener('submit',validateForm);
	//document.getElementById('username').addEventListener('keypress',isText);
};

/**
 * Validates the name input.
 */
function validateName() {
	var data = document.forms['contact-us']['username'];
	var result = {};
	data.maxLength = '20';
	if ('' === data.value || !data.value.match( /^[a-zA-z]+$/)) {
		data.style.border = '2px solid #f00';
		result = false;
	} else {
        data.style.border = '2px solid #0f0';
        result = true;
	}

	return result;
}

/**
 * Validates the email input.
 */
function validateEmail() {
	var data = document.forms['contact-us']['useremail'];
	var result = {};
	if ('' === data.value || !data.value.match(/[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,20}$/)) {
		data.style.border = '2px solid #f00';
		result = false;
	} else {
	    data.style.border = '2px solid #0f0';
	    result = true;
	}

	return result;
}

/**
 * Validates the organization input.
 */
function validateOrganization() {
	var data = document.forms['contact-us']['userorg'];
	var result = {};
	if ('' === data.value || !data.value.match(/^[a-zA-z]+$/)) {
	    data.style.border = '2px solid #f00';
		result = false;
	} else {
		data.style.border = '2px solid #0f0';
	    result = true;
	}	

	return result;	
}

/**
 * Validates the contact number input.
 */
function validatePhoneNumber() {
	var data = document.forms['contact-us']['usercontact'];
	var result = {};
    if ('' === data.value || !data.value.match(/^[0-9]{6,12}$/)) {
        data.style.border = '2px solid #f00';
        result = false;
	} else {
		data.style.border = '2px solid #0f0';
	    result = true;
	}	

	return result;
}

/**
 * Validates the message input.
 */
function validateMessage() {
	var data = document.forms['contact-us']['usermessage'];
	var result = {};
	data.maxLength = '250';
    if ('' === data.value) {
        data.style.border = '2px solid #f00';
        result = false;
	} else {
		data.style.border = '2px solid #0f0';
	    result = true;
	}

	return result;
}

/**
 * Validates the whole form on submit.
 */
function validateForm() {
    if (!validateName() || !validateEmail() || !cityOption() || !validateOrganization() || !validatePhoneNumber() || !validateMessage()) {
        result = false;
    } else {
    	result = true;
	}
	return result;
}

/**
 * Validates the city option.
 */
function cityOption() {
	var data = document.getElementById('selectedcity');
	var element = document.getElementById('usercity');
	var selectedValue = element.options[element.selectedIndex].value;
	var result = {};
	data.style.visibility = 'visible';

	if ('default' === selectedValue) {
		element.style.border = '2px solid #f00';
		data.value = 'No option selected';
		result = false;
	} else {
		element.style.border = '2px solid #0f0';
		data.value = selectedValue;
		result = true;
	}

	return result;
}



/*
function isNumberKey(event) {
	var charCode = (event.which) ? event.which : event.keyCode;
	if (charCode > 31 && (charCode < 48 || charCode > 57)) {
		return false;
	}
	return true;
}
function isText(event) {
	var charCode = (event.which) ? event.which : event.keyCode;
	if (!(charCode < 48 || charCode > 57)) {
		return false;
	}
	return true;
}
*/
/*
function isText(event) {
	var result = {};
	if (isNaN(String.fromCharCode(event.keyCode))) {
		result = true;
	} else {
		result = false;
	}

	return result;
}*/
