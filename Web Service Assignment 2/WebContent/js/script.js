'use strict'

/**
 * 
 */
window.onload = function () {

    //document.getElementById('start').addEventListener('click', startWorker);
};

function openTab(event, retrieve) {
    var count, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName('cover');
    // To hide the contents of the tab which is not selected.
    for (count = 0; count < tabcontent.length; count++) {
        tabcontent[count].style.display = 'none';
    }
    tablinks = document.getElementsByClassName('tablinks');
    // To change the status of active tab to none. 
    for (count = 0; count < tablinks.length; count++) {
        tablinks[count].className = tablinks[count].className.replace(' active', '');
    }
    // To display the contents of the selected tab.
    document.getElementById(retrieve).style.display = 'block';
    // To change the status of the selected tab to active.
    event.currentTarget.className += ' active';
}

function retrieve() {
    window.location.href = 'retrieve.html';
}

function createEmployee() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        // Ready State: 4 means Request finished and response is ready.
        // Status: 200 meansserver response is OK. 
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("result").innerHTML = "Employee created successfully.";
        }
    };
    xhttp.open("POST", "http://localhost:8080/Web_Service_-_Assignment_2/rest/EmployeeService/employees/" + document.getElementById("empId").innerHTML + "/" + document.getElementById("firstName").innerHTML + "/" + document.getElementById("lastName").innerHTML + "/" + document.getElementById("empAge").innerHTML, true);
    xhttp.send();
}

function deleteEmployee() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        // Ready State: 4 means Request finished and response is ready.
        // Status: 200 meansserver response is OK. 
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("result").innerHTML = "Employee deleted successfully.";
        }
    };
    xhttp.open("DELETE", "http://localhost:8080/Web_Service_-_Assignment_2/rest/EmployeeService/employees/" + document.getElementById("empId").innerHTML, true);
    xhttp.send();
}

function getById() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        // Ready State: 4 means Request finished and response is ready.
        // Status: 200 meansserver response is OK. 
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("result").innerHTML = this.responseText;
        }
    };
    xhttp.open("GET", "http://localhost:8080/Web_Service_-_Assignment_2/rest/EmployeeService/employees/" + document.getElementById("empId").innerHTML, true);
    xhttp.send();
}

function getByName() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        // Ready State: 4 means Request finished and response is ready.
        // Status: 200 meansserver response is OK. 
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("result").innerHTML = this.responseText;
        }
    };
    xhttp.open("GET", "http://localhost:8080/Web_Service_-_Assignment_2/rest/EmployeeService/employees/" + document.getElementById("firstName").innerHTML + "/" + document.getElementById("lastName").innerHTML, true);
    xhttp.send();
}

function getAll() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        // Ready State: 4 means Request finished and response is ready.
        // Status: 200 meansserver response is OK. 
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("result").innerHTML = this.responseText;
        }
    };
    xhttp.open("GET", "http://localhost:8080/Web_Service_-_Assignment_2/rest/EmployeeService/employees/", true);
    xhttp.send();
}
