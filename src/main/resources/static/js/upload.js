var auth = firebase.auth();
var storageRef = firebase.storage().ref();

function handleFileSelect(evt) {

    evt.stopPropagation();
    evt.preventDefault();
    var file = evt.target.files[0];

    $('#uploadedFiles').append('<a href="#" class="list-group-item list-group-item-success file-list"><span class="badge alert-success pull-right"><span class="glyphicon glyphicon-remove"></span></span>' + file.name + '</a>');

    var uploadTask = storageRef.child(file.name).put(file);

    uploadTask.on(firebase.storage.TaskEvent.STATE_CHANGED, function(snapshot) {

            var progress = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
            console.log('Upload is ' + progress + '% done');
            switch (snapshot.state) {
                case firebase.storage.TaskState.PAUSED:
                    console.log('Upload is paused');
                    break;
                case firebase.storage.TaskState.RUNNING:
                    console.log('Upload is running');
                    break;
            }

        }, function(error) {

            console.log("ajajajajaj, valami error történt");

        }, function() {

            var downloadURL = uploadTask.snapshot.downloadURL;

            console.log(downloadURL);
            // $('#uploadedFiles').append('<li>Működőcske linkecske: ' + downloadURL + '</li>');

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