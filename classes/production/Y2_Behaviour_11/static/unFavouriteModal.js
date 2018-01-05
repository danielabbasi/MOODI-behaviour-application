//Taken from modal.js and adapted as appropriate

function showUnFavouriteModal(activityId) {
    document.getElementById('selected_unFavourite_activity_id').value = activityId;
    document.getElementById('unfavouriteModal').style.display = "block"


}

document.getElementById("unfavouriteModalClose").onclick = function() {
    document.getElementById('unfavouriteModal').style.display="none";


    // document.getElementById('delete_modal').style.height="0";

}

