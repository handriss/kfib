var auth = firebase.auth();
var storageRef = firebase.storage().ref();

function handleFileSelect(evt) {

    evt.stopPropagation();
    evt.preventDefault();
    var file = evt.target.files[0];

    // $('#uploadedFiles').append('<a href="#" class="list-group-item list-group-item-success file-list"><span class="badge alert-success pull-right"><span class="glyphicon glyphicon-remove"></span></span>' + file.name + '</a>');
    $('#uploadedFiles').append('<a href="#"><div class="alert alert-info alert-labeled"><button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">×</span><span class="sr-only">Bezárás</span></button><div class="alert-labeled-row file-list"><p class="alert-body alert-body-right alert-labelled-cell">' + file.name + '</p></div></div></a>');

    var uploadTask = storageRef.child(file.name).put(file);

    uploadTask.on(firebase.storage.TaskEvent.STATE_CHANGED, function(snapshot) {

        var progress = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
        $('#uploadedFiles a:last-child div').width(progress + '%');
        console.log($('#uploadedFiles a:last-child div'));


    }, function(error) {

            console.log("ajajajajaj, valami error történt");

        }, function() {

            var downloadURL = uploadTask.snapshot.downloadURL;

            $('#uploadedFiles a:last-child').attr('href', downloadURL);

        });

}

window.onload = function() {
    document.getElementById('file').addEventListener('change', handleFileSelect, false);
    document.getElementById('file').disabled = true;

    auth.onAuthStateChanged(function(user) {
        if (user) {
            document.getElementById('file').disabled = false;
        } else {
            auth.signInAnonymously();
        }
    });
};