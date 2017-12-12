//Taken from modal.js and adapted as appropriate

function showModal(activityId) {
    document.getElementById('selected_activity_id').value = activityId;
    document.getElementById('rateModal').style.display = "block";
}

document.getElementById("rateModalClose").onclick = function() {
    document.getElementById('rateModal').style.display="none";
}

