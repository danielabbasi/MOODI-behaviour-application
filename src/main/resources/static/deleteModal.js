//Taken from modal.js and adapted as appropriate

function showDeleteModal(activityId) {
    document.getElementById('selected_delete_activity_id').value = activityId;
    document.getElementById('delete_modal').style.width = "20%";
    document.getElementById('delete_modal').style.paddingTop = "200px";

}

document.getElementById("delete_close").onclick = function() {
    document.getElementById('delete_modal').style.width="0";
    document.getElementById('delete_modal').style.paddingTop = "0";

    // document.getElementById('delete_modal').style.height="0";

}

window.onclick = function(event) {
    if (event.target == modal) {
        document.getElementById('delete_modal').style.display = "none";
    }
}