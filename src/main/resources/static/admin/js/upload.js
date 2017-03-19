$("#uploadButton").click(function(){

    $("#progressBar").attr({value:0,max:100});


    var formData = new FormData($("#uploadForm")[0]);
    $.ajax({
        url: '/',  //server script to process data
        type: 'POST',
        xhr: function() {  // custom xhr
            myXhr = $.ajaxSettings.xhr();
            if(myXhr.upload){ // check if upload property exists
                myXhr.upload.addEventListener('progress',function (evt){
                    if(evt.lengthComputable){
                        $("#progressBar").attr({value:evt.loaded,max:evt.total});
                    }
                }, false); // for handling the progress of the upload
            }
            return myXhr;
        },
        //Ajax events
        //beforeSend: beforeSendHandler,
        success:  function(data) {
            if (data.successMessage){//
                //set progress to 100%
                $("#progressBar").attr({value:100,max:100});
            }
            if (data.errorMessage){
                console.log("error uploading file");
            }
        },
        data: formData,
        cache: false,
        contentType: false,
        processData: false
    });

});