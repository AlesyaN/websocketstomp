var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
        $("#name").prop("disabled", connected);
        $("#send").prop("disabled", connected);
    }
    $("#greetings").html("");
}

function connect() {
    // создаем объект SockJs
    var socket = new SockJS('/messages');
    // создаем stomp-клиент поверх sockjs
    stompClient = Stomp.over(socket);
    // при подключении
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        // подписываемся на url
        stompClient.subscribe('/topic/chat', function (greeting) {
            showGreeting(greeting);
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

// отправка
function sendName() {
    // отправляем на определенный url
    console.log("sendName");
    $("#name").prop("disabled", true);
    $("#send").prop("disabled", true);
    stompClient.send("/app/hello", {}, $("#name").val());
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message.body + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});