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
