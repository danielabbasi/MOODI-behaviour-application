//Taken from modal.js and adapted as appropriate

function showModal(activityId) {
    document.getElementById('selected_activity_id').value = activityId;
    document.getElementById('rate_modal').style.display = "block";
}

document.getElementsByClassName("close")[0].onclick = function() {
    document.getElementsByClassName("close")[0].style.display = "none";
}

window.onclick = function(event) {
    if (event.target == modal) {
        document.getElementsByClassName("close")[0].style.display = "none";
    }
}