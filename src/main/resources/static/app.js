/**
 * Created by c1673218 on 04/12/2017.
 */
var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html();
}

function connect() {
    var socket = new SockJS('/gs-guide-ActivityNotifier');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('CONNECTED TO FRAME : ' + frame);
        stompClient.subscribe('/topic/greetings', function (message) {
            showGreeting(message);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}


function showGreeting(message) {
    $("#greetings").append("<p>" + message.body + "</p>");
}

$(document).ready(function () {
    connect(); // this works
    console.log("CONNNECTED");
});