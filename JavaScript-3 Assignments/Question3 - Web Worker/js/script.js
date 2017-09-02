'use strict' // For strict mode.

var webWorker = {}; // Global variable declaration.

/**
 * Display the current date and time.
 * Set up eventListeners when window is loaded.
 */
window.onload = function() {
    showDate();

    document.getElementById('start').addEventListener('click', startWorker);
    document.getElementById('stop').addEventListener('click', stopWorker);
    document.getElementById('reset').addEventListener('click', reset);
    document.getElementById('hold').addEventListener('click', hold);
    document.getElementById('showDate').addEventListener('click', showDate);
    document.getElementById('printDate').addEventListener('click', showDate);
};

/**
 * Checks if web worker is compatible with the browser.
 * If the webWorker is of object type it calls the web_worker.js file.
 */
function startWorker() {
    var result = document.getElementById('result');
    if ('undefined' !== typeof Worker) {
        if ('object' === typeof webWorker) {
            webWorker = new Worker('js/web_worker.js');
        }
        // Gets the value of date and time from web_worker.js file.
        webWorker.onmessage = function(event) {
            result.innerHTML = event.data;
        }
    } else {
        result.innerHTML = 'NOT SUPPORTED';
    }
}

/**
 * Stops the running web worker.
 */
function stopWorker() {
    webWorker.terminate();
    document.getElementById('result').innerHTML = 'Web Worker is stopped.';
};

/**
 * Resets the web worker to use it again.
 */
function reset() {
    document.getElementById('result').innerHTML = 'Your Result Will Appear Here...';
    webWorker = {};
}

/**
 * Used to set up the tabs. Displays the active tab and its corresponding data.
 * 
 * @param {*} event 
 * @param {*} webWorkerPresence 
 */
function openWebWorker(event, webWorkerPresence) {
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
    document.getElementById(webWorkerPresence).style.display = 'block';
    // To change the status of the selected tab to active.
    event.currentTarget.className += ' active';
}

/**
 * Hold the execution for two minutes (without the use of web worker).
 */
function hold() {
    show.innerHTML = 'Message Box';
    setTimeout(function () {
        show.innerHTML = 'Hold for 2 minutes is over.';
    }, 120000);
}

/**
 * Displays the current date and time in the browser.
 */
function showDate() {
    var date = new Date();
    alert(date);
}
