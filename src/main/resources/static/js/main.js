$(document).ready(function() {
    $('#post-list').DataTable();

    $('.textarea').wysihtml5({
        toolbar: {
            fa: true
        }
    });
} );