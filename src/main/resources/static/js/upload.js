var auth = firebase.auth();
var storageRef = firebase.storage().ref();

function handleFileSelect(evt) {
    evt.stopPropagation();
    evt.preventDefault();
    var file = evt.target.files[0];

    var metadata = {
        'contentType': file.type
    };

    storageRef.child('images/' + file.name).put(file, metadata).then(function(snapshot) {
        var url = snapshot.downloadURL;
        document.getElementById('linkbox').innerHTML = '<a href="' +  url + '">Click For File</a>';
    }).catch(function(error) {
        console.error('Upload failed:', error);
    });
}

window.onload = function() {
    document.getElementById('file').addEventListener('change', handleFileSelect, false);
    document.getElementById('file').disabled = true;

    auth.onAuthStateChanged(function(user) {
        if (user) {
            console.log('Anonymous user signed-in.', user);
            document.getElementById('file').disabled = false;
        } else {
            console.log('There was no anonymous session. Creating a new anonymous user.');
            auth.signInAnonymously();
        }
    });
}