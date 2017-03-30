var auth = firebase.auth();
var storageRef = firebase.storage().ref();

function handleFileSelect(evt) {
    evt.stopPropagation();
    evt.preventDefault();
    var file = evt.target.files[0];

    var metadata = {
        'contentType': file.type
    };

    // Push to child path.
    // [START oncomplete]
    storageRef.child('images/' + file.name).put(file, metadata).then(function(snapshot) {
        console.log('Uploaded', snapshot.totalBytes, 'bytes.');
        console.log(snapshot.metadata);
        var url = snapshot.downloadURL;
        console.log('File available at', url);
        // [START_EXCLUDE]
        document.getElementById('linkbox').innerHTML = '<a href="' +  url + '">Click For File</a>';
        // [END_EXCLUDE]
    }).catch(function(error) {
        // [START onfailure]
        console.error('Upload failed:', error);
        // [END onfailure]
    });
    // [END oncomplete]
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
            // Sign the user in anonymously since accessing Storage requires the user to be authorized.
            auth.signInAnonymously();
        }
    });
}



// $(document).ready(function(){
//
//     var files;
//     initializeFirebase();
//
//     function initializeFirebase(){
//         var config = {
//             apiKey: "AIzaSyAQguIPlj06NUO7AL6niuH0DIHx4sBmto0",
//             authDomain: "kfib-d5ded.firebaseapp.com",
//             databaseURL: "https://kfib-d5ded.firebaseio.com",
//             storageBucket: "kfib-d5ded.appspot.com",
//             messagingSenderId: "823339470062"
//         };
//         firebase.initializeApp(config);
//     }
//
//     function uploadFiles(event){
//
//         files = event.target.files;
//
//         var data = new FormData();
//
//         $.each(files, function(key, value)
//         {
//             data.append(key, value);
//         });
//
//         $('#fileNameViewer').val(this.files[0].name);
//
//
//
//         $.ajax({
//             url: '',
//             type: 'POST',
//             data: data,
//             cache: false,
//             dataType: 'json',
//             processData: false,
//             contentType: false,
//
//             success: function(data, textStatus, jqXHR)
//             {
//                 if(typeof data.error === 'undefined')
//                 {
//                     // Success so call function to process the form
//                     submitForm(event, data);
//                 }
//                 else
//                 {
//                     // Handle errors here
//                     console.log('ERRORS: ' + data.error);
//                 }
//             },
//
//             error: function(jqXHR, textStatus, errorThrown)
//             {
//                 // Handle errors here
//                 console.log('ERRORS: ' + textStatus);
//                 // STOP LOADING SPINNER
//             }
//         });
//
//
//     }
//
//     $('input[type=file]').on('change', uploadFiles);
//
// });