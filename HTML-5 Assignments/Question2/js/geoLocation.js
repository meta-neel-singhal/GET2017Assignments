var show = document.getElementById("display");
var error = document.getElementById("loader");

function getLocation() {
	document.getElementById("loader").style.display = "block";
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition);
    } 
	else { 
        error.innerHTML = "Geolocation is not supported by this browser.";
    }
}
function showPosition(position) {
	document.getElementById("loader").style.display = "block";
    show.innerHTML = "<div>Latitude: " + position.coords.latitude + 
    "</div><div>Longitude: " + position.coords.longitude + "</div>";
    document.getElementById("right-box").style.display = "block";
    document.getElementById("loader").style.display = "none";
}