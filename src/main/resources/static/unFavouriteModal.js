//Taken from modal.js and adapted as appropriate

function showUnFavouriteModal(activityId) {
    document.getElementById('selected_unFavourite_activity_id').value = activityId;
    document.getElementById('unFavourite_modal').style.width = "20%";
    document.getElementById('unFavourite_modal').style.paddingTop = "200px";

}

document.getElementById("unFavourite_close").onclick = function() {
    document.getElementById('unFavourite_modal').style.width="0";
    document.getElementById('unFavourite_modal').style.paddingTop = "0";

    // document.getElementById('delete_modal').style.height="0";

}

window.onclick = function(event) {
    if (event.target == modal) {
        document.getElementById('unFavourite_modal').style.display = "none";
    }
}