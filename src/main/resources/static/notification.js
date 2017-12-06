/**
 * Created by c1443907 on 06/12/2017.
 */


$('#modal').bind('DOMNodeInserted DOMNodeRemoved', function() {
    document.getElementById('modal').style.display = "block";
    document.getElementById('greetings').style.color = "#00b3b3";
    document.getElementById('greetings').style.textAlign = "center";


});