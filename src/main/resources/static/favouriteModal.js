//Taken from modal.js and adapted as appropriate

function showFavouriteModal(activityId) {
    document.getElementById('selected_favourite_activity_id').value = activityId;
    document.getElementById('favouriteModal').style.display = "block";


}

    document.getElementById("closeBtnFavourites").onclick = function() {
    document.getElementById('favouriteModal').style.display="none";



}

