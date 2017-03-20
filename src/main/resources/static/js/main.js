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

$(document).ready(function(){
    var i=1;
    $("#add_row").click(function(){
        $('#addr'+i).html("</td><td><input name='input-file-preview"+i+"' type='file' class='form-control input-md'/></td>");

        $('#tab_logic').append('<tr id="addr'+(i+1)+'"></tr>');
        i++;
    });
    $("#delete_row").click(function(){
        if(i>1){
            $("#addr"+(i-1)).html('');
            i--;
        }
    });

});

// ---------------------------------------------------------------------------------------------------------------------
// JS for uploading posts

(function($){
    function floatLabel(inputType){
        $(inputType).each(function(){
            var $this = $(this);
            // on focus add cladd active to label
            $this.focus(function(){
                $this.next().addClass("active");
            });
            //on blur check field and remove class if needed
            $this.blur(function(){
                if($this.val() === '' || $this.val() === 'blank'){
                    $this.next().removeClass();
                }
            });
        });
    }
    // just add a class of "floatLabel to the input field!"
    floatLabel(".floatLabel");
})(jQuery);

// ---------------------------------------------------------------------------------------------------------------------
// Js for tag selection

$(function() {
    $('#search').on('keyup', function() {
        var pattern = $(this).val();
        $('.searchable-container .items').hide();
        $('.searchable-container .items').filter(function() {
            return $(this).text().match(new RegExp(pattern, 'i'));
        }).show();
    });
});

// ---------------------------------------------------------------------------------------------------------------------
// Js for passing parameters to modals

$('#confirm-delete').on('click', '.btn-ok', function(e) {
    var $modalDiv = $(e.delegateTarget);
    var id = $(this).data('recordId');
    // $.ajax({url: '/api/record/' + id, type: 'DELETE'})
    // $.post('/api/record/' + id).then()
    $modalDiv.addClass('loading');
    setTimeout(function() {
        $modalDiv.modal('hide').removeClass('loading');
    }, 1000)
});
$('#confirm-delete').on('show.bs.modal', function(e) {
    var data = $(e.relatedTarget).data();
    $('.title', this).text('/admin/delete-post/' + data.recordTitle);
    $('.btn-ok', this).data('recordId', data.recordId);
});