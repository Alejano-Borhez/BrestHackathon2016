$( document ).ready(function() {
    console.log( "ready!" );
    $("#events-item").click(function() {
        $('#event-list').empty();
        $.get('/application/events', function(events) {
            events.map(function(x) {
                var $item = $('<div>', {
                    'class' : 'col-lg-4',
                    'html': $('<div>', {
                        'class' : 'thumbnail',
                        'html' : $('<img>', {
                            'src': 'img/events/' + x.eventId + '.jpg'
                         }).add( $('<div>', {
                            'class' : 'caption',
                            'html' : $('<h3>', { 'html' : x.eventName })
                                .add( $('<p>').html(x.eventDescription) )
                                .add(  $('<p>', {
                                    'html' : $('<a>', {
                                        'href' : '#',
                                        'class' : 'btn btn-primary',
                                        'role' : 'button',
                                        'html' : 'Show'
                                    })
                                }))
                         }))
                    })
                });
                return $item;
            }).forEach(function(x) { $('#event-list').append(x); });
        });
    });
    $("#events-item").trigger('click');
});