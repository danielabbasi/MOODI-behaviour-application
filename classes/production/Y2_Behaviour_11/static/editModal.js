/**
 * Created by c1443907 on 07/12/2017.
 */


function showEditModal(activityId) {
    document.getElementById('selected_edit_activity_id').value = activityId;
    document.getElementById('editModal').style.display = "block"
}

document.getElementById("closeBtnEdit").onclick = function() {
    document.getElementById('editModal').style.display = "none"
}


