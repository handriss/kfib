$(document).ready(function() {

    var hungarian = {
        "lengthMenu": "Oldalméret: _MENU_",
        "zeroRecords": "A táblázatban nincsenek adatok",
        "info": "_PAGE_. oldal a(z) _PAGES_ oldalból",
        "infoEmpty": "A táblázatban nincsenek adatok",
        "infoFiltered": "(_MAX_ elem közül kiválasztva)",
        "sSearch": "Keresés:",
        oPaginate: {sFirst: "Első", sLast: "Utolsó", sNext: "Következő", sPrevious: "Előző"}
    };

    $('#post-list').DataTable({
        "language": hungarian
    });

    $('#file-list').DataTable({
        "language": hungarian
    });


} );

// ---------------------------------------------------------------------------------------------------------------------
// JS for file upload page

+ function($) {
    'use strict';

    // UPLOAD CLASS DEFINITION
    // ======================

    var dropZone = document.getElementById('drop-zone');
    var uploadForm = document.getElementById('js-upload-form');

    var startUpload = function(files) {
        console.log(files)
    }

    uploadForm.addEventListener('submit', function(e) {
        var uploadFiles = document.getElementById('js-upload-files').files;
        e.preventDefault()

        startUpload(uploadFiles)
    })

    dropZone.ondrop = function(e) {
        e.preventDefault();
        this.className = 'upload-drop-zone';

        startUpload(e.dataTransfer.files)
    }

    dropZone.ondragover = function() {
        this.className = 'upload-drop-zone drop';
        return false;
    }

    dropZone.ondragleave = function() {
        this.className = 'upload-drop-zone';
        return false;
    }

}(jQuery);