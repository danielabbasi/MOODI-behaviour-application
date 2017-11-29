var selector = '.nav li';

$(selector).on('click', function(){
    $(selector).removeClass('actives');
    $(this).addClass('actives');
});