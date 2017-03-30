var auth = firebase.auth();
var storageRef = firebase.storage().ref();

function handleFileSelect(evt) {

    evt.stopPropagation();
    evt.preventDefault();
    var file = evt.target.files[0];

    var uploadTask = storageRef.child(file.name).put(file);
    uploadTask.on('state_changed', function progressHandler(snapshot) {
        var percent = snapshot.bytesTransferred / snapshot.totalBytes * 100;
        console.log(percent + "% done");
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