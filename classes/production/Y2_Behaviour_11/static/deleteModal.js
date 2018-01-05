//Taken from modal.js and adapted as appropriate

function showDeleteModal(activityId) {
    document.getElementById('selected_delete_activity_id').value = activityId;
    document.getElementById('deleteModal').style.display = "block"


}

document.getElementById("deleteModalClose").onclick = function() {
    document.getElementById('deleteModal').style.display = "none"


}

