$(function() {
    var index = 0;
    var order;

    $('#boards tr td').click(function() {
        var position = $(this).attr('id');
        var value = index % 2;

        if (value == 0) {
            order = position;
        } else {
             $chessForm = $('#chessForm');
             $chessForm.find('#order').val(order);
             console.log($chessForm.find('#order').val());
             $chessForm.find('#target').val(position);
             console.log($chessForm.find('#target').val());
             $chessForm.submit();
        }

        index++;
        return false;
    });
});