//Taken from modal.js and adapted as appropriate

function showDeleteModal(activityId) {
    document.getElementById('selected_delete_activity_id').value = activityId;
    document.getElementById('delete_modal').style.display = "block";
}

document.getElementsByClassName("close")[0].onclick = function() {
    document.getElementsByClassName("close")[0].style.display = "none";
}

window.onclick = function(event) {
    if (event.target == modal) {
        document.getElementsByClassName("close")[0].style.display = "none";
    }
}