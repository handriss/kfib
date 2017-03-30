$(document).ready(function(){

    var files;

    function uploadFiles(event){

        files = event.target.files;

        var data = new FormData();

        $.each(files, function(key, value)
        {
            data.append(key, value);
        });

        $('#fileNameViewer').val(this.files[0].name);

        console.log(data);


    }

    $('input[type=file]').on('change', uploadFiles);

});

// $('#fileInput').change(function(){
//
//     // // console.log('fileinput changed');
//     // console.log(this.files[0].name);
//
//     $('#fileNameViewer').val(this.files[0].name);
// });