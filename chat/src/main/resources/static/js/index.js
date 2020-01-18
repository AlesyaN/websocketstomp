function register() {
    var nameInput = $("#name");
    $.ajax({
        url: "/register",
        data: {
            name: nameInput.val()
        },
        method: "post",
        success: function (token) {
            window.localStorage.setItem("token", token);
            $("#roomName").prop("disabled", false);
            $("#addRoom").prop("disabled", false);
            toggleRoomsDisable();
            nameInput.prop("disabled", true);
            $("#send").prop("disabled", true);
        }
    });
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $("#send").click(function () {
        register();
    });
    $("#roomName").prop("disabled", true);
    $("#addRoom").prop("disabled", true);
    $("#addRoom").click(function () {
        addRoom();
        $("#roomName").val('');
    });
    $.ajax({
        url: "/room/all",
        method: "get",
        success: function (rooms) {
            for (var i = 0; i < rooms.length; i++) {
                appendRoomButton(rooms[i]);
            }
            toggleRoomsDisable();
        }
    });

});

function toggleRoomsDisable() {
    var children = Array.from(document.getElementById("rooms").children);
    console.log(children);
    for (var i = 0; i < children.length; i++) {
        console.log(children[i] + " " + children[i].disabled);
        children[i].disabled = !children[i].disabled;
    }
}

function addRoom() {
    $.ajax({
        url: "/room/add",
        data: {
            name: $("#roomName").val()
        },
        method: "post",
        success: function (room) {
            appendRoomButton(room);
        }
    });
}

function appendRoomButton(room) {
    var button = document.createElement("button");
    button.onclick = function (ev) {
        window.location.href = "/" + room.id;
    };
    button.className = "btn btn-default";
    button.innerText = room.name;
    $("#rooms").append(button);
}