function loadDoc() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("demo").innerHTML = this.responseText;
        }
    };
    xhttp.open("GET", "demo_get.asp", true);
    xhttp.send();
}

function markActivityAsComplete() {
    var completeButton = document.getElementById("complete_button");
    completeButton.innerHTML = "Mark Activity as Complete (please wait)...";
    completeButton.disabled = true;
    var activityId = document.getElementById("selected_activity_id").value;
    var testResult = document.getElementById("test-result").innerHTML.toLowerCase();
    var testResultNumber = 0;
    if(testResult == "very happy") {
        testResultNumber = 1;
    } else if(testResult == "happy") {
        testResultNumber = 2;
    } else if(testResult == "neutral") {
        testResultNumber = 3;
    } else if(testResult == "sad") {
        testResultNumber = 4;
    } else if(testResult == "upset") {
        testResultNumber = 5;
    } else {
        testResultNumber = 6;
    }
    var httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = function() {
        window.setTimeout(refreshPage,1000);
    }
    httpRequest.open("POST", "/api/patient/activities/" + activityId + "/rate?rating=" + testResultNumber)
    httpRequest.send();
}

function deleteActivity() {
    var completeButton = document.getElementById("delete_button");
    completeButton.innerHTML = "Delete Activity (please wait)...";
    completeButton.disabled = true;
    var activityId = document.getElementById("selected_delete_activity_id").value;
    var httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = function() {
        window.setTimeout(refreshPage,1000);
    }
    httpRequest.open("POST", "/api/patient/activities/" + activityId + "/delete")
    httpRequest.send();
}

function refreshPage() {
    location.reload();
}