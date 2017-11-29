//Taken from modal.js and adapted as appropriate

function showDeleteModal(activityId) {
    document.getElementById('selected_delete_activity_id').value = activityId;
    document.getElementById('delete_modal').style.display = "block";
}

document.getElementById("delete_close").onclick = function() {
    document.getElementById('delete_modal').style.display = "none";
}

window.onclick = function(event) {
    if (event.target == modal) {
        document.getElementById('delete_modal').style.display = "none";
    }
}