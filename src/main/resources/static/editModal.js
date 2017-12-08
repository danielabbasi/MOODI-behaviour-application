/**
 * Created by c1443907 on 07/12/2017.
 */


function showEditModal(activityId) {
    document.getElementById('selected_edit_activity_id').value = activityId;
    document.getElementById('fullScreenUpdate').style.width = "100%";
}

document.getElementById("closeBtnEdit").onclick = function() {
    document.getElementById('fullScreenUpdate').style.width="0";
}


