$(document).ready(function(){

    setInterval('updateChatHistory()', 1000);

    $('input#postMessage').click(onClickPostMessage);
});


function onClickPostMessage() {
    var text = $('textarea#chatMessage').val();
    postChatMessage(text);
}

function updateChatHistory(){
    $.ajax({
        type : 'GET',
        url : '/loadChatHistoryAJAX.json',
        dataType : 'json',
        success : function(data){
            $('#chat').html(data.data);
        },
        error : function(e) {
            $('#chat').html("<p>Sergey pidor</p>");
        }
    });
}

function postChatMessage(message) {
    $.ajax({
        type : 'POST',
        url : '/postMessageAJAX.json',
        dataType : 'json',
        data : {
            text : message
        },
        success : function(){
                $('textarea#chatMessage').val('');
        },
        error : function(e) {
        }
    });
}