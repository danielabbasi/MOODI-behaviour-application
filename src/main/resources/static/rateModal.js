//Taken from modal.js and adapted as appropriate

function showModal(activityId) {
    document.getElementById('selected_activity_id').value = activityId;
    document.getElementById('rate_modal').style.width = "100%";
}

document.getElementById("rate_close").onclick = function() {
    document.getElementById('rate_modal').style.width="0";
}

window.onclick = function(event) {
    if (event.target == modal) {
        document.getElementById('rate_modal').style.display = "none";
    }
}