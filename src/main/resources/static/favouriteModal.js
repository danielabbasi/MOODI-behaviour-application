//Taken from modal.js and adapted as appropriate

function showFavouriteModal(activityId) {
    document.getElementById('selected_favourite_activity_id').value = activityId;
    document.getElementById('favourite_modal').style.width = "20%";
    document.getElementById('favourite_modal').style.paddingTop = "200px";

}

document.getElementById("favourite_close").onclick = function() {
    document.getElementById('favourite_modal').style.width="0";
    document.getElementById('favourite_modal').style.paddingTop = "0";

    // document.getElementById('delete_modal').style.height="0";

}

window.onclick = function(event) {
    if (event.target == modal) {
        document.getElementById('favourite_modal').style.display = "none";
    }
}