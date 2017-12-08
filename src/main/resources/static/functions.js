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
    httpRequest.open("POST", "/api/patient/1/activities/" + activityId + "/rate?ratingAfter=" + testResultNumber)
    httpRequest.send();
}

function sendRatingBefore() {
    var completeButton = document.getElementById("completeButton");
    completeButton.innerHTML = "Sending Score (please wait)...";
    completeButton.disabled = true;
    var activityId = document.getElementById("notificationId").value;
    // console.log(activityId)
    var testResult = document.getElementById("test-result-x").innerHTML.toLowerCase();
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
    httpRequest.open("POST", "/api/patient/1/activities/" + activityId + "/before/rate?ratingBefore=" + testResultNumber)
    httpRequest.send();

    return false;
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
    httpRequest.open("POST", "/api/patient/1/activities/" + activityId + "/delete")
    httpRequest.send();
}


function favouriteActivity() {
    var completeButton = document.getElementById("favourite_button");
    completeButton.innerHTML = "Favouriting (please wait)...";
    completeButton.disabled = true;
    var activityId = document.getElementById("selected_favourite_activity_id").value;
    var httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = function() {
        window.setTimeout(refreshPage,1000);
    }
    httpRequest.open("POST", "/api/patient/1/activities/" + activityId + "/favourite")
    httpRequest.send();
}

function unFavouriteActivity() {
    var completeButton = document.getElementById("unFavourite_button");
    completeButton.innerHTML = "Removing (please wait)...";
    completeButton.disabled = true;
    var activityId = document.getElementById("selected_unFavourite_activity_id").value;
    var httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = function() {
        window.setTimeout(refreshPage,1000);
    }
    httpRequest.open("POST", "/api/patient/1/activities/" + activityId + "/unfavourite")
    httpRequest.send();
}

function editActivity() {
    var completeButton = document.getElementById("editActivityBtn");
    completeButton.innerHTML = "Editing (please wait)...";
    completeButton.disabled = true;
    var activityId = document.getElementById("selected_edit_activity_id").value;
    // var activityName = document.getElementById("activityName").value;
    // var activityDate = document.getElementById("activityDate").value;
    // var d = new Date(activityDate);
    console.log();
    var httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = function() {
        window.setTimeout(refreshPage,1000);
    }

    $.ajax({

        type: "POST",
        url:"http://localhost:8080/api/patient/1/activities/" + activityId + "/update",
        data: "date=" + encodeURIComponent($('#activityDate').val()),
        dataType: "HTML",
        success: function (data) {

            window.location.href = "1";

        },
        error : function(data){

        }


});

}





function refreshPage() {
    location.reload();
}